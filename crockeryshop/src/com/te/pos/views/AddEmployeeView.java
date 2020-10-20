package com.te.pos.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.te.pos.common.CurrentTime;
import com.te.pos.model.DailyExpense;
import com.te.pos.model.Employee;
import com.te.pos.service.DailyExpenseService;
import com.te.pos.service.EmployeeService;

@SuppressWarnings("serial")
public class AddEmployeeView extends JFrame implements KeyListener {

	private JPanel contentPane;

	private JTextField employeeNameTB;
	private JTextField employeeCnicTB;
	private JTextField employeePhoneTB;
	private JTextField employeeAddressTB;
	private JTextField employeeSalaryTB;
	private JRadioButton r1=new JRadioButton("A) Yes");    
	private JRadioButton r2=new JRadioButton("B) No");  

	/**
	 * Create the frame.
	 */
	public AddEmployeeView() {
		setTitle("Add Employee");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 70, 900, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.addKeyListener(this);

		contentPane.setBackground(SystemColor.activeCaption);

		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 1000, 41);
		topPanel.setLayout(null);
		topPanel.setBackground(new Color(71, 120, 197));
		contentPane.add(topPanel);

		JLabel lblDashboard = new JLabel("Add Employee");
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Verdana", Font.BOLD, 18));
		lblDashboard.setBounds(10, 0, 172, 41);
		topPanel.add(lblDashboard);
// Employee Name Field Start 
		JLabel lblName = new JLabel("Employee Name");
		lblName.setBounds(130, 52, 160, 22);
		lblName.setForeground(SystemColor.info);
		lblName.setFont(new Font("Verdana", Font.BOLD, 16));
		contentPane.add(lblName);
		employeeNameTB = new JTextField();
		employeeNameTB.setColumns(10);
		employeeNameTB.setBorder(null);
		employeeNameTB.setBounds(130, 75, 280, 38);
		employeeNameTB.setFont(new Font("Verdana", Font.PLAIN, 20));
		employeeNameTB.addKeyListener(this);
		contentPane.add(employeeNameTB);
		// end

		// Employee CNIC Field Start
		JLabel lblCNIC = new JLabel("Employee cnic");
		lblCNIC.setBounds(500, 52, 160, 22);
		lblCNIC.setForeground(SystemColor.info);
		lblCNIC.setFont(new Font("Verdana", Font.BOLD, 16));
		contentPane.add(lblCNIC);
		employeeCnicTB = new JTextField();
		employeeCnicTB.setColumns(10);
		employeeCnicTB.setBorder(null);
		employeeCnicTB.setFont(new Font("Verdana", Font.PLAIN, 20));
		employeeCnicTB.addKeyListener(this);
		employeeCnicTB.setBounds(500, 75, 280, 38);
		contentPane.add(employeeCnicTB);

//phone Number
		JLabel lblPhoneNo = new JLabel("PhoneNo");
		lblPhoneNo.setBounds(130, 124, 160, 22);
		lblPhoneNo.setForeground(SystemColor.info);
		lblPhoneNo.setFont(new Font("Verdana", Font.BOLD, 16));
		contentPane.add(lblPhoneNo);
		employeePhoneTB = new JTextField();
		employeePhoneTB.setColumns(10);
		employeePhoneTB.setBorder(null);
		employeePhoneTB.setFont(new Font("Verdana", Font.PLAIN, 20));
		employeePhoneTB.addKeyListener(this);
		employeePhoneTB.setBounds(130, 145, 280, 38);
		contentPane.add(employeePhoneTB);
		// end

//Address
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(500, 124, 160, 22);
		lblAddress.setForeground(SystemColor.info);
		lblAddress.setFont(new Font("Verdana", Font.BOLD, 16));
		contentPane.add(lblAddress);
		employeeAddressTB = new JTextField();
		employeeAddressTB.setColumns(10);
		employeeAddressTB.setBorder(null);
		employeeAddressTB.setFont(new Font("Verdana", Font.PLAIN, 20));
		employeeAddressTB.addKeyListener(this);
		employeeAddressTB.setBounds(500, 145, 280, 38);
		contentPane.add(employeeAddressTB);
		// end
//Status 
		JLabel lblExpenseAmount = new JLabel("Active");
		lblExpenseAmount.setBounds(130, 190, 160, 22);
		lblExpenseAmount.setForeground(SystemColor.info);
		lblExpenseAmount.setFont(new Font("Verdana", Font.BOLD, 16));
		contentPane.add(lblExpenseAmount);
		  
		r1.setBounds(130, 210, 100, 34);
		r2.setBounds(250, 210, 100, 34);
		ButtonGroup bg=new ButtonGroup();  
		bg.add(r1);bg.add(r2); 
		contentPane.add(r1);
		contentPane.add(r2);

	//	contentPane.add(employeeSalaryTB);
		// end

// Salary
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(500, 190, 160, 22);
		lblSalary.setForeground(SystemColor.info);
		lblSalary.setFont(new Font("Verdana", Font.BOLD, 16));
		contentPane.add(lblSalary);
		employeeSalaryTB = new JTextField();
		employeeSalaryTB.setColumns(10);
		employeeSalaryTB.setBorder(null);
		employeeSalaryTB.setFont(new Font("Verdana", Font.PLAIN, 20));
		employeeSalaryTB.setBounds(500, 210, 280, 38);
		employeeSalaryTB.addKeyListener(this);

		contentPane.add(employeeSalaryTB);
		// end

		JButton saveBTN = new JButton("Save");
		saveBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEmployee();
			}
		});
		saveBTN.setFont(new Font("Verdana", Font.BOLD, 20));
		saveBTN.setBackground(new Color(71, 120, 197));
		saveBTN.setForeground(Color.WHITE);
		saveBTN.setBounds(490, 280, 140, 41);
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
		cancelBTN.setBounds(640, 280, 140, 41);
		contentPane.add(cancelBTN);

	}

	private void addEmployee() {
		String active;
		try {
			if (employeeNameTB.getText() != null && !employeeNameTB.getText().equals("")) {
				if (employeeCnicTB.getText() != null && !employeeCnicTB.getText().equals("")) {
					if (employeePhoneTB.getText() != null && !employeePhoneTB.getText().equals("")) {
						if (employeeAddressTB.getText() != null && !employeeAddressTB.getText().equals("")) {
							if (r1.isSelected() || r2.isSelected()) {
								if(r1.isSelected()){active="Y";}else {active="N";}
								if(employeeSalaryTB.getText() != null && !employeeSalaryTB.getText().equals("")) {
								new EmployeeService().insertEmployee(new Employee(null, employeeNameTB.getText(), employeePhoneTB.getText(), employeeCnicTB.getText(), employeeAddressTB.getText(), active, employeeSalaryTB.getText() ));
									
									JOptionPane.showMessageDialog(null, "Successfully inserted");
									 dispose();
									
								}else {
									JOptionPane.showMessageDialog(null, "Please Enter Salary ");
	
								}

							} else {
								JOptionPane.showMessageDialog(null, "Select Status ");
							}

						} else {
							JOptionPane.showMessageDialog(null, "Please Enter Address");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Please Enter PhoneNo");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Please Enter Cnic.");

				}

			} else {

				JOptionPane.showMessageDialog(null, "Please Enter Employee Name.");

			}
		}

		catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private void performEnterAction(KeyEvent e) {
		addEmployee();
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
		if (code == KeyEvent.VK_ESCAPE) {
			setVisible(false);
		} else if (code == KeyEvent.VK_ENTER) {
			performEnterAction(e);
		}
	}

}
