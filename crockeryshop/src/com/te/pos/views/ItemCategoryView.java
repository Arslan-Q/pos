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

import com.te.pos.service.ItemService;

@SuppressWarnings("serial")
public class ItemCategoryView extends JFrame implements KeyListener{

	private JPanel contentPane;
	private JTextField itemCategoryTB;

	/**
	 * Create the frame.
	 */
	public ItemCategoryView() {
		setTitle("Item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 746, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.setBackground(SystemColor.activeCaption);

		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 800, 41);
		topPanel.setLayout(null);
		topPanel.setBackground(new Color(71, 120, 197));
		contentPane.add(topPanel);

		JLabel lblDashboard = new JLabel("Item Category");
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Verdana", Font.BOLD, 18));
		lblDashboard.setBounds(0, 0, 172, 41);
		topPanel.add(lblDashboard);

		JLabel lblQuantity = new JLabel("Item Category");
		lblQuantity.setBounds(100, 52, 160, 22);
		lblQuantity.setForeground(SystemColor.info);
		lblQuantity.setFont(new Font("Verdana", Font.BOLD, 14));
		contentPane.add(lblQuantity);

		JButton saveBTN = new JButton("Save");
		saveBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem();
							}
		});
		saveBTN.setFont(new Font("Verdana", Font.BOLD, 20));
		saveBTN.setBackground(new Color(71, 120, 197));
		saveBTN.setForeground(Color.WHITE);
		saveBTN.setBounds(270, 136, 153, 41);
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
		cancelBTN.setBounds(440, 136, 153, 41);
		contentPane.add(cancelBTN);

		itemCategoryTB = new JTextField();
		itemCategoryTB.setColumns(10);
		itemCategoryTB.setBorder(null);
		itemCategoryTB.setBounds(100, 85, 494, 34);
		itemCategoryTB.setFont(new Font("Verdana", Font.PLAIN, 18));
		itemCategoryTB.addKeyListener(this);  
		contentPane.add(itemCategoryTB);
	}
	
private void addItem() {
	try {
		if (itemCategoryTB.getText() != null && !itemCategoryTB.getText().equals("")) {
			if (new ItemService().checkItemCategoryExistence(itemCategoryTB.getText()) > 0) {
				JOptionPane.showMessageDialog(null, "Item Category Already Existed.");
			} else {
				new ItemService().saveItemCategory(itemCategoryTB.getText());
				JOptionPane.showMessageDialog(null, "Item Category saved successfully.");
				itemCategoryTB.setText("");

			}
		}
		else {
			JOptionPane.showMessageDialog(null, "empty");

		}

		// dispose();
	} catch (Exception e1) {
		e1.printStackTrace();
	}

}
	
	
	private void performEnterAction(KeyEvent e) {
		addItem();
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
