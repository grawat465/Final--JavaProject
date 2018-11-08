package com.ntl.frs.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ntl.frs.bean.PassengerBean;

public interface PassengerBeanDao {


	String createPassengerBean(PassengerBean passengerBean) throws SQLException;
	int deletePassengerBean(ArrayList<String> al );
	boolean updatePassengerBean(PassengerBean passengerBean) throws SQLException ;
	PassengerBean findByID(String id) throws SQLException;
	ArrayList<PassengerBean> findAll() throws SQLException;
	
}
