package com.member.service;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;



/* 
 *  Service Layer which will dispatch JSON responses based on member Id
 * */
@Service
public class MemberService {
	
		
	public MemberService(){
		
	}

	public String returnJsonResponse(String memberId) throws IOException {
		String json = null;
		
		if(memberId.equals("B12345670")) {
		File file = new File("response/B12345670.json");
		json = FileUtils.readFileToString(file);
		}
		
		if(memberId.equals("C12345670")) {
		File file = new File("response/C12345670.json");
		json = FileUtils.readFileToString(file);
		}

		if(memberId.equals("D12345670")) {
		File file = new File("response/D12345670.json");
		json = FileUtils.readFileToString(file);
		}

		return json;
	}
}
