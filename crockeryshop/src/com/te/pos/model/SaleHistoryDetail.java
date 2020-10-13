package com.te.pos.model;

public class SaleHistoryDetail {

	
	private Long saleDetailId;
	private Long itemId;
	private String itemName;
	private String salePrice;
	private String quantity; 
	private Long itemCategoryId;
	private String itemCategoryName;
	
	
	
	public SaleHistoryDetail(Long saleDetailId, Long itemId, String itemName, String salePrice, String quantity,
			Long itemCategoryId, String itemCategoryName) {
		this.saleDetailId = saleDetailId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.salePrice = salePrice;
		this.quantity = quantity;
		this.itemCategoryId = itemCategoryId;
		this.itemCategoryName = itemCategoryName;
	}
	public Long getSaleDetailId() {
		return saleDetailId;
	}
	public void setSaleDetailId(Long saleDetailId) {
		this.saleDetailId = saleDetailId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Long getItemCategoryId() {
		return itemCategoryId;
	}
	public void setItemCategoryId(Long itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}
	public String getItemCategoryName() {
		return itemCategoryName;
	}
	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}
	
	
	
}
