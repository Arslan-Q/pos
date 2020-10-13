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
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.te.pos.model.ItemCategory;
import com.te.pos.service.ItemService;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ItemView extends JFrame implements KeyListener {

	private JPanel contentPane;
	private JComboBox<String> itemCategoryCB;
	private Map<String, ItemCategory> itemCategoryMap = null;
	private JTextField itemNameTB;

	/**
	 * Create the frame.
	 */
	public ItemView() {
		setTitle("Item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.setBackground(SystemColor.activeCaption);

		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 750, 41);
		topPanel.setLayout(null);
		topPanel.setBackground(new Color(71, 120, 197));
		contentPane.add(topPanel);

		JLabel lblDashboard = new JLabel("Items");
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Verdana", Font.BOLD, 18));
		lblDashboard.setBounds(0, 0, 172, 41);
		topPanel.add(lblDashboard);

		JLabel lblItem = new JLabel("Item Category");
		lblItem.setBounds(100, 61, 337, 22);
		lblItem.setForeground(SystemColor.info);
		lblItem.setFont(new Font("Verdana", Font.BOLD, 14));
		contentPane.add(lblItem);

		JLabel lblQuantity = new JLabel("Item Name");
		lblQuantity.setBounds(100, 136, 160, 22);
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
		saveBTN.setBounds(260, 216, 153, 41);
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
		cancelBTN.setBounds(260, 216, 153, 41);
		cancelBTN.setBounds(440, 216, 153, 41);
		contentPane.add(cancelBTN);

		try {
			List<ItemCategory> itemCategoryList = new ItemService().getItemCategory();
			itemCategoryMap = new HashMap<String, ItemCategory>();
			itemCategoryCB = new JComboBox<String>();
			itemCategoryCB.setBounds(100, 97, 494, 34);
			itemCategoryCB.setFont(new Font("Verdana", Font.PLAIN, 18));
			itemCategoryCB.setSelectedItem(null);
			itemCategoryCB.setBorder(null);
			itemCategoryCB.addItem("");
			itemCategoryCB.setBackground(Color.WHITE);
			itemCategoryCB.addKeyListener(this);


			if (itemCategoryList != null && itemCategoryList.size() > 0) {
				for (int i = 0; i < itemCategoryList.size(); i++) {
					ItemCategory itemCategory = (ItemCategory) itemCategoryList.get(i);
					itemCategoryMap.put(itemCategory.getItemCategoryName(), itemCategory);
					itemCategoryCB.addItem(itemCategory.getItemCategoryName());
				}
			}

			AutoCompleteDecorator.decorate(itemCategoryCB);
			contentPane.add(itemCategoryCB);

		} catch (Exception e) {
			e.printStackTrace();
		}

		contentPane.add(itemCategoryCB);

		itemNameTB = new JTextField();
		itemNameTB.setFont(new Font("Verdana", Font.PLAIN, 18));
		itemNameTB.setColumns(10);
		itemNameTB.setBorder(null);
		itemNameTB.setBounds(100, 161, 494, 34);
		itemNameTB.addKeyListener(this);
		contentPane.add(itemNameTB);
	}

	private void addItem() {
		try {
			Object item = itemCategoryCB.getSelectedItem();

			if (item != null && item.toString() != null && !item.toString().trim().equals("")
					&& !item.toString().trim().equals("Select") && itemNameTB.getText() != null
					&& !itemNameTB.getText().equals("")) {
				ItemCategory itemCategory = itemCategoryMap.get(item.toString());

				int count = new ItemService().checkItemExistence(itemCategory.getItemCategoryId(),
						itemNameTB.getText());
				if (count > 0) {
					JOptionPane.showMessageDialog(null, "Item Already Existed");
				} else {
					new ItemService().saveItem(itemCategory.getItemCategoryId(), itemNameTB.getText());
					JOptionPane.showMessageDialog(null, "Item inserted successfully");

				}
			} else {
				JOptionPane.showMessageDialog(null, "Please insert value");

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
		if (code == KeyEvent.VK_ESCAPE) {
			setVisible(false);
		} else if (code == KeyEvent.VK_ENTER) {
			performEnterAction(e);
		}
	}
}
