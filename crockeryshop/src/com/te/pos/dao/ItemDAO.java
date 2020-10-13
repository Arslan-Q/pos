package com.te.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.te.pos.db.DBConnect;
import com.te.pos.model.Item;
import com.te.pos.model.ItemCategory;

public class ItemDAO {

	public List<ItemCategory> getItemCategory() throws Exception{
		List<ItemCategory> itemCategoryList=new ArrayList<ItemCategory>();
		Connection connection=DBConnect.connectDatabase();
		Statement statement=connection.createStatement();
		String query="select * from item_category ";
		ResultSet resultSet=statement.executeQuery(query);
		while (resultSet.next()) {
			Long itemCategoryId=resultSet.getLong("item_category_id");
			String itemCategoryName=resultSet.getString("item_category_name");
			ItemCategory itemCategory=new ItemCategory(itemCategoryId, itemCategoryName);
			itemCategoryList.add(itemCategory);
		}
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
		return itemCategoryList;
	}

	public void saveItem(Long itemCategoryId, String itemName) throws Exception{

		Integer itemId=0;
		Connection connection=DBConnect.connectDatabase();
		PreparedStatement statement =null; 
		String itemQuery="insert into item (item_name,item_category_id) values (upper('"+itemName+"'),"+itemCategoryId+")";
		statement = connection.prepareStatement(itemQuery,Statement.RETURN_GENERATED_KEYS);
		statement.executeUpdate();
		ResultSet resultSet = statement.getGeneratedKeys();
		  if (resultSet.next()) {
			  itemId = resultSet.getInt(1);
			  System.out.println("Item saved..."+itemId);
		  }
		
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
	
	}

	public int checkItemExistence(Long itemCategoryId, String itemName) throws Exception{

		int rowCount=0;
		Connection connection=DBConnect.connectDatabase();
		Statement statement=connection.createStatement();

		String Query="select * from item where item_name=upper('"+itemName+"') && item_category_id ='"+itemCategoryId+"'";
		ResultSet resultSet=statement.executeQuery(Query);
		while (resultSet.next()) {
	           rowCount++;
	      }
		
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
		return rowCount;
	
	}

	public int checkItemCategoryExistence(String itemCategory) throws Exception{


		Integer rowCount=0;
		Connection connection=DBConnect.connectDatabase();
		Statement statement=connection.createStatement();
		String Query="select * from item_category where item_category_name =Upper('"+itemCategory+"')";
		ResultSet resultSet=statement.executeQuery(Query);
		while (resultSet.next()) {
	           rowCount++;
	      }
		

			
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
	return rowCount;
	
	}

	
	public void saveItemCategory(String itemCategory) throws Exception{


		Integer itemCategoryId=0;
		Connection connection=DBConnect.connectDatabase();
		PreparedStatement statement =null; 
		String itemCategoryQuery="insert into item_category (item_category_name) values (Upper('"+itemCategory+"'))";
		statement = connection.prepareStatement(itemCategoryQuery,Statement.RETURN_GENERATED_KEYS);
		statement.executeUpdate();
		ResultSet resultSet = statement.getGeneratedKeys();
		  if (resultSet.next()) {
			  itemCategoryId = resultSet.getInt(1);
			  System.out.println("Item Category saved..."+itemCategoryId);
		  }
		
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
	
	
	}
	

	public List<Item> getItems() throws Exception {
		List<Item> itemList=new ArrayList<Item>();
		Connection connection=DBConnect.connectDatabase();
		Statement statement=connection.createStatement();
		String query="select item_id,item_name,itc.item_category_id,itc.item_category_id,itc.item_category_name "
				+ " from item it LEFT JOIN item_category AS itc  ON it.item_category_id=itc.item_category_id ";
		ResultSet resultSet=statement.executeQuery(query);
		while (resultSet.next()) {
			Long itemId=resultSet.getLong("item_id");
			String itemName=resultSet.getString("item_name");
			Long itemCategoryId=resultSet.getLong("item_category_id");
			String itemCategoryName=resultSet.getString("item_category_name");
			Item item=new Item(itemId, itemName,itemCategoryId,itemCategoryName);
			itemList.add(item);
		}
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
		return itemList;
	}

}
