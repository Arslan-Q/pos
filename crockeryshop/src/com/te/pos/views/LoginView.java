package com.te.pos.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import com.te.pos.service.LoginService;

public class LoginView {

	private JFrame frmPosCrockery;
	private JTextField userName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					LoginView window = new LoginView();
//					window.frmPosCrockery.setVisible(true);
					DashboardView window=new DashboardView();
					window.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPosCrockery = new JFrame();
		frmPosCrockery.setTitle("POS :: Crocker Shop");
		frmPosCrockery.getContentPane().setBackground(SystemColor.activeCaption);
		frmPosCrockery.setBounds(100, 100, 450, 350);
		frmPosCrockery.setResizable(false);

		frmPosCrockery.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPosCrockery.getContentPane().setLayout(null);
		
		
		JLabel messageLbl = new JLabel("");
		messageLbl.setForeground(Color.RED);
		messageLbl.setFont(new Font("Verdana", Font.BOLD, 12));
		messageLbl.setBounds(163, 182, 221, 140);
		frmPosCrockery.getContentPane().add(messageLbl);
		
		
		
		JPanel topPanel = new JPanel();	
		topPanel.setBounds(0, 0, 500, 41);
		topPanel.setBackground(new java.awt.Color(71, 120, 197));
		frmPosCrockery.getContentPane().add(topPanel);
		topPanel.setLayout(null);
		
		JLabel loginHeading = new JLabel("Login");
		loginHeading.setForeground(Color.WHITE);
		loginHeading.setFont(new Font("Verdana", Font.BOLD, 18));
		loginHeading.setBounds(185, 0, 172, 41);
		topPanel.add(loginHeading);
		
		userName = new JTextField();
		userName.setBorder(null);
		userName.setFont(new Font("Verdana", Font.PLAIN, 18));
		userName.setBounds(100, 77, 221, 30);
		frmPosCrockery.getContentPane().add(userName);
		userName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 18));
		passwordField.setBounds(100, 141, 221, 30);
		frmPosCrockery.getContentPane().add(passwordField);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}});
		
		loginBtn.setForeground(SystemColor.windowBorder);
		loginBtn.setFont(new Font("Verdana", Font.BOLD, 18));
		loginBtn.setBackground(SystemColor.text);
		loginBtn.setBorder(new LineBorder(new Color(71, 120, 197), 2, true));
		loginBtn.setBounds(140, 208, 132, 35);
		frmPosCrockery.getContentPane().add(loginBtn);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setForeground(SystemColor.info);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(100, 52, 98, 22);
		frmPosCrockery.getContentPane().add(lblNewLabel);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setForeground(SystemColor.info);
		passwordLbl.setFont(new Font("Verdana", Font.BOLD, 14));
		passwordLbl.setBounds(100, 116, 98, 22);
		frmPosCrockery.getContentPane().add(passwordLbl);
		
		frmPosCrockery.setLocationRelativeTo(null);
		
		
		
		passwordField.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent ae) {
		    	login();		    }
		});
		
		userName.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent ae) {
		    	login();	
		    	}
		});
		
	}
	
	
	
private void login() {
	 try {
		  String password= new String(passwordField.getPassword());
		  if(userName.getText()!=null && !userName.getText().equals("")){
			  if(password!=null && !password.equals("")){
				  Boolean allowUserToLogin = new LoginService().loginToSystem(userName.getText(),new String(passwordField.getPassword()));
				  if(allowUserToLogin) {
					  frmPosCrockery.setVisible(false);
					  DashboardView frame = new DashboardView();
					  frame.setVisible(true);
				  }else {
					    JOptionPane.showMessageDialog(frmPosCrockery,"Please enter valid credentials");  

				  }
			  }else {
				    JOptionPane.showMessageDialog(frmPosCrockery,"Please enter valid password");  

			  }
		  }else {
			    JOptionPane.showMessageDialog(frmPosCrockery,"Please enter valid username.");  

		  }
		  
		
	  }catch(Exception ex){
		  ex.printStackTrace();
	  }
	}

	
}	

