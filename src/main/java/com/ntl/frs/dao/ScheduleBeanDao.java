package com.ntl.frs.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ntl.frs.bean.ScheduleBean;


public interface ScheduleBeanDao {


	String createScheduleBean(ScheduleBean scheduleBean) throws SQLException;
	int deleteScheduleBean(ArrayList<String> al ) throws SQLException;
	boolean updateScheduleBean(ScheduleBean scheduleBean) throws SQLException ;
	ScheduleBean findByID(String id) throws SQLException;
	ArrayList<ScheduleBean> findAll() throws SQLException;
	
}
