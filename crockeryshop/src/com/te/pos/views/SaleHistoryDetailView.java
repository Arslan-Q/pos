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

import com.te.pos.misc.Utilities;
import com.te.pos.model.SaleHistoryDetail;
import com.te.pos.service.SaleService;

@SuppressWarnings("serial")
public class SaleHistoryDetailView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	
	
	/**
	 * Create the frame.
	 */
	public SaleHistoryDetailView(String saleId) {
		setTitle("Sale History");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation(490, 150);

		contentPane.setBackground(SystemColor.activeCaption);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 1100, 50);
		topPanel.setLayout(null);
		topPanel.setBackground(new Color(71, 120, 197));
		contentPane.add(topPanel);
		
		JLabel lblDashboard = new JLabel("Sale History Detail");
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Verdana", Font.BOLD, 22));
		lblDashboard.setBounds(10, 0, 310,50);
		topPanel.add(lblDashboard);
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 50, 1000, 470);
		
		
		contentPane.add(scrollPane);
		
	    // Column Names 
	    String[] columnNames = { "ID", "Item Category", "Item Name", "Sale Price", "Quantity" }; 
	    
	    DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
	    	@Override
	    	public boolean isCellEditable(int row, int column) {
	    		return false;
	    	}
	    };  
	    table = new JTable(model);
	    table.setForeground(Color.BLACK);
	    table.setFont(new Font("Verdana", Font.PLAIN, 16));
	    table.setBorder(null);
	    table.setBackground(Color.WHITE);
	    table.setRowHeight(50);
	    
	    JTableHeader header=table.getTableHeader();
	    header.setFont(new Font("Tahome", Font.BOLD, 20));
	    header.setBackground(new Color(71, 120, 197));
	    header.setForeground(Color.WHITE);
	    table.setSize(800,800);
	    try {
			List<SaleHistoryDetail> saleHistoryList=new SaleService().getSaleHistoryDetail(Utilities.getLongObject(saleId));
			if(saleHistoryList!=null && saleHistoryList.size()>0) {
				DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
				for (SaleHistoryDetail saleHistoryDetail : saleHistoryList) {
					tablemodel.addRow(new Object[]{saleHistoryDetail.getSaleDetailId(), saleHistoryDetail.getItemCategoryName(), saleHistoryDetail.getItemName(),saleHistoryDetail.getSalePrice(),saleHistoryDetail.getQuantity()});	
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
		cancelBTN.setBounds(900,535, 153, 41);
		contentPane.add(cancelBTN);
		
		
	}



}
