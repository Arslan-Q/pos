package com.te.pos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.te.pos.db.DBConnect;
import com.te.pos.model.Checkout;
import com.te.pos.model.CheckoutDetail;
import com.te.pos.model.Stock;

public class StockDAO {

	public void updateStock(Checkout checkout) throws Exception{
		Connection connection=DBConnect.connectDatabase();
		if(checkout.getCheckoutDetailList()!=null && checkout.getCheckoutDetailList().size()>0) {
			for (CheckoutDetail checkoutDetail : checkout.getCheckoutDetailList()) {
				String stockQuery="select * from stock where item_id="+checkoutDetail.getItemId();
				Statement statement = connection.createStatement();
				ResultSet resultSet=statement.executeQuery(stockQuery);
				if(resultSet.next()) {
					Stock stock=new Stock();
					stock.setStockId(resultSet.getLong("stock_id"));
					stock.setItemId(resultSet.getLong("item_id"));
					stock.setItemPurchasePrice(resultSet.getString("item_purchase_price"));
					stock.setItemSalePrice(resultSet.getString("item_sale_price"));
					String quantity= resultSet.getString("quantity");
					
					Long remainingQuantity=Long.parseLong(quantity)-Long.parseLong(checkoutDetail.getQuantity());
					String updateQuery=" update stock set quantity='"+remainingQuantity+"' where item_id="+checkoutDetail.getItemId();
					statement.executeUpdate(updateQuery);
				}
				
				if(resultSet!=null && !resultSet.isClosed()) {
					resultSet.close();
				}
				
				if(statement!=null && !statement.isClosed()) {
					statement.close();
				}
			}
		}
		
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
	}

	public List<Stock> getStock() throws Exception{
		List<Stock> saleList=new ArrayList<Stock>();
		Connection connection=DBConnect.connectDatabase();
		Statement statement=connection.createStatement();
		String query="select stock_id,it.item_id,it.item_name,item_purchase_price,item_sale_price,quantity," + 
				" itc.item_category_id,itc.item_category_name from stock st " + 
				" LEFT JOIN item AS it  ON st.item_id=it.item_id" + 
				" LEFT JOIN item_category AS itc  ON it.item_category_id=itc.item_category_id";
		ResultSet resultSet=statement.executeQuery(query);
		while (resultSet.next()) {
			Long stockId=resultSet.getLong("stock_id");
			Long itemId=resultSet.getLong("item_id");
			String itemName=resultSet.getString("item_name");
			String itemPurchasePrice=resultSet.getString("item_purchase_price");
			String itemSalePrice=resultSet.getString("item_sale_price");
			String quantity=resultSet.getString("quantity");
			Long itemCategoryId=resultSet.getLong("item_category_id");
			String itemCategoryName=resultSet.getString("item_category_name");	
			Stock stock=new Stock(stockId, itemId, itemName, itemCategoryId, itemCategoryName, itemPurchasePrice, itemSalePrice, quantity);
			saleList.add(stock);
		}
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
		return saleList;
	}

	public void saveStock(Long itemId, Long purchasePrice, Long sellingPrice, Long quantity) throws Exception{

		Connection connection=DBConnect.connectDatabase();
		Statement statement = connection.createStatement();
		String updateQuery=" insert into stock (item_id,item_purchase_price,item_sale_price,quantity) values ("+itemId+",'"+purchasePrice+"','"+sellingPrice+"','"+quantity+"')";
		statement.executeUpdate(updateQuery);
		
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
	
	}

	public Stock getStockByItemId(Long id) throws Exception{
		Stock stock=null;
		Connection connection=DBConnect.connectDatabase();
		Statement statement=connection.createStatement();
		String query="select stock_id,it.item_id,it.item_name,item_purchase_price,item_sale_price,quantity," + 
				" itc.item_category_id,itc.item_category_name from stock st " + 
				" LEFT JOIN item AS it  ON st.item_id=it.item_id" + 
				" LEFT JOIN item_category AS itc  ON it.item_category_id=itc.item_category_id where st.item_id="+id;
		ResultSet resultSet=statement.executeQuery(query);
		if (resultSet.next()) {
			Long stockId=resultSet.getLong("stock_id");
			Long itemId=resultSet.getLong("item_id");
			String itemName=resultSet.getString("item_name");
			String itemPurchasePrice=resultSet.getString("item_purchase_price");
			String itemSalePrice=resultSet.getString("item_sale_price");
			String quantity=resultSet.getString("quantity");
			Long itemCategoryId=resultSet.getLong("item_category_id");
			String itemCategoryName=resultSet.getString("item_category_name");	
			stock=new Stock(stockId, itemId, itemName, itemCategoryId, itemCategoryName, itemPurchasePrice, itemSalePrice, quantity);
		}
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
		return stock;
	}

	public void modifyStock(Long itemId, Long purchasePrice, Long sellingPrice, Long stockQuantity) throws Exception{

		Connection connection=DBConnect.connectDatabase();
		Statement statement = connection.createStatement();
		String updateQuery=" update stock set quantity='"+stockQuantity+"',item_purchase_price='"+purchasePrice+"', item_sale_price='"+sellingPrice+"'"
				+ "  where item_id="+itemId;
		statement.executeUpdate(updateQuery);
		
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
	
	}
	

}
