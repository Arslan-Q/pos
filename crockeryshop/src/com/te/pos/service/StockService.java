package com.te.pos.service;

import java.util.List;

import com.te.pos.dao.StockDAO;
import com.te.pos.model.Stock;

public class StockService {

	public List<Stock> getStock() throws Exception{
		return new StockDAO().getStock();
	}

	public void saveStock(Long itemId, Long purchasePrice, Long sellingPrice, Long quantity) throws Exception{
		new StockDAO().saveStock(itemId,purchasePrice,sellingPrice,quantity);
	}

	public void updateStock(Long itemId, Long purchasePrice, Long sellingPrice, Long stockQuantity) throws Exception{
		new StockDAO().modifyStock(itemId,purchasePrice,sellingPrice,stockQuantity);
	}

	
	
	
}
