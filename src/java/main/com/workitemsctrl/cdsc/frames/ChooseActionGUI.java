package com.workitemsctrl.cdsc.frames;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.workitemsctrl.cdsc.consts.TicketTypes;
import com.workitemsctrl.cdsc.ctrl.TicketCtrl;
import com.workitemsctrl.cdsc.model.Ticket;

public class ChooseActionGUI extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 98743649L;
	private JButton bStartTask,bEndTask,bSubmit,bReset;
	private JTextField tClientId,tInternalId,tTime;
	private JLabel lClientId,lInternalId,lType,lTime;
	private JComboBox<TicketTypes> type; 

	public ChooseActionGUI(){
		
		bStartTask = new JButton("Start Task");
		bEndTask = new JButton("End Task");
		bSubmit = new JButton("Submit");
		bReset = new JButton("Reset");
		tClientId = new JTextField(10);
		tInternalId = new JTextField(10);
		lClientId = new JLabel("Client ID");
		lInternalId = new JLabel("Internal ID");
		lTime = new JLabel();
		type = new JComboBox<>(TicketTypes.values());
		lType = new JLabel("Ticket Type");
		tTime = new JTextField(10);
		bStartTask.addActionListener(this);
		bEndTask.addActionListener(this);
		bSubmit.addActionListener(this);
		bReset.addActionListener(this);
		bSubmit.setBackground(Color.WHITE);
		bReset.setBackground(Color.WHITE);
		bStartTask.setBackground(Color.WHITE);
		bEndTask.setBackground(Color.WHITE);
		type.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel(new GridLayout(7,2,15,15));
		panel.add(bStartTask);
		panel.add(bEndTask);
		panel.setBackground(Color.CYAN);
		panel.add(lClientId);
		panel.add(tClientId);
		panel.add(lInternalId);
		panel.add(tInternalId);
		panel.add(lType);
		panel.add(type);
		panel.add(lTime);
		panel.add(tTime);
		panel.add(bSubmit);
		panel.add(bReset);
		
		setFieldsVisible(false);
		
		this.add(panel);
		this.setTitle("Choose Action");
		this.setVisible(true);
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bStartTask){
			setFieldsVisible(true);
			lTime.setText("Start Task");
			inicializeStartTime();
		}else if(e.getSource() == bEndTask){
			lTime.setText("End Task");
			setFieldsVisible(true);
		}else if(e.getSource() == bReset){
			setFieldsVisible(false);
		}else if(e.getSource() == bSubmit){
			
			Integer idC=null,idI=null;
			
				idC = Integer.parseInt(tClientId.getText());
				idI = Integer.parseInt(tInternalId.getText());
			
			if(idC != null && idI != null){
				TicketCtrl ctrl = new TicketCtrl(new Ticket(idC, idI, 
						LocalDateTime.now(), TicketTypes.valueOf(type.getSelectedItem().toString())));
				System.out.println("dnoesnc");
				ctrl.insertNewTask();
			}
		}
	}
	
	public void setFieldsVisible(boolean state){
		lClientId.setVisible(state);
		lInternalId.setVisible(state);
		tClientId.setVisible(state);
		tInternalId.setVisible(state);
		type.setVisible(state);
		lType.setVisible(state);
		lTime.setVisible(state);
		tTime.setVisible(state);
		bSubmit.setVisible(state);
		bReset.setVisible(state);
	}
	
	public void inicializeStartTime(){
		String date = LocalDateTime.now().toString().replaceAll("[^A-Za-z0-9 ]", ":");
		tTime.setText(date.substring(0, date.length() - 7));
		tTime.setEditable(false);
	}

}
