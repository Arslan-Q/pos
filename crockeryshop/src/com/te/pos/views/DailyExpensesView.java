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

import com.te.pos.model.DailyExpense;
import com.te.pos.service.DailyExpenseService;

@SuppressWarnings("serial")
public class DailyExpensesView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	
	
	/**
	 * Create the frame.
	 */
	public DailyExpensesView() {
		setTitle("Daily Expense");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.setBackground(SystemColor.activeCaption);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 1200, 41);
		topPanel.setLayout(null);
		topPanel.setBackground(new Color(71, 120, 197));
		contentPane.add(topPanel);
		
		JLabel lblDashboard = new JLabel("Daily Expense");
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Verdana", Font.BOLD, 18));
		lblDashboard.setBounds(10, 0, 230, 41);
		topPanel.add(lblDashboard);
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 70, 1120, 600);
		contentPane.add(scrollPane);
		
	    // Column Names 
	    String[] columnNames = {"Expense Category", "Expense Description","Expense Amount"}; 
	    
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
	    table.setRowHeight(50);
	    
	    JTableHeader header=table.getTableHeader();
	    header.setFont(new Font("Tahome", Font.BOLD, 20));
	    header.setBackground(new Color(71, 120, 197));
	    header.setForeground(Color.WHITE);
	  
	    
	    table.setSize(400, 600);
	    try {
			
			  List<DailyExpense> expensesList=new DailyExpenseService().getDailyExpenses(null);
			  if(expensesList!=null && expensesList.size()>0) { 
				  DefaultTableModel tablemodel = (DefaultTableModel)table.getModel(); 
				  for (DailyExpense dailyExpense : expensesList) { 
					  tablemodel.addRow(new Object[]{"Expense", dailyExpense.getExpenseDescription(),dailyExpense.getExpenseAmount()}); 
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
		cancelBTN.setBounds(1000,700, 153, 41);

		contentPane.add(cancelBTN);
		
		JButton addDailyExpense = new JButton("Add Expense");
		addDailyExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddExpensesView dashBoard=new AddExpensesView();
				dashBoard.setVisible(true);

			}
		});
		addDailyExpense.setFont(new Font("Verdana", Font.BOLD, 20));
		addDailyExpense.setBackground(new Color(71, 120, 197));
		addDailyExpense.setForeground(Color.WHITE);
		addDailyExpense.setBounds(805, 700, 180, 41);
		contentPane.add(addDailyExpense);
		
		
	}
}
