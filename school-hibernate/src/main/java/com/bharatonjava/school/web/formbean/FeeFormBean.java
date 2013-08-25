package com.bharatonjava.school.web.formbean;



public class FeeFormBean {

	private Long feeId;
	private String feeDate;
	private Double amount;
	private String comment;

	private Long studentId;
	
	public FeeFormBean() {
	}

	public Long getFeeId() {
		return feeId;
	}

	public void setFeeId(Long feeId) {
		this.feeId = feeId;
	}

	public String getFeeDate() {
		return feeDate;
	}
	
	public void setFeeDate(String feeDate) {
		this.feeDate = feeDate;
	}
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "FeeFormBean [feeId=" + feeId + ", feeDate=" + feeDate
				+ ", amount=" + amount + ", comment=" + comment
				+ ", studentId=" + studentId + "]";
	}
	
}
