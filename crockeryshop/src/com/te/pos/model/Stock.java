package com.te.pos.model;

public class Stock {

	private Long stockId;
	private Long itemId;
	private String itemName;
	private Long itemCategoryId;
	private String itemCategoryName;
	private String itemPurchasePrice;
	private String itemSalePrice;
	private String quantity;
	
	public Stock() {
		
	}
	
	public Stock(Long stockId, Long itemId, String itemName, Long itemCategoryId, String itemCategoryName,
			String itemPurchasePrice, String itemSalePrice, String quantity) {
		this.stockId = stockId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategoryId = itemCategoryId;
		this.itemCategoryName = itemCategoryName;
		this.itemPurchasePrice = itemPurchasePrice;
		this.itemSalePrice = itemSalePrice;
		this.quantity = quantity;
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
