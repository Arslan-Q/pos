package com.te.pos.model;

public class Item {

	
	private Long itemId;
	private String itemName;
	private Long itemCategoryId;
	private String itemCategoryName;
	
	public Item() {

	}
	
	public Item(Long itemId, String itemName,Long itemCategoryId,String itemCategoryName) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategoryId=itemCategoryId;
		this.itemCategoryName=itemCategoryName;
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
