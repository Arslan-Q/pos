package com.te.pos.model;


public class DailyExpense {

	private String expenseCategory;
	private String expenseDescription;
	private String expenseAmount;
	private String expenseDate;
	
	public DailyExpense(String expenseCategory, String expenseDescription, String expenseAmount, String expenseDate) {
		this.expenseCategory = expenseCategory;
		this.expenseDescription = expenseDescription;
		this.expenseAmount = expenseAmount;
		this.expenseDate = expenseDate;
	}

	public String getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(String expenseCategory) {
		this.expenseCategory = expenseCategory;
	}

	public String getExpenseDescription() {
		return expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}

	public String getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(String expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public String getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(String expenseDate) {
		this.expenseDate = expenseDate;
	}

	@Override
	public String toString() {
		return "DailyExpense [expenseCategory=" + expenseCategory + ", expenseDescription=" + expenseDescription
				+ ", expenseAmount=" + expenseAmount + ", expenseDate=" + expenseDate + "]";
	}
	
	
	
}
