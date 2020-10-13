package com.te.pos.model;

public class SaleHistory {

	private Long saleId;
	private String totalBill;
	private String soldDate;
	private String customerName;
	private String phoneNo;
	
	public SaleHistory(Long saleId, String totalBill, String soldDate,String customerName,String phoneNo) {
		this.saleId = saleId;
		this.totalBill = totalBill;
		this.soldDate = soldDate;
		this.customerName=customerName;
		this.phoneNo=phoneNo;
	}
	
	public Long getSaleId() {
		return saleId;
	}
	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}
	public String getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}
	public String getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(String soldDate) {
		this.soldDate = soldDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
