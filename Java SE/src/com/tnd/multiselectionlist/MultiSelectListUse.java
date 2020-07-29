package com.tnd.multiselectionlist;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MultiSelectListUse extends JFrame{
	private JList rightList;
	private JList leftList;
	private JButton moveButton;
	private static String[] food={"chhola","rajma","cheeze","pooding","juice"}; 
	
	public MultiSelectListUse(){
		super("Thie App Title");
		setLayout(new FlowLayout());
		
		leftList = new JList(food);
		leftList.setVisibleRowCount(3);
		leftList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(leftList));
		moveButton = new JButton("Move --->");
		moveButton.addActionListener(
				new ActionListener() {
					@SuppressWarnings("deprecation")
					@Override
					public void actionPerformed(ActionEvent event) {
						rightList.setListData(leftList.getSelectedValues());
					}
				}
		);
		add(moveButton);
		rightList=new JList();
		rightList.setVisibleRowCount(4);
		rightList.setFixedCellWidth(100);
		rightList.setFixedCellHeight(15);
		rightList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(rightList));
	}	
}
