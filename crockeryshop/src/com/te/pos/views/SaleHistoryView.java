package com.te.pos.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.te.pos.misc.Utilities;
import com.te.pos.model.SaleHistory;
import com.te.pos.service.SaleService;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

@SuppressWarnings("serial")
public class SaleHistoryView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JDatePickerImpl datePicker = null;
	private JTextField totalSale;
	/**
	 * Create the frame.
	 */
	public SaleHistoryView() {
		setTitle("Sale History");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(SystemColor.activeCaption);
		
		setLocation(400, 150);

		contentPane.setBackground(SystemColor.activeCaption);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 1300, 50);
		topPanel.setLayout(null);
		topPanel.setBackground(new Color(71, 120, 197));
		contentPane.add(topPanel);
		
		JLabel lblDashboard = new JLabel("Sale History");
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Verdana", Font.BOLD, 22));
		lblDashboard.setBounds(10, 0, 172, 41);
		topPanel.add(lblDashboard);
		
		totalSale = new JTextField();
		totalSale.setFont(new Font("Verdana", Font.BOLD, 18));
		totalSale.setColumns(10);
		totalSale.setBorder(null);
		totalSale.setBounds(1010, 600, 140, 41);
		totalSale.setEditable(false);
		contentPane.add(totalSale);
		
		
		UtilDateModel datemodel = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(datemodel);
		datePicker = new JDatePickerImpl(datePanel);		
		datePicker.setLocation(199, 60);
		datePicker.setSize(350, 50);
		  datePicker.getComponent(0).setPreferredSize(new Dimension(100,20)); //JFormattedTextField
		    datePicker.getComponent(1).setPreferredSize(new Dimension(40,20));//JButton
		contentPane.add(datePicker);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 130, 1000, 450);
		
		contentPane.add(scrollPane);
		
	    // Column Names 
	    String[] columnNames = { "ID","Customer Name","Phone Number","Total Bill", "Date" }; 
	    
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
	    table.setSize(400, 600);

	    try {
	    	String saleDate=datePicker.getJFormattedTextField().getText();
	    	System.out.println("sale date -> "+saleDate);
			List<SaleHistory> saleHistoryList=new SaleService().getSaleHistory(null);
			if(saleHistoryList!=null && saleHistoryList.size()>0) {
				DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
				Long totalBill=0L;
				for (SaleHistory saleHistory : saleHistoryList) {
					tablemodel.addRow(new Object[]{saleHistory.getSaleId(),saleHistory.getCustomerName(),saleHistory.getPhoneNo(), saleHistory.getTotalBill(), saleHistory.getSoldDate()});
					totalBill=totalBill+Utilities.getLongObject(saleHistory.getTotalBill());
				}
				totalSale.setText(String.valueOf(totalBill));
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
		cancelBTN.setBounds(1000, 650, 153, 41);
		contentPane.add(cancelBTN);
		
		
		
		
		JButton btnViewDetail = new JButton("View Detail");
		btnViewDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   int[] rows = table.getSelectedRows();
				   if(rows.length!=0) {
					   String saleId = table.getValueAt(rows[0], 0).toString();
					   SaleHistoryDetailView saleHistoryDetailView=new SaleHistoryDetailView(saleId);
					   saleHistoryDetailView.setVisible(true);
					   System.out.println("saleId--->>>  "+saleId);
				   }else{
					   JOptionPane.showMessageDialog(null, "Please select sale to view details.");
				   }
				
			}
		});
		
		btnViewDetail.setFont(new Font("Verdana", Font.BOLD, 20));
		btnViewDetail.setBackground(new Color(71, 120, 197));
		btnViewDetail.setForeground(Color.WHITE);
		btnViewDetail.setBorder(null);
		btnViewDetail.setBounds(835, 650, 153, 41);
		contentPane.add(btnViewDetail);
		
		
		
		JLabel lblTotalSale = new JLabel("Total Sale:");
		lblTotalSale.setForeground(Color.WHITE);
		lblTotalSale.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTotalSale.setBounds(880, 600, 117, 41);
		contentPane.add(lblTotalSale);
		
		JButton btnViewDetail_1 = new JButton("View Detail");
		btnViewDetail_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String saleDate=datePicker.getJFormattedTextField().getText();
					System.out.println("sale date -> "+saleDate);
					if(saleDate!=null && !saleDate.equals("")) {
						table.setModel(new DefaultTableModel(columnNames,0));
						totalSale.setText("");
						Date date1=new SimpleDateFormat("MMM dd, yyyy").parse(saleDate);
						List<SaleHistory> saleHistoryList=new SaleService().getSaleHistory(date1);
						if(saleHistoryList!=null && saleHistoryList.size()>0) {
							DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
							Long totalBill=0L;
							for (SaleHistory saleHistory : saleHistoryList) {
								tablemodel.addRow(new Object[]{saleHistory.getSaleId(),saleHistory.getCustomerName(),saleHistory.getPhoneNo(), saleHistory.getTotalBill(), saleHistory.getSoldDate()});
								totalBill=totalBill+Utilities.getLongObject(saleHistory.getTotalBill());
							}
							totalSale.setText(String.valueOf(totalBill));
						}
					}else {
						JOptionPane.showMessageDialog(null, "Please select date.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnViewDetail_1.setFont(new Font("Verdana", Font.BOLD, 20));
		btnViewDetail_1.setBackground(new Color(71, 120, 197));
		btnViewDetail_1.setForeground(Color.WHITE);	
		btnViewDetail_1.setBounds(580,60, 170, 45);
		contentPane.add(btnViewDetail_1);
	}
	
}
