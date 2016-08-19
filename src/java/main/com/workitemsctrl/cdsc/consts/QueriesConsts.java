package com.workitemsctrl.cdsc.consts;

public final class QueriesConsts {

	public static final String INSERT_START_TIME = "insert into t_cdsc_items_control(id_aig,id_rtc,item_type,start_timestamp,"
												+ "end_timestamp,total_hours) values(?,?,?,?,?,?)";
	
	
	
	public static final String UPDATE_WITH_RTC_ID = "update t_cdsc_items_control set end_timestamp = ?"
												+ "where item_id = (select max(item_id) from t_cdsc_items_control"
												+ "where id_rtc = ?)";
	
	public static final String UPDATE_WITH_AIG_ID = "update t_cdsc_items_control set end_timestamp = ?"
			+ "where item_id = (select max(item_id) from t_cdsc_items_control"
			+ "where id_aig = ?)";
	
	

}
