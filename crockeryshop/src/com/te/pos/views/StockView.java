package com.te.pos.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.te.pos.model.Stock;
import com.te.pos.service.StockService;

@SuppressWarnings("serial")
public class StockView extends JFrame  {

	private JPanel contentPane;
	private JTable table;
	
	
	
	/**
	 * Create the frame.
	 */
	public StockView() {
		setTitle("Stock View");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation(400, 150);

		
		contentPane.setBackground(SystemColor.activeCaption);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 1200, 50);
		topPanel.setLayout(null);
		topPanel.setBackground(new Color(71, 120, 197));
		contentPane.add(topPanel);
		
		JLabel lblDashboard = new JLabel("Stock Detail");
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Verdana", Font.BOLD, 22));
		lblDashboard.setBounds(10, 0, 210, 41);
		topPanel.add(lblDashboard);
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 1150, 600);
		contentPane.add(scrollPane);
		
	    // Column Names 
	    String[] columnNames = { "ID", "Item Category", "Item Name","Purchase Price", "Sale Price", "Quantity" }; 
	    
	    DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
	    	@Override
	    	public boolean isCellEditable(int row, int column) {
	    		return false;
	    	}
	    };  
	    table = new JTable(model);
	    table = new JTable(model);
	    table.setForeground(Color.BLACK);
	    table.setFont(new Font("Verdana", Font.PLAIN, 16));
	    table.setBorder(null);
	    table.setBackground(Color.WHITE);
	    table.setRowHeight(40);
	    
	    JTableHeader header=table.getTableHeader();
	    header.setFont(new Font("Tahome", Font.BOLD, 20));
	    header.setBackground(new Color(71, 120, 197));
	    header.setForeground(Color.WHITE);
	    table.setSize(0, 600);
	    try {
			List<Stock> stockList=new StockService().getStock();
			if(stockList!=null && stockList.size()>0) {
				DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
				for (Stock stock : stockList) {
					tablemodel.addRow(new Object[]{stock.getStockId(), stock.getItemCategoryName(), stock.getItemName(),stock.getItemPurchasePrice(),stock.getItemSalePrice(),stock.getQuantity()});	
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	    
	    
	    
	    
	    scrollPane.setViewportView(table);
		
		JButton cancelBTN = new JButton("Cancel");
		cancelBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelBTN.setFont(new Font("Verdana", Font.BOLD, 20));
		cancelBTN.setBackground(new Color(71, 120, 197));
		cancelBTN.setForeground(Color.WHITE);
		cancelBTN.setBorder(null);
		cancelBTN.setBounds(1000, 680, 153, 41);
		contentPane.add(cancelBTN);
		
		JButton addStockBTN = new JButton("Update Stock");
		addStockBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UpdateStockView updateStockView=new UpdateStockView();
				updateStockView.setVisible(true);
				
			}
		});
		addStockBTN.setFont(new Font("Verdana", Font.BOLD, 20));
		addStockBTN.setBackground(new Color(71, 120, 197));
		addStockBTN.setForeground(Color.WHITE);
		addStockBTN.setBorder(null);
		addStockBTN.setBounds(840, 680, 153, 41);
		contentPane.add(addStockBTN);
		
		
	}

	
}
