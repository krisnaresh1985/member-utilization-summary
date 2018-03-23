package com.member.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "member_utilization_summary")
public class MemberUtilizationSummary {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="uid")
	@JsonProperty("Uid")
	private String uid;
	private String memberId;
	private String subId;
	private String memberPartyId;
	private String memberName;
	private String accountNumber;
	private String groupSectionNumber;
	private String socialSN;
	private String relationship;
	private String gender;
	private String dateOfBirth;
	private String planPeriod;
	private String benefitPeriod;
	private String networkType;
	private String accumType;
	private String corpEntityCode;

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getSubId() {
		return subId;
	}
	public void setSubId(String subId) {
		this.subId = subId;
	}
	public String getMemberPartyId() {
		return memberPartyId;
	}
	public void setMemberPartyId(String memberPartyId) {
		this.memberPartyId = memberPartyId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getGroupSectionNumber() {
		return groupSectionNumber;
	}
	public void setGroupSectionNumber(String groupSectionNumber) {
		this.groupSectionNumber = groupSectionNumber;
	}
	public String getSocialSN() {
		return socialSN;
	}
	public void setSocialSN(String socialSN) {
		this.socialSN = socialSN;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPlanPeriod() {
		return planPeriod;
	}
	public void setPlanPeriod(String planPeriod) {
		this.planPeriod = planPeriod;
	}
	public String getBenefitPeriod() {
		return benefitPeriod;
	}
	public void setBenefitPeriod(String benefitPeriod) {
		this.benefitPeriod = benefitPeriod;
	}
	public String getNetworkType() {
		return networkType;
	}
	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}
	public String getAccumType() {
		return accumType;
	}
	public void setAccumType(String accumType) {
		this.accumType = accumType;
	}
	public String getCorpEntityCode() {
		return corpEntityCode;
	}
	public void setCorpEntityCode(String corpEntityCode) {
		this.corpEntityCode = corpEntityCode;
	}

}
