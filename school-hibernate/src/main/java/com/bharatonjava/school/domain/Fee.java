package com.bharatonjava.school.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FEE")
public class Fee {

	private Long feeId;
	private Date feeDate;
	private Double amount;
	private String comment;
	
	Student student;
	
	public Fee() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FEE_ID")
	public Long getFeeId() {
		return feeId;
	}

	public void setFeeId(Long feeId) {
		this.feeId = feeId;
	}

	
	@Column(name = "FEE_DATE", nullable = false)
	@Temporal(value = TemporalType.DATE)
	public Date getFeeDate() {
		return feeDate;
	}
	
	public void setFeeDate(Date feeDate) {
		this.feeDate = feeDate;
	}
	
	@Column(name = "AMOUNT")
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "COMMENT")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STUDENT_ID", nullable = false)
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Fee [feeId=" + feeId + ", feeDate=" + feeDate + ", amount="
				+ amount + ", comment=" + comment + ", student=" + student
				+ "]";
	}
	
}
