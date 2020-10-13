package com.te.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.te.pos.db.DBConnect;
import com.te.pos.model.Checkout;
import com.te.pos.model.CheckoutDetail;
import com.te.pos.model.Sale;
import com.te.pos.model.SaleHistory;
import com.te.pos.model.SaleHistoryDetail;

public class SaleDAO {

	public List<Sale> getSaleItems() throws Exception{
		List<Sale> saleList=new ArrayList<Sale>();
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
			Sale sale=new Sale(stockId, itemId, itemName, itemPurchasePrice, itemSalePrice, quantity, itemCategoryId, itemCategoryName);
			saleList.add(sale);
		}
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
		return saleList;
	}

	public void checkout(Checkout checkout) throws Exception{
		Integer saleId=0;
		Connection connection=DBConnect.connectDatabase();
		PreparedStatement statement =null; 
		String saleQuery="insert into sale (total_bill,sold_date,customerName,phoneNo) values ('"+checkout.getTotalBill()+"',now(),'"+checkout.getCustomerName()+"','"+checkout.getPhoneNumber()+"')";
		statement = connection.prepareStatement(saleQuery,Statement.RETURN_GENERATED_KEYS);
		statement.executeUpdate();
		ResultSet resultSet = statement.getGeneratedKeys();
		  if (resultSet.next()) {
			  saleId = resultSet.getInt(1);
		  }
		if(checkout.getCheckoutDetailList()!=null && checkout.getCheckoutDetailList().size()>0) {
			for (CheckoutDetail checkoutDetail : checkout.getCheckoutDetailList()) {
				String saleDetailQuery="insert into sale_detail (item_id,sale_price,quantity,sale_id) values ("+checkoutDetail.getItemId()+","+checkoutDetail.getSalePrice()+","+checkoutDetail.getQuantity()+","+saleId+")";
				statement.executeUpdate(saleDetailQuery);
			}
		}
		
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
	}

	public List<SaleHistory> getSaleHistory(Date selectedDate) throws Exception{
		List<SaleHistory> saleHistoryList=new ArrayList<SaleHistory>();
		Connection connection=DBConnect.connectDatabase();
		Statement statement=connection.createStatement();
		String query="";
		if(selectedDate!=null) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			String soldDate = dateFormat.format(selectedDate);  
			query="select * from sale where date(sold_date)='"+soldDate+"'";
		}else {
			query="select * from sale where date(sold_date)=CURRENT_DATE()";
		}
		ResultSet resultSet=statement.executeQuery(query);
		while (resultSet.next()) {
			Long saleId=resultSet.getLong("sale_id");
			String totalBill=resultSet.getString("total_bill");
			String soldDate=resultSet.getString("sold_date");
			String customerName=resultSet.getString("customerName");
			String phoneNo=resultSet.getString("phoneNo");
			SaleHistory saleHistory=new SaleHistory(saleId, totalBill, soldDate,customerName,phoneNo);
			saleHistoryList.add(saleHistory);
		}
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
		return saleHistoryList;
	}
	
	
	
	public List<SaleHistoryDetail> getSaleHistoryDetail(Long saleID) throws Exception{
		List<SaleHistoryDetail> saleHistoryDetailList=new ArrayList<SaleHistoryDetail>();
		Connection connection=DBConnect.connectDatabase();
		Statement statement=connection.createStatement();
 		String query="select sale_detail_id,it.item_id,it.item_name,sale_price,quantity," + 
				"			 itc.item_category_id,itc.item_category_name from sale_detail sd " + 
				"			LEFT JOIN item AS it  ON sd.item_id=it.item_id" + 
				"			 LEFT JOIN item_category AS itc  ON it.item_category_id=itc.item_category_id where sale_id="+saleID;
		ResultSet resultSet=statement.executeQuery(query);
		while (resultSet.next()) {
			Long saleDetailId=resultSet.getLong("sale_detail_id");
			Long itemId=resultSet.getLong("item_id");
			String itemName=resultSet.getString("item_name");
			String salePrice=resultSet.getString("sale_price");
			String quantity=resultSet.getString("quantity");
			Long itemCategoryId=resultSet.getLong("item_category_id");
			String itemCategoryName=resultSet.getString("item_category_name");
			SaleHistoryDetail saleHistoryDetail=new SaleHistoryDetail(saleDetailId, itemId, itemName, salePrice, quantity, itemCategoryId, itemCategoryName);
			saleHistoryDetailList.add(saleHistoryDetail);
		}
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
		return saleHistoryDetailList;
	}
	
	
	
	
	
	
	

}
	