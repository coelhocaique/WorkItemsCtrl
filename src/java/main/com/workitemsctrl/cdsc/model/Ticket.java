package com.workitemsctrl.cdsc.model;

import java.time.LocalDateTime;

import com.workitemsctrl.cdsc.consts.TicketTypes;
import com.workitemsctrl.cdsc.exceptions.NoTicketIdException;

public class Ticket {

	private String idAig;
	private Integer idRtc;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Double totalhours;
	private TicketTypes type;

	public Ticket(String idAig, Integer idRtc,LocalDateTime startTime,
			TicketTypes type) {
		if(idAig == null && idRtc == null){
			try {
				throw new NoTicketIdException();
			} catch (NoTicketIdException e) {
				e.printStackTrace();
			}
		}
		this.idAig = idAig;
		this.idRtc = idRtc;
		this.startTime = startTime;
		this.type = type;
	}
	
	public Ticket(Integer idRtc,LocalDateTime startTime,
			TicketTypes type) {
		this.idRtc = idRtc;
		this.startTime = startTime;
		this.type = type;
	}
	
	public Ticket(LocalDateTime startTime,String idAig,
			TicketTypes type) {
		this.idAig = idAig;
		this.startTime = startTime;
		this.type = type;
	}
	
	public String getIdAig() {
		return idAig;
	}

	public void setIdAig(String aigNumber) {
		this.idAig = aigNumber;
	}

	public Integer getIdRtc() {
		return idRtc;
	}

	public void setIdRtc(Integer rtcNumber) {
		this.idRtc = rtcNumber;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Double getTotalhours() {
		return totalhours;
	}

	public void setTotalhours(Double totalhours) {
		this.totalhours = totalhours;
	}

	public TicketTypes getType() {
		return type;
	}

	public void setType(TicketTypes type) {
		this.type = type;
	}
	
}
