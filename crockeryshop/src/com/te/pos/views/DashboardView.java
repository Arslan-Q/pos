package com.te.pos.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class DashboardView extends JFrame {
	/**
	 * Create the frame.
	 * 
	 */
	 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public DashboardView() {
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,screenSize.width, screenSize.height);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
	//	setBackground(new Color(71, 120, 197));
		getContentPane().setBackground(SystemColor.activeCaption);

		setResizable(false);
		
		
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBackground(new Color(71, 120, 197));
		topPanel.setBounds(0, 0, screenSize.width, 50);
		getContentPane().add(topPanel);
		
		JLabel lblDashboard_1 = new JLabel("Dashboard");
		lblDashboard_1.setForeground(Color.WHITE);
		lblDashboard_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblDashboard_1.setBounds(10, 0, 172, 41);
		topPanel.add(lblDashboard_1);
		
		
		JPanel ContentPanel = new JPanel();
		ContentPanel.setBackground(SystemColor.activeCaption);
		ContentPanel.setBounds(300, 50, screenSize.width, screenSize.height);
		getContentPane().add(ContentPanel);
		

		
		
		
		JButton saleView = new JButton("Sale Point");
		saleView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleView frame = new SaleView();
				frame.setVisible(true);
			}
		});
		saleView.setForeground(SystemColor.windowBorder);
		saleView.setFont(new Font("Verdana", Font.BOLD, 16));
		saleView.setBorder(null);
		saleView.setBackground(new Color(75, 122, 222));
		saleView.setBounds(0, 55, 290, 70);
		saleView.setForeground(Color.white);
		saleView.setBorder(new LineBorder(Color.white));

		getContentPane().add(saleView);
		
		JButton btnSaleHistory = new JButton("Sale History");
		btnSaleHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleHistoryView frame = new SaleHistoryView();
				frame.setVisible(true);
				
			}
		});
		btnSaleHistory.setForeground(SystemColor.windowBorder);
		btnSaleHistory.setFont(new Font("Verdana", Font.BOLD, 16));
		btnSaleHistory.setBorder(null);
		btnSaleHistory.setBackground(new Color(75, 122, 222));
		btnSaleHistory.setBounds(0, 130, 290, 70);
		btnSaleHistory.setForeground(Color.white);
		btnSaleHistory.setBorder(new LineBorder(Color.white));

		getContentPane().add(btnSaleHistory);
		
		JButton btnStockManagement = new JButton("Stock");
		btnStockManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockView stockView=new StockView();
				stockView.setVisible(true);
			}
		});
		btnStockManagement.setForeground(SystemColor.windowBorder);
		btnStockManagement.setFont(new Font("Verdana", Font.BOLD, 16));
		btnStockManagement.setBorder(null);
		btnStockManagement.setBackground(new Color(75, 122, 222));
		btnStockManagement.setBounds(0, 205	, 290, 70);
		btnStockManagement.setForeground(Color.white);
		btnStockManagement.setBorder(new LineBorder(Color.white));
		getContentPane().add(btnStockManagement);
		
		JButton btnItems = new JButton("Items");
		btnItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemView itemView=new ItemView();
				itemView.setVisible(true);
			}
		});
		btnItems.setForeground(SystemColor.windowBorder);
		btnItems.setFont(new Font("Verdana", Font.BOLD, 16));
		btnItems.setBorder(null);
		btnItems.setBackground(new Color(75, 122, 222));
		btnItems.setBounds(0, 280, 290, 70);
		btnItems.setForeground(Color.white);
		btnItems.setBorder(new LineBorder(Color.white));
		getContentPane().add(btnItems);
		
		JButton btnItemsCategory = new JButton("Items Category");
		btnItemsCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemCategoryView itemCategoryView=new ItemCategoryView();
				itemCategoryView.setVisible(true);
			}
		});
		btnItemsCategory.setForeground(SystemColor.windowBorder);
		btnItemsCategory.setFont(new Font("Verdana", Font.BOLD, 16));
		btnItemsCategory.setBorder(null);
		btnItemsCategory.setBackground(new Color(75, 122, 222));
		btnItemsCategory.setBounds(0, 355, 290, 70);
		btnItemsCategory.setForeground(Color.white);
		btnItemsCategory.setBorder(new LineBorder(Color.white));	
		getContentPane().add(btnItemsCategory);
		
		JButton btnDailyExpense = new JButton("Daily Expense");
		btnDailyExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DailyExpensesView dailyExpensesView=new DailyExpensesView();
				dailyExpensesView.setVisible(true);
			}
		});
		btnDailyExpense.setForeground(SystemColor.windowBorder);
		btnDailyExpense.setFont(new Font("Verdana", Font.BOLD, 16));
		btnDailyExpense.setBorder(null);
		btnDailyExpense.setBackground(new Color(75, 122, 222));
		btnDailyExpense.setBounds(0, 430, 290, 70);
		btnDailyExpense.setForeground(Color.white);
		btnDailyExpense.setBorder(new LineBorder(Color.white));
		getContentPane().add(btnDailyExpense);

		
		JButton btnCustomerManagement = new JButton("Customer");
		btnCustomerManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Feature will be live soon.");
			}
		});
		btnCustomerManagement.setForeground(SystemColor.windowBorder);
		btnCustomerManagement.setFont(new Font("Verdana", Font.BOLD, 16));
		btnCustomerManagement.setBorder(null);
		btnCustomerManagement.setBackground(new Color(75, 122, 222));
		btnCustomerManagement.setBounds(0, 505, 290, 70);
		btnCustomerManagement.setForeground(Color.white);
		btnCustomerManagement.setBorder(new LineBorder(Color.white));
		getContentPane().add(btnCustomerManagement);
		
		
		JButton btnVendor = new JButton("Vendor");
		btnVendor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Feature will be live soon.");
			}
		});
		btnVendor.setFont(new Font("Verdana", Font.BOLD, 16));
		btnVendor.setBorder(null);
		btnVendor.setBounds(0, 580, 290, 70);
		btnVendor.setBackground(new Color(75, 122, 222));
		btnVendor.setForeground(Color.white);
		btnVendor.setBorder(new LineBorder(Color.white));
		getContentPane().add(btnVendor);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Feature will be live soon.");
			}
		});
		btnEmployee.setFont(new Font("Verdana", Font.BOLD, 16));
		btnEmployee.setBorder(null);
		btnEmployee.setForeground(Color.white);
		btnEmployee.setBackground(new Color(75, 122, 222));
		btnEmployee.setBounds(0, 655, 290, 70);
		btnEmployee.setBorder(new LineBorder(Color.white));
		getContentPane().add(btnEmployee);
			
		JButton btnEmployeeAttendance = new JButton("Employee Attendance");
		btnEmployeeAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Feature will be live soon.");
			}
		});
		btnEmployeeAttendance.setFont(new Font("Verdana", Font.BOLD, 16));
		btnEmployeeAttendance.setBorder(null);
		btnEmployeeAttendance.setBackground(new Color(75, 122, 222));
		btnEmployeeAttendance.setForeground(Color.white);
		btnEmployeeAttendance.setBounds(0, 730, 290, 70);
		btnEmployeeAttendance.setBorder(new LineBorder(Color.white));
		getContentPane().add(btnEmployeeAttendance);
		
		JButton btnPayroll = new JButton("Payroll");
		btnPayroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Feature will be live soon.");
			}
		});
		btnPayroll.setForeground(SystemColor.windowBorder);
		btnPayroll.setFont(new Font("Verdana", Font.BOLD, 16));
		btnPayroll.setBorder(null);
		btnPayroll.setForeground(Color.white);
		btnPayroll.setBackground(new Color(75, 122, 222));
		btnPayroll.setBounds(0, 805, 290, 70);
		btnPayroll.setBorder(new LineBorder(Color.white));
		getContentPane().add(btnPayroll);


		JButton btnlogout = new JButton("logout");
		btnPayroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
			}
		});
		btnlogout.setForeground(SystemColor.windowBorder);
		btnlogout.setFont(new Font("Verdana", Font.BOLD, 16));
		btnlogout.setBorder(null);
		btnlogout.setForeground(Color.white);
		btnlogout.setBackground(new Color(75, 122, 222));
		btnlogout.setBounds(0, 880, 290, 70);
		btnlogout.setBorder(new LineBorder(Color.white));
		getContentPane().add(btnlogout);
	}
}
