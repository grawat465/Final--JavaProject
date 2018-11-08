package com.ntl.frs.serviceImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import com.ntl.frs.bean.PassengerBean;
import com.ntl.frs.bean.ReservationBean;
import com.ntl.frs.bean.RouteBean;
import com.ntl.frs.bean.ScheduleBean;
import com.ntl.frs.daoImpl.PassengerBeanDaoImpl;
import com.ntl.frs.daoImpl.ReservationBeanDaoImpl;
import com.ntl.frs.service.Customer;

public class CustomerImpl implements Customer{
ReservationBeanDaoImpl reservebean=new ReservationBeanDaoImpl();
ArrayList<ScheduleBean>	albean=new ArrayList<ScheduleBean>();
AdministratorImpl al=new AdministratorImpl();
PassengerBeanDaoImpl passbean=new PassengerBeanDaoImpl();
static CustomerImpl cussto=null;

	
	/**
 * 
 */
public CustomerImpl() {
	super();
}


public CustomerImpl(ReservationBeanDaoImpl rimpl) {
	super();
	reservebean=rimpl;
}

public CustomerImpl(PassengerBeanDaoImpl pimpl) {
	super();
	passbean=pimpl;
}

public CustomerImpl(ReservationBeanDaoImpl rimpl,PassengerBeanDaoImpl pimpl) {
	super();
	reservebean=rimpl;
	passbean=pimpl;
}

public CustomerImpl(ReservationBeanDaoImpl rimpl,CustomerImpl cimpl) {
	super();
	reservebean=rimpl;
	cussto=new CustomerImpl();
	cussto=cimpl;
}



	public ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, LocalDate date) throws SQLException {
		
		albean=reservebean.ScheduletoRoute(source, destination, date);
		if(albean!=null)
		{
			return albean;
		}
		return null;
	}

	
	public String reserveTicket(ReservationBean reservationBean, ArrayList<PassengerBean> passengerBean) throws SQLException {

		
		CustomerImpl cus=new CustomerImpl();	
		String rRID=reservebean.createReservationBean(reservationBean);
		String pPID=null;
		
		if(rRID.equalsIgnoreCase("confirm")) {
		pPID=cus.addingPassengers(passengerBean);		
		
		}
		if(rRID!=null && pPID!=null)
		{
			return rRID;
		}
		else{
			return "Pending";
		}
		
		
		
	}

	
	public boolean cancelTicket(String reservationId) throws SQLException {
		if(passbean.allPass(reservationId))
		{
			return true;
		}
		return false;
	}

	
	public Map<ReservationBean, PassengerBean> viewTicket(String reservationId) throws SQLException {
		ArrayList<PassengerBean> al=new ArrayList<PassengerBean>();
		al=passbean.findAllById(reservationId);
		ReservationBean res=new ReservationBean();
		res =reservebean.findByID(reservationId);
		//System.out.println(al.size());
		Map<ReservationBean,PassengerBean> map = new HashMap<ReservationBean,PassengerBean>();
		for(PassengerBean m:al)
		{
			map.put(res, m);
			
		}
//		PassengerBean passion =map.get(res);
//		System.out.println(passion.getName());
		if(map!=null)
		{
			return map;
		}
		return null;
	}

	
	public Map<ReservationBean, PassengerBean> printTicket(String reservationId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean changeBookingStatus(ReservationBean reservationBean)
	{
		if(reservebean.updateReservationBean(reservationBean)) {
			return true;
		}
		return false;
	}
	
	public String addingPassengers(ArrayList<PassengerBean> passengerBean) throws SQLException{
		String pPID=null;
		//System.out.println(passengerBean.size());
		for(PassengerBean pass:passengerBean)
		{
			
			 pPID=passbean.createPassengerBean(pass);
			if(pPID==null)
			{
				return pPID;
				
			}
		}
		return pPID;
	}

}
 