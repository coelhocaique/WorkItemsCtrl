package com.workitemsctrl.cdsc.ctrl;

import com.workitemsctrl.cdsc.dao.TicketDao;
import com.workitemsctrl.cdsc.model.Ticket;

public class TicketCtrl {
	
	private Ticket ticket;
	private TicketDao dao;
	
	public TicketCtrl(Ticket ticket) {
		this.ticket = ticket;
		dao = new TicketDao();
	}
	
	public TicketCtrl() {
	
	}
	
	public void insertNewTask(){
		dao.insertStartTime(ticket);
	}
	
}
