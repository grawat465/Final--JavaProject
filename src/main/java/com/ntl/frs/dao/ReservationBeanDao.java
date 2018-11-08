package com.ntl.frs.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ntl.frs.bean.ReservationBean;

public interface ReservationBeanDao {


	String createReservationBean(ReservationBean reservationBean) throws SQLException ;
	int deleteReservationBean(ArrayList<String> al );
	boolean updateReservationBean(ReservationBean reservationBean);
	ReservationBean findByID(String id) throws SQLException;
	ArrayList<ReservationBean> findAll();
	
}
