package com.te.pos.service;

import java.util.Date;
import java.util.List;

import com.te.pos.dao.SaleDAO;
import com.te.pos.model.Checkout;
import com.te.pos.model.Sale;
import com.te.pos.model.SaleHistory;
import com.te.pos.model.SaleHistoryDetail;

public class SaleService {

	

	public List<Sale> getSale() throws Exception{
		return new SaleDAO().getSaleItems();
	}

	public void checkout(String totalPrice,Checkout checkOut) throws Exception{
		new SaleDAO().checkout(checkOut);
	}

	public List<SaleHistory> getSaleHistory(Date selectedDate) throws Exception{
		return  new SaleDAO().getSaleHistory(selectedDate);
	}

	public List<SaleHistoryDetail> getSaleHistoryDetail(Long saleId) throws Exception{
		return new SaleDAO().getSaleHistoryDetail(saleId);
	}



}
