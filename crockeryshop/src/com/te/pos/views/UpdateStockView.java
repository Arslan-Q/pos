package com.te.pos.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.KeySelector.Purpose;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.te.pos.dao.StockDAO;
import com.te.pos.misc.Utilities;
import com.te.pos.model.Item;
import com.te.pos.model.Stock;
import com.te.pos.service.ItemService;
import com.te.pos.service.StockService;

@SuppressWarnings("serial")
public class UpdateStockView extends JFrame implements KeyListener {

	private JPanel contentPane;
	private JTextField quantityTB;

	private JTextField puchasePriceTB;
	private JComboBox<String> itemCB;
	private Map<String, Item> itemMap = null;
	private JTextField salePrice;

	/**
	 * Create the frame.
	 */
	public UpdateStockView() {
		setTitle("Update Stock");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 740, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		contentPane.setBackground(SystemColor.activeCaption);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 720, 50);
		topPanel.setLayout(null);
		topPanel.setBackground(new Color(71, 120, 197));
		contentPane.add(topPanel);
		
		JLabel lblDashboard = new JLabel("Stock");
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Verdana", Font.BOLD, 22));
		lblDashboard.setBounds(10, 0, 172, 41);
		topPanel.add(lblDashboard);
		
		quantityTB = new JTextField();
		quantityTB.setBounds(115, 310, 492, 44);
		quantityTB.setBorder(null);
		quantityTB.setFont(new Font("Verdana", Font.PLAIN, 18));
		quantityTB.setColumns(10);
		quantityTB.addKeyListener(this);  

		contentPane.add(quantityTB);
		
		
		try {
			List<Item> itemList = new ItemService().getItems();
			itemMap = new HashMap<String,Item>();
			itemCB = new JComboBox<String>();
			itemCB.setBounds(115, 77, 492, 44);
			itemCB.setSelectedItem(null);
			itemCB.setBorder(null);
			itemCB.addItem("");
			itemCB.setFont(new Font("Verdana", Font.PLAIN, 18));
			itemCB.setBackground(Color.WHITE);
			itemCB.addKeyListener(this);  

			
			if(itemList!=null && itemList.size()>0) {
				for (int i = 0; i < itemList.size(); i++) {
					  Item item=(Item)itemList.get(i);
					  itemMap.put(item.getItemCategoryName()+"-"+item.getItemName(), item);
					  itemCB.addItem(item.getItemCategoryName()+"-"+item.getItemName()); 
				  }
			}
			
			
			AutoCompleteDecorator.decorate(itemCB);
			contentPane.add(itemCB);
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		JLabel lblItem = new JLabel("Item");
		lblItem.setBounds(115, 55, 337, 22);
		lblItem.setForeground(SystemColor.info);
		lblItem.setFont(new Font("Verdana", Font.BOLD, 20));
		contentPane.add(lblItem);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(115, 285, 160, 22);
		lblQuantity.setForeground(SystemColor.info);
		lblQuantity.setFont(new Font("Verdana", Font.BOLD, 20));
		contentPane.add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Purchase Price");
		lblPrice.setBounds(115, 130, 160, 22);
		lblPrice.setForeground(SystemColor.info);
		lblPrice.setFont(new Font("Verdana", Font.BOLD, 18));
		contentPane.add(lblPrice);
		
		puchasePriceTB = new JTextField();
		puchasePriceTB.setBounds(115, 150, 492, 44);
		puchasePriceTB.setFont(new Font("Verdana", Font.PLAIN, 18));
		puchasePriceTB.setColumns(10);
		puchasePriceTB.setBorder(null);
		puchasePriceTB.addKeyListener(this);  

		contentPane.add(puchasePriceTB);
		
		JButton saveBTN = new JButton("Save");
		saveBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateStock();
			}
		});
		
		
		saveBTN.setFont(new Font("Verdana", Font.BOLD, 20));
		saveBTN.setBackground(new Color(71, 120, 197));
		saveBTN.setForeground(Color.WHITE);
		saveBTN.setBorder(null);
		saveBTN.setBounds(295, 380, 153, 41);
		contentPane.add(saveBTN);
		
		JButton cancelBTN = new JButton("Cancel");
		cancelBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	
		cancelBTN.setBorder(null);
		cancelBTN.setFont(new Font("Verdana", Font.BOLD, 20));
		cancelBTN.setBackground(new Color(71, 120, 197));
		cancelBTN.setForeground(Color.WHITE);
		cancelBTN.setBounds(455, 380, 153, 41);
		contentPane.add(cancelBTN);
		
		JLabel lblPrice_1 = new JLabel("Sale Price");
		lblPrice_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPrice_1.setForeground(SystemColor.info);
		lblPrice_1.setFont(new Font("Verdana", Font.BOLD, 18));
		
		lblPrice_1.setBounds(115, 210, 121, 22);
		contentPane.add(lblPrice_1);
		
		salePrice = new JTextField();
		salePrice.setColumns(10);
		salePrice.setBorder(null);
		salePrice.setFont(new Font("Verdana", Font.PLAIN, 20));
		salePrice.addKeyListener(this);  
		salePrice.setBounds(115, 230, 492, 44);
		contentPane.add(salePrice);
	}

	private void UpdateStock() {
		try {
			String itemName = itemCB.getSelectedItem().toString();
			Item item = itemMap.get(itemName);
			Long purchasePrice = Utilities.getLongObject(puchasePriceTB.getText());
			Long sellingPrice = Utilities.getLongObject(salePrice.getText());
			Long quantity = Utilities.getLongObject(quantityTB.getText());

			if (item != null && item.getItemId() != null && purchasePrice != null && sellingPrice != null
					&& quantity != null) {
				Stock stock = new StockDAO().getStockByItemId(item.getItemId());
				if (stock != null && stock.getStockId() != null) {
					Long stockQuantity = quantity + Long.parseLong(stock.getQuantity());
					new StockService().updateStock(item.getItemId(), purchasePrice, sellingPrice, stockQuantity);
				} else {
					new StockService().saveStock(item.getItemId(), purchasePrice, sellingPrice, quantity);
				}
				JOptionPane.showMessageDialog(null, "Stock update successfully.");
				dispose();
				// StockView stockView=new StockView();
				// stockView.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Please provide correct data.");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}


	private void performEnterAction(KeyEvent e) {
		UpdateStock();
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
