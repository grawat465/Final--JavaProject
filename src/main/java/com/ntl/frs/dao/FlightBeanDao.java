package com.ntl.frs.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ntl.frs.bean.FlightBean;

public interface FlightBeanDao {
	
	String createFlightBean(FlightBean flightBean) throws SQLException;
	int deleteFlightBean(ArrayList<String> al );
	boolean updateFlightBean(FlightBean flightBean) throws SQLException ;
	FlightBean findByID(String id) throws SQLException;
	ArrayList<FlightBean> findAll() throws SQLException;
	
}
