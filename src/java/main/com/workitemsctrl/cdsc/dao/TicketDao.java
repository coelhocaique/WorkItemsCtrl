package com.workitemsctrl.cdsc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.workitemsctrl.cdsc.consts.QueriesConsts;
import com.workitemsctrl.cdsc.factory.ConnectionFactory;
import com.workitemsctrl.cdsc.model.Ticket;

public class TicketDao {

	public void insertStartTime(Ticket ticket) {
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(QueriesConsts.INSERT_START_TIME);) {
			stm.setInt(1, ticket.getIdAig());
			stm.setInt(2, ticket.getIdRtc());
			stm.setString(3, ticket.getType().name());
			stm.setTimestamp(4, Timestamp.valueOf(ticket.getStartTime()));
			stm.setDouble(5,0);
			stm.setDouble(6, 0);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addEndTimeForTicketWithRtcId(Ticket ticket) {
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(QueriesConsts.UPDATE_WITH_RTC_ID);) {
			stm.setTimestamp(1, Timestamp.valueOf(ticket.getEndTime()));
			stm.setInt(2, ticket.getIdRtc());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addEndTimeForTicketWithAigId(Ticket ticket) {
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(QueriesConsts.UPDATE_WITH_AIG_ID);) {
			stm.setTimestamp(1, Timestamp.valueOf(ticket.getEndTime()));
			stm.setInt(2, ticket.getIdAig());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void findTicketByNumber() {
		
	}

	public void listAllTickets() {

	}

}
