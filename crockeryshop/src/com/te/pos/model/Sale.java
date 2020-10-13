package com.te.pos.model;

public class Sale {

	private Long stockId;
	private Long itemId;
	private String itemName;
	private String itemPurchasePrice;
	private String itemSalePrice;
	private String quantity;
	private Long itemCategoryId;
	private String itemCategoryName;
	
	
	
	
	public Sale(Long stockId, Long itemId, String itemName, String itemPurchasePrice, String itemSalePrice,
			String quantity, Long itemCategoryId, String itemCategoryName) {
		this.stockId = stockId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPurchasePrice = itemPurchasePrice;
		this.itemSalePrice = itemSalePrice;
		this.quantity = quantity;
		this.itemCategoryId = itemCategoryId;
		this.itemCategoryName = itemCategoryName;
	}
	public Long getStockId() {
		return stockId;
	}
	public void setStockId(Long stockId) {
		this.stockId = stockId;
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
	public String getItemPurchasePrice() {
		return itemPurchasePrice;
	}
	public void setItemPurchasePrice(String itemPurchasePrice) {
		this.itemPurchasePrice = itemPurchasePrice;
	}
	public String getItemSalePrice() {
		return itemSalePrice;
	}
	public void setItemSalePrice(String itemSalePrice) {
		this.itemSalePrice = itemSalePrice;
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
