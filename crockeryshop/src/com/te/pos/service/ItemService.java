package com.te.pos.service;

import java.util.List;

import com.te.pos.dao.ItemDAO;
import com.te.pos.model.Item;
import com.te.pos.model.ItemCategory;

public class ItemService {

	public List<ItemCategory> getItemCategory() throws Exception{
		return new ItemDAO().getItemCategory();
	}

	public void saveItem(Long itemCategoryId, String itemName) throws Exception{
		new ItemDAO().saveItem(itemCategoryId,itemName);
	}
	public int checkItemExistence(Long itemCategoryId, String itemName) throws Exception{
		return new ItemDAO().checkItemExistence(itemCategoryId, itemName);
		
	}

	public void saveItemCategory(String itemCategory) throws Exception{
		new ItemDAO().saveItemCategory(itemCategory);
	}
	
	public int checkItemCategoryExistence(String itemCategory) throws Exception{
		return new ItemDAO().checkItemCategoryExistence(itemCategory);
	}

	public List<Item> getItems() throws Exception{
		return new ItemDAO().getItems();
	}

}
