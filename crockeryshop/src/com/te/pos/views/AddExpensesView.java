package com.te.pos.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.te.pos.common.CurrentTime;
import com.te.pos.model.DailyExpense;
import com.te.pos.service.DailyExpenseService;

@SuppressWarnings("serial")
public class AddExpensesView extends JFrame implements KeyListener {

	private JPanel contentPane;

	private JTextField expenseCatagoryTB;
	private JTextField expenseDescriptionTB;
	private JTextField expenseAmountTB;
	private DailyExpense dailyExpenseModel;


	/**
	 * Create the frame.
	 */
	public AddExpensesView() {
		setTitle("Item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 746, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.addKeyListener(this);  


		contentPane.setBackground(SystemColor.activeCaption);

		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 848, 41);
		topPanel.setLayout(null);
		topPanel.setBackground(new Color(71, 120, 197));
		contentPane.add(topPanel);

		JLabel lblDashboard = new JLabel("Add Expenses");
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Verdana", Font.BOLD, 18));
		lblDashboard.setBounds(10, 0, 172, 41);
		topPanel.add(lblDashboard);

		JLabel lblExpense = new JLabel("Expense Category");
		lblExpense.setBounds(130, 52, 160, 22);
		lblExpense.setForeground(SystemColor.info);
		lblExpense.setFont(new Font("Verdana", Font.BOLD, 14));
		contentPane.add(lblExpense);

		JLabel lblExpenseDescription = new JLabel("Expense Description");
		lblExpenseDescription.setBounds(130, 124, 160, 22);
		lblExpenseDescription.setForeground(SystemColor.info);
		lblExpenseDescription.setFont(new Font("Verdana", Font.BOLD, 14));
		contentPane.add(lblExpenseDescription);

		JLabel lblExpenseAmount = new JLabel("Expense Amount");
		lblExpenseAmount.setBounds(130, 190, 160, 22);
		lblExpenseAmount.setForeground(SystemColor.info);
		lblExpenseAmount.setFont(new Font("Verdana", Font.BOLD, 14));
		contentPane.add(lblExpenseAmount);

		JButton saveBTN = new JButton("Save");
		saveBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addExpense();
				}
		});
		saveBTN.setFont(new Font("Verdana", Font.BOLD, 20));
		saveBTN.setBackground(new Color(71, 120, 197));
		saveBTN.setForeground(Color.WHITE);
		saveBTN.setBounds(340, 260, 140, 41);
		contentPane.add(saveBTN);

		JButton cancelBTN = new JButton("Cancel");
		cancelBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelBTN.setFont(new Font("Verdana", Font.BOLD, 20));
		cancelBTN.setBackground(new Color(71, 120, 197));
		cancelBTN.setForeground(Color.WHITE);
		cancelBTN.setBounds(485, 260, 140, 41);
		contentPane.add(cancelBTN);

		expenseCatagoryTB = new JTextField();
		expenseCatagoryTB.setColumns(10);
		expenseCatagoryTB.setBorder(null);
		expenseCatagoryTB.setBounds(130, 75, 494, 34);
		expenseCatagoryTB.setFont(new Font("Verdana", Font.PLAIN, 18));
		expenseCatagoryTB.addKeyListener(this);  
		contentPane.add(expenseCatagoryTB);

		expenseDescriptionTB = new JTextField();
		expenseDescriptionTB.setColumns(10);
		expenseDescriptionTB.setBorder(null);
		expenseDescriptionTB.setFont(new Font("Verdana", Font.PLAIN, 18));
		expenseDescriptionTB.addKeyListener(this);  
		expenseDescriptionTB.setBounds(130, 145, 494, 34);
		contentPane.add(expenseDescriptionTB);

		expenseAmountTB = new JTextField();
		expenseAmountTB.setColumns(10);
		expenseAmountTB.setBorder(null);
		expenseAmountTB.setFont(new Font("Verdana", Font.PLAIN, 18));
		expenseAmountTB.setBounds(130, 210, 494, 34);
		expenseAmountTB.addKeyListener(this);  

		contentPane.add(expenseAmountTB);

	}
	
	
private void addExpense() {
	
	try {
		if (expenseCatagoryTB.getText() != null && !expenseCatagoryTB.getText().equals("")) {
			if (expenseDescriptionTB.getText() != null && !expenseDescriptionTB.getText().equals("")) {
				if (expenseAmountTB.getText() != null && !expenseAmountTB.getText().equals("")) {
					
					
					dailyExpenseModel = new DailyExpense(expenseCatagoryTB.getText(), expenseDescriptionTB.getText(),
							expenseAmountTB.getText(),new CurrentTime().getTime());
					new DailyExpenseService().insertDailyExpenses(dailyExpenseModel);
					
					JOptionPane.showMessageDialog(null, "Successfully inserted");
					 dispose();


					
				} else {
					JOptionPane.showMessageDialog(null, "Please Enter Amount");
				}

			} else {
				JOptionPane.showMessageDialog(null, "Please Enter Description.");

			}

		} else {

			JOptionPane.showMessageDialog(null, "Please Enter Catagory.");

		}
	}
	
	catch (Exception e1) {
		e1.printStackTrace();
	}

	
}
	
	private void performEnterAction(KeyEvent e) {
	addExpense();
		}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
        if(code == KeyEvent.VK_ESCAPE){
             setVisible(false);
        }
        else if(code == KeyEvent.VK_ENTER){
             performEnterAction(e);
        }		
	}



}
