package com.te.pos.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import com.te.pos.dao.SaleDAO;
import com.te.pos.dao.StockDAO;
import com.te.pos.misc.Utilities;
import com.te.pos.model.Checkout;
import com.te.pos.model.CheckoutDetail;
import com.te.pos.model.Sale;
import com.te.pos.service.SaleService;

@SuppressWarnings("serial")
public class SaleView extends JFrame {

	private JPanel contentPane;
	private JTextField quantityTB;

	
	private JTextField priceTB;
	private JTable table;
	private JComboBox<String> saleItemCB;
	private JLabel messageLbl; 
	private Map<String,Sale> saleMap = null;
	private JTextField totalPriceTB;
	private JTextField nameTB;
	private JTextField phoneNo;
	
	/**
	 * Create the frame.
	 */
	public SaleView() {
		setTitle("Sale");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1550, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation(350, 100);
		
		
		contentPane.setBackground(SystemColor.activeCaption);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 1550, 50);
		topPanel.setLayout(null);
		topPanel.setBackground(new Color(71, 120, 197));
		contentPane.add(topPanel);
		
		JLabel lblDashboard = new JLabel("Sale Terminal");
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Verdana", Font.BOLD, 20));
		lblDashboard.setBounds(10, 0, 172, 50);
		topPanel.add(lblDashboard);
		
