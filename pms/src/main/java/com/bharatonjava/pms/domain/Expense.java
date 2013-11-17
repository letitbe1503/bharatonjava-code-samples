package com.bharatonjava.pms.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="EXPENSE")
public class Expense {

	private Long expenseId;
	private Double amount;
	private Date expenseDate;
	private String comment;
	
	private Enumeration expenseType;
	
	public Expense() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EXPENSE_ID")
	public Long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}

	@Column(name="AMOUNT")
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name="EXPENSE_DATE")
	public Date getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}

	@Column(name="COMMENT")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@ManyToOne
    @JoinColumn(name="ENUM_ID")
	public Enumeration getExpenseType() {
		return expenseType;
	}
	
	public void setExpenseType(Enumeration expenseType) {
		this.expenseType = expenseType;
	}
	
}
