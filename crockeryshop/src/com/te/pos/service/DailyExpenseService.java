package com.te.pos.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.te.pos.dao.DailyExpenseDAO;
import com.te.pos.model.DailyExpense;

public class DailyExpenseService {

	public List<DailyExpense> getDailyExpenses(Date selectedDate) throws Exception{
		return new DailyExpenseDAO().getDailyExpenses(selectedDate);
	}
	
	public void insertDailyExpenses(DailyExpense dailyExpense) throws SQLException {
		new DailyExpenseDAO().insertDailyExpenses(dailyExpense);
	}

}
