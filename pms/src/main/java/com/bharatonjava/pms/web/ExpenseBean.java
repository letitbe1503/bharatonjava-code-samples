package com.bharatonjava.pms.web;

import java.util.List;

import javax.annotation.PostConstruct;

import com.bharatonjava.pms.domain.Enumeration;
import com.bharatonjava.pms.domain.Expense;
import com.bharatonjava.pms.service.ExpenseService;
import com.bharatonjava.pms.util.Constants;

public class ExpenseBean {

	private Enumeration expenseType;
	private List<Enumeration> expenseTypes;
	private ExpenseService expenseService;
	private boolean renderExpenses = true;
	// for adding expense
	private Expense expense;
	private Enumeration selectedExpense;
	
	public ExpenseBean() {
		expenseType = new Enumeration();
	}

	public Enumeration getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(Enumeration expenseType) {
		this.expenseType = expenseType;
	}

	public List<Enumeration> getExpenseTypes() {
		return expenseTypes;
	}
	
	public void setExpenseTypes(List<Enumeration> expenseTypes) {
		this.expenseTypes = expenseTypes;
	}
	
	public ExpenseService getExpenseService() {
		return expenseService;
	}
	
	public void setExpenseService(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	public boolean isRenderExpenses() {
		return renderExpenses;
	}
	
	public void setRenderExpenses(boolean renderExpenses) {
		this.renderExpenses = renderExpenses;
	}
	
	public Expense getExpense() {
		return expense;
	}
	
	public void setExpense(Expense expense) {
		this.expense = expense;
	}
	
	public Enumeration getSelectedExpense() {
		return selectedExpense;
	}
	
	public void setSelectedExpense(Enumeration selectedExpense) {
		this.selectedExpense = selectedExpense;
	}
	
	@PostConstruct
	public void initialize(){
		expenseTypes = expenseService.getExpenseTypes();
	}
	
	public void addNewExpenseType() {
		expenseType.setEnumGroup(Constants.EXPENSE_TYPE);
		System.out.println("expenseType : "+ expenseType.getEnumName());
		expenseService.addExpenseType(expenseType);
		getAllExpenseTypes();
	}
	
	public void getAllExpenseTypes(){
		expenseTypes = expenseService.getExpenseTypes();
	}
	
	public void showExpenseScreen(){
		renderExpenses = true;
	}
	
	public void showAddExpenseScreen(){
		renderExpenses = false;
	}
	
	public void addNewExpense(){
		System.out.println("addNewExpense");
	}
}
