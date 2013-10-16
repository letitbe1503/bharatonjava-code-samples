package com.bharatonjava.pms.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ENQUIRY")
public class Enquiry {

	private Long enquiryId;
	private Date enquiryDate;
	private String partyName;
	private String maritalStatus;
	private Integer bhk;
	private Date possessionDate;
	private Double appriximateBudget;
	private Long mobileNumber;
	private Long residencePhoneNumber;
	private Long officePhoneNumber;
	private String email;
	private String currentAddress;
	private String permanentAddress;
	private String comments;
	private String remarks;
	
	public Enquiry() {
	}

	@Id
	@Column(name = "ENQUIRY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(Long enquiryId) {
		this.enquiryId = enquiryId;
	}

	@Column(name = "ENQUIRY_DATE")
	@Temporal(TemporalType.DATE)
	public Date getEnquiryDate() {
		return enquiryDate;
	}
	
	public void setEnquiryDate(Date enquiryDate) {
		this.enquiryDate = enquiryDate;
	}
	
	@Column(name = "PARTY_NAME")
	public String getPartyName() {
		return partyName;
	}
	
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	
	@Column(name = "BHK")
	public Integer getBhk() {
		return bhk;
	}

	public void setBhk(Integer bhk) {
		this.bhk = bhk;
	}

	@Column(name = "MARITAL_STATUS")
	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Column(name = "MOBILE_NUMBER")
	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "CURRENT_ADDRESS")
	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	@Column(name = "PERMANENT_ADDRESS")
	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	@Column(name = "COMMENTS")
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Column(name = "BUDGET")
	public Double getAppriximateBudget() {
		return appriximateBudget;
	}
	
	public void setAppriximateBudget(Double appriximateBudget) {
		this.appriximateBudget = appriximateBudget;
	}
	
	@Column(name = "OFFICE_PHONE_NO")
	public Long getOfficePhoneNumber() {
		return officePhoneNumber;
	}
	
	public void setOfficePhoneNumber(Long officePhoneNumber) {
		this.officePhoneNumber = officePhoneNumber;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "POSSESSION_DATE")
	public Date getPossessionDate() {
		return possessionDate;
	}
	
	public void setPossessionDate(Date possessionDate) {
		this.possessionDate = possessionDate;
	}
	
	@Column(name = "REMARKS")
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Column(name = "RESIDENCE_PHONE_NO")
	public Long getResidencePhoneNumber() {
		return residencePhoneNumber;
	}
	
	public void setResidencePhoneNumber(Long residencePhoneNumber) {
		this.residencePhoneNumber = residencePhoneNumber;
	}
	
}
