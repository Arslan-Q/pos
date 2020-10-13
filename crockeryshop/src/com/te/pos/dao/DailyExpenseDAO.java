package com.te.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.te.pos.db.DBConnect;
import com.te.pos.model.DailyExpense;

public class DailyExpenseDAO {

	public List<DailyExpense> getDailyExpenses(Date selectedDate) throws Exception{
		List<DailyExpense> dailyExpenseList=new ArrayList<DailyExpense>();
		Connection connection=DBConnect.connectDatabase();
		Statement statement=connection.createStatement();
		String query="";
		if(selectedDate!=null) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			String expenseDate = dateFormat.format(selectedDate);  
			query="select * from daily_expenses where date(daily_expense_date)='"+expenseDate+"'";
		}else {
			query="select * from daily_expenses where date(daily_expense_date)=CURRENT_DATE()";
		}
		ResultSet resultSet=statement.executeQuery(query);
		while (resultSet.next()) {
			String expenseCategory= "Expense";
			String expenseDescription=resultSet.getString("daily_expense_description");
			String expenseAmount=resultSet.getString("daily_expense_amount");
			String expenseDate=resultSet.getString("daily_expense_date");
			DailyExpense dailyExpense=new DailyExpense(expenseCategory, expenseDescription, expenseAmount,expenseDate);
			dailyExpenseList.add(dailyExpense);
		}
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
		return dailyExpenseList;
	}
	
	public void insertDailyExpenses(DailyExpense dailyExpense) throws SQLException {

		Integer itemId=0;
		Connection connection=DBConnect.connectDatabase();
		PreparedStatement statement =null; 
		String itemQuery="INSERT into daily_expenses (daily_expense_category,daily_expense_description,daily_expense_amount,daily_expense_date) VALUES('"+dailyExpense.getExpenseCategory()+"','"+dailyExpense.getExpenseDescription()+"','"+dailyExpense.getExpenseAmount()+"','"+dailyExpense.getExpenseDate()+"')";
		statement = connection.prepareStatement(itemQuery,Statement.RETURN_GENERATED_KEYS);
		statement.executeUpdate();
		ResultSet resultSet = statement.getGeneratedKeys();
		  if (resultSet.next()) {
			  itemId = resultSet.getInt(1);
		  }
		
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
	


		
	}
	
}
