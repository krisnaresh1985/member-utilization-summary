package com.member.resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.member.model.MemberUtilizationSummary;
import com.member.repository.MemberUtilizationSummaryRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/svc/mis/members")
@Api(value = "Accums Utilization Summary Resource")
public class MemberResources {
	
	@Autowired
	private MemberUtilizationSummaryRepository memberUtilizationSummaryRepository;

	@Autowired
    RestTemplate restTemplate;
	
    @ApiOperation(value = "Returns the Json object of utilization summary of the user ID")    
	@GetMapping("/{uid}")
    public List<MemberUtilizationSummary> getUtilizationSummary(@PathVariable("uid") final String uid) throws IOException {

    	List<MemberUtilizationSummary> memberUtilizationSummary = memberUtilizationSummaryRepository.findByUid(uid);    	
        return memberUtilizationSummary
        		.stream()
                .collect(Collectors.toList());    	

    }

    @ApiOperation(value = "Updates Database with Utilization Summary present in Json files")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Created"),
                    @ApiResponse(code = 400, message = "Not Created")
            }
    )
    @PostMapping("/updateUtilizationSummary")
    public ResponseEntity<String> updateUtilizationSummary() throws JsonParseException, JsonMappingException, IOException  {
		
		List<String> inputFileList = new ArrayList<>(Arrays.asList("B12345670.json","C12345670.json","D12345670.json"));
		
		for(String file: inputFileList){
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<MemberUtilizationSummary>> typeReference = new TypeReference<List<MemberUtilizationSummary>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/response/"+file);
		try {
			List<MemberUtilizationSummary> members = mapper.readValue(inputStream,typeReference);
			memberUtilizationSummaryRepository.save(members);
			System.out.println("Members Saved!");
			
			
		} catch (IOException e){
			System.out.println("Unable to save members: " + e.getMessage());
			return new ResponseEntity<String>("Not Created",HttpStatus.BAD_REQUEST);
		}
		}
        
		return new ResponseEntity<String>("Created",HttpStatus.CREATED);
    }


//  @GetMapping("/{memberId}")
//  public ResponseEntity<String>  getStock(@PathVariable("memberId") final String memberId) throws IOException {
//		
//  	AccumsService accums = new AccumsService(); 
//  	String response = accums.returnJsonResponse(memberId);
//  	HttpHeaders responseHeaders = new HttpHeaders();        
//      responseHeaders.set("Content-Type", "application/json");
//      return new ResponseEntity<String>(response, responseHeaders, HttpStatus.ACCEPTED);    	
//
//  }

}
