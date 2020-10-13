package com.te.pos.model;

public class ItemCategory {

	private Long itemCategoryId;
	private String itemCategoryName;

	
	
	public ItemCategory(Long itemCategoryId, String itemCategoryName) {
		this.itemCategoryId = itemCategoryId;
		this.itemCategoryName = itemCategoryName;
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
