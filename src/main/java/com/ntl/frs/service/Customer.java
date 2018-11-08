package com.ntl.frs.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.ntl.frs.bean.PassengerBean;
import com.ntl.frs.bean.ReservationBean;
import com.ntl.frs.bean.ScheduleBean;

public interface Customer {

	ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, LocalDate date) throws SQLException ;
	String reserveTicket(ReservationBean reservationBean, ArrayList<PassengerBean> passengerBean) throws SQLException;
	 boolean cancelTicket(String reservationId) throws SQLException ;
	 Map<ReservationBean ,PassengerBean>viewTicket(String reservationId) throws SQLException ;
	
	Map<ReservationBean,PassengerBean>  printTicket (String reservationId);
	
}
