package com.te.pos.model;

import java.util.ArrayList;
import java.util.Date;

public class Checkout {

	
	private String totalBill;
	private Date soldDate;
	private ArrayList<CheckoutDetail> checkoutDetailList;
	private String customerName;
	private String phoneNumber;
	
	public String getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}
	
	public Date getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}
	public ArrayList<CheckoutDetail> getCheckoutDetailList() {
		return checkoutDetailList;
	}
	public void setCheckoutDetailList(ArrayList<CheckoutDetail> checkoutDetailList) {
		this.checkoutDetailList = checkoutDetailList;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