		quantityTB = new JTextField();
		quantityTB.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusLost(FocusEvent e) {

				Object item=saleItemCB.getSelectedItem();
				if(item!=null && !item.toString().equals("") && quantityTB.getText()!=null && !quantityTB.getText().equals("")) {
					Sale sale=saleMap.get(item.toString());
		    		Long salePrice=Utilities.getLongObject(sale.getItemSalePrice());
		    		Long quantity=Utilities.getLongObject(quantityTB.getText());
		    		if(salePrice!=null && quantity!=null) {
		    			Long price=salePrice*quantity;
		    			priceTB.setText(String.valueOf(price));
		    			messageLbl.setText("");
		    		}else {
		    			messageLbl.setText("quantity is not valid.");
		    		}
				}
			}
		});
		
		
		quantityTB.setBounds(750,  97,230, 50);
		quantityTB.setBorder(null);
		quantityTB.setColumns(10);
		quantityTB.setFont(new Font("Verdana", Font.PLAIN, 22));

		contentPane.add(quantityTB);
		
		
		try {
			List<Sale> saleList = new SaleService().getSale();
			saleMap = new HashMap<String,Sale>();
			saleItemCB = new JComboBox<String>();
			saleItemCB.setBounds(480, 97, 263, 50);
			saleItemCB.setFont(new Font("Verdana", Font.PLAIN, 20));

			saleItemCB.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					Object item = e.getItem();

				    if (e.getStateChange() == ItemEvent.SELECTED) {
				    	
				    	if(item!=null && item.toString()!=null && !item.toString().trim().equals("") && !item.toString().trim().equals("Select") 
				    			&& quantityTB.getText()!=null && !quantityTB.getText().equals("")) {
				    		System.out.println(item.toString());	
				    		Sale sale=saleMap.get(item.toString());
				    		Long salePrice=Utilities.getLongObject(sale.getItemSalePrice());
				    		Long quantity=Utilities.getLongObject(quantityTB.getText());
				    		if(salePrice!=null && quantity!=null) {
				    			Long price=salePrice*quantity;
				    			priceTB.setText(String.valueOf(price));
				    		}else {
				    			messageLbl.setText("quantity is not valid.");
				    		}
				    	}
				    } 
				}
			});
			saleItemCB.setSelectedItem(null);
			saleItemCB.setBorder(null);
			saleItemCB.addItem("");
			saleItemCB.setBackground(Color.WHITE);
			
			if(saleList!=null && saleList.size()>0) {
				for (int i = 0; i < saleList.size(); i++) {
					  Sale sale=(Sale)saleList.get(i);
					  saleMap.put(sale.getItemCategoryName()+"-"+sale.getItemName(), sale);
					  saleItemCB.addItem(sale.getItemCategoryName()+"-"+sale.getItemName()); 
				  }
			}
			
			
			AutoCompleteDecorator.decorate(saleItemCB);
			contentPane.add(saleItemCB);
			
		
		}catch(Exception e) {
			
		}
		
		
		
		JLabel lblItem = new JLabel("Item");
		lblItem.setBounds(480, 71, 210, 22);
		lblItem.setForeground(SystemColor.info);
		lblItem.setFont(new Font("Verdana", Font.BOLD, 22));
		contentPane.add(lblItem);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(750, 71, 210, 22);
		lblQuantity.setForeground(SystemColor.info);
		lblQuantity.setFont(new Font("Verdana", Font.BOLD, 22));
		contentPane.add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(1000, 71, 210, 22);
		lblPrice.setForeground(SystemColor.info);
		lblPrice.setFont(new Font("Verdana", Font.BOLD, 22));
		contentPane.add(lblPrice);
		
		priceTB = new JTextField();
		priceTB.setBounds(1000, 97,  230, 50);
		priceTB.setColumns(10);
		priceTB.setFont(new Font("Verdana", Font.PLAIN, 22));
		priceTB.setBorder(null);
		contentPane.add(priceTB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(212, 158, 1050, 500);
		contentPane.add(scrollPane);
		
	    // Column Names 
	    String[] columnNames = { "Item Description", "Quantity", "Price" }; 
	  
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

		scrollPane.setViewportView(table);
		
		
		JButton addToBasketBTN = new JButton("Add");
		addToBasketBTN.setBounds(1300, 180, 130, 50);
		addToBasketBTN.setFont(new Font("Verdana", Font.BOLD, 20));
		addToBasketBTN.setBackground(new Color(71, 120, 197));
		addToBasketBTN.setForeground(Color.WHITE);
		    
		contentPane.add(addToBasketBTN);
		

		addToBasketBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	additem();
					
			}
		});
		
		
		
		JButton clearBTN = new JButton("Clear");
		clearBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String[] columnNames = { "Item Description", "Quantity", "Price" }; 
				table.setModel(new DefaultTableModel(columnNames,0));
				setTotalPrice();
			}
		});
		clearBTN.setBounds(1300, 290, 130, 50);
		clearBTN.setFont(new Font("Verdana", Font.BOLD, 20));
		clearBTN.setBorder(null);
		clearBTN.setBackground(new Color(71, 120, 197));
		clearBTN.setForeground(Color.WHITE);
		    
		
		contentPane.add(clearBTN);
		
		JButton deleteBTN = new JButton("Delete");
		deleteBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				   int[] rows = table.getSelectedRows();
				   if(rows.length!=0) {
					   for(int i=0;i<rows.length;i++){
					     model.removeRow(rows[i]-i);
					     setTotalPrice();
					     messageLbl.setText("");
					   }
				   }else {
						JOptionPane.showMessageDialog(null, "Please select item from table.");

				   }
			}
		});
		deleteBTN.setBounds(1300, 235, 130, 50);
		deleteBTN.setFont(new Font("Verdana", Font.BOLD, 20));
		deleteBTN.setForeground(Color.white);
		deleteBTN.setBorder(null);
		deleteBTN.setBackground(new Color(71, 120, 197));
		contentPane.add(deleteBTN);
		
		messageLbl = new JLabel("");
		messageLbl.setForeground(Color.RED);
		messageLbl.setFont(new Font("Verdana", Font.BOLD, 12));
		messageLbl.setBounds(215, 136, 583, 14);
		contentPane.add(messageLbl);
		
		JButton resetBTN = new JButton("Reset");
		resetBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saleItemCB.setSelectedIndex(0);
				quantityTB.setText("");
				priceTB.setText("");
				String[] columnNames = { "Item Description", "Quantity", "Price" }; 
				table.setModel(new DefaultTableModel(columnNames,0));
				setTotalPrice();
			}
		});
		resetBTN.setBounds(1300, 345, 130, 50);
		resetBTN.setFont(new Font("Verdana", Font.BOLD, 20));
		resetBTN.setForeground(Color.white);
		resetBTN.setBorder(null);
		resetBTN.setBackground(new Color(71, 120, 197));
		contentPane.add(resetBTN);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(990, 700, 180, 50);
		lblTotal.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTotal.setForeground(Color.BLACK);
		lblTotal.setBorder(null);
		lblTotal.setBackground(Color.WHITE);
		contentPane.add(lblTotal);
		
		totalPriceTB = new JTextField();
		totalPriceTB.setBounds(1085, 700, 180, 50);
		totalPriceTB.setFont(new Font("Verdana", Font.BOLD, 20));
		totalPriceTB.setForeground(Color.BLACK);
		totalPriceTB.setBorder(null);
		totalPriceTB.setBackground(Color.WHITE);
		contentPane.add(totalPriceTB);
		totalPriceTB.setColumns(10);
		
		JButton checkOut = new JButton("Checkout");
		checkOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<Long,String> itemQuantity=new HashMap<Long, String>();
				for (int i = 0; i < table.getRowCount(); i++) {  // Loop through the rows
					String quantity=table.getValueAt(i, 1).toString();
					Sale sale=saleMap.get(table.getValueAt(i, 0).toString());
					if(itemQuantity.get(sale.getItemId())!=null) {
						String itemQuantityAlreadyInTable=itemQuantity.get(sale.getItemId());
						String quantityAddedInMap = String.valueOf((Long.parseLong(itemQuantityAlreadyInTable))+Long.parseLong(quantity));
						itemQuantity.remove(sale.getItemId());
						itemQuantity.put(sale.getItemId(), quantityAddedInMap);
					}else{
						itemQuantity.put(sale.getItemId(), quantity);
					}
			     }
				
				Boolean quantityAvailable=true;
				for (int i = 0; i < table.getRowCount(); i++) {  // Loop through the rows
					Sale sale=saleMap.get(table.getValueAt(i, 0).toString());
					long quantity=Long.parseLong(itemQuantity.get(sale.getItemId()));
					if(Long.parseLong(sale.getQuantity())<quantity) {
						quantityAvailable=false;

		JOptionPane.showMessageDialog(null,"Only "+sale.getQuantity()+" is available in stock of "+sale.getItemName()+".");
						break;
					}
				}
				
				
				if(quantityAvailable) {
					Boolean checkoutDone=checkout();
					if(checkoutDone) {
						messageLbl.setText("");
						JOptionPane.showMessageDialog(null, "Thanks for shopping here.");
						dispose();
					}
				}
				
			}
		});
		checkOut.setBounds(1000,770, 130, 50);
		checkOut.setFont(new Font("Verdana", Font.BOLD, 20));
		checkOut.setForeground(Color.white);
		checkOut.setBorder(null);
		checkOut.setBackground(new Color(71, 120, 197));
		contentPane.add(checkOut);
		
		JButton cancelBTN = new JButton("Cancel");
		cancelBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelBTN.setForeground(SystemColor.windowBorder);
		cancelBTN.setBounds(1140, 770, 130, 50);
		cancelBTN.setFont(new Font("Verdana", Font.BOLD, 20));
		cancelBTN.setForeground(Color.white);
		cancelBTN.setBorder(null);
		cancelBTN.setBackground(new Color(71, 120, 197));
		contentPane.add(cancelBTN);
		
		JLabel nameLbl = new JLabel("Name");
		nameLbl.setForeground(SystemColor.info);
		nameLbl.setFont(new Font("Verdana", Font.BOLD, 22));
		nameLbl.setBounds(216, 71, 174, 22);
		contentPane.add(nameLbl);
		
		nameTB = new JTextField();
		nameTB.setColumns(10);
		nameTB.setBorder(new EmptyBorder(5, 5, 5, 5));
		nameTB.setBounds(212, 97, 230, 50);
		nameTB.setFont(new Font("Verdana", Font.PLAIN, 22));
		contentPane.add(nameTB);
		
		JLabel phoneNoLbl = new JLabel("Phone No");
		phoneNoLbl.setForeground(SystemColor.info);
		phoneNoLbl.setFont(new Font("Verdana", Font.BOLD, 22));
		phoneNoLbl.setBounds(1250, 71, 156, 22);
		contentPane.add(phoneNoLbl);
		
		phoneNo = new JTextField();
		phoneNo.setColumns(10);
		phoneNo.setBorder(null);
		phoneNo.setBounds(1250, 97,230, 50);
		phoneNo.setFont(new Font("Verdana", Font.PLAIN, 22));
		contentPane.add(phoneNo);
		
		
		nameTB.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent ae) {
		    additem();
		    	}
		});
		phoneNo.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent ae) {
		    	additem();
		    	}
		});
		quantityTB.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent ae) {
		    	additem();
		    	}
		});
		
		priceTB.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent ae) {
		    	additem();
		    	}
		});
		
	}
	
	
	private Boolean checkout() {
		Boolean checkoutDone=false;
		try {
			Checkout checkout=new Checkout();
			checkout.setTotalBill(totalPriceTB.getText());
			checkout.setSoldDate(new Date());
			checkout.setCustomerName(nameTB.getText());
			checkout.setPhoneNumber(phoneNo.getText());
			ArrayList<CheckoutDetail> checkoutDetailList=new ArrayList<CheckoutDetail>();
			for (int i = 0; i < table.getRowCount(); i++) {  // Loop through the rows
				CheckoutDetail checkoutDetail=new CheckoutDetail();
				String itemName = table.getValueAt(i, 0).toString();
				String quantity = table.getValueAt(i, 1).toString();
				String salePrice = table.getValueAt(i, 2).toString();
				Sale sale=saleMap.get(itemName);
				checkoutDetail.setItemId(sale.getItemId());
				checkoutDetail.setQuantity(quantity);
				checkoutDetail.setSalePrice(salePrice);
				checkoutDetailList.add(checkoutDetail);
				checkout.setCheckoutDetailList(checkoutDetailList);
			 }
			new SaleDAO().checkout(checkout);
			new StockDAO().updateStock(checkout);
			checkoutDone=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkoutDone;
	}
	
	private void setTotalPrice() {                                         
		Long totalPrice=0L;
		for (int i = 0; i < table.getRowCount(); i++) {  // Loop through the rows
	        Object price = table.getValueAt(i, 2);
	        System.out.println(price.toString());
	        totalPrice+=Long.parseLong(price.toString());
	     }
		
		totalPriceTB.setText(String.valueOf(totalPrice));
	}
private void additem() {
	DefaultTableModel model = (DefaultTableModel) table.getModel();
	if(!saleItemCB.getSelectedItem().toString().equals("") && !quantityTB.getText().equals("") 
			&&  !priceTB.getText().equals("")) {
		Long quantity=Utilities.getLongObject(quantityTB.getText());
		Long price=Utilities.getLongObject(priceTB.getText());
		if(quantity!=null && price!=null) {
			Sale sale=saleMap.get(saleItemCB.getSelectedItem().toString());
			System.out.println("Quantity in stock -> "+sale.getQuantity());
			if(Long.parseLong(sale.getQuantity())>=quantity.longValue()) {
				model.addRow(new Object[]{saleItemCB.getSelectedItem().toString(), quantityTB.getText(), priceTB.getText()});
				messageLbl.setText("");
				setTotalPrice();	
			}else {
				JOptionPane.showMessageDialog(null, "Quantity is greater then availablity in stock.");

			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Price or Quantity is not valid.");

		}
	}else {
		JOptionPane.showMessageDialog(null, "Please enter item, price and quantity.");

	}
	
}
	
}

