package com.ntl.srs.serviceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ntl.frs.bean.FlightBean;
import com.ntl.frs.bean.PassengerBean;
import com.ntl.frs.bean.ReservationBean;
import com.ntl.frs.bean.ScheduleBean;
import com.ntl.frs.daoImpl.FlightBeanDaoImpl;
import com.ntl.frs.daoImpl.PassengerBeanDaoImpl;
import com.ntl.frs.daoImpl.ReservationBeanDaoImpl;
import com.ntl.frs.serviceImpl.CustomerImpl;

public class CustomerImplTest {


	@Test
	public void testViewScheduleByRoute() throws SQLException {
		
		String dobirth="25/03/2019";
		String dateOfBirth[]=dobirth.split("/");
		LocalDate dat=LocalDate.of(Integer.parseInt(dateOfBirth[2]),Integer.parseInt(dateOfBirth[1]), Integer.parseInt(dateOfBirth[0]));
		
		ScheduleBean sb=new ScheduleBean("InAu2345","InAu4786","th3748");
		ArrayList<ScheduleBean> asl=new ArrayList<ScheduleBean>();
		asl.add(sb);
		ReservationBeanDaoImpl reseren=mock(ReservationBeanDaoImpl.class);
		
			when(reseren.ScheduletoRoute("India", "Sri Lanka",dat )).thenReturn(asl);
		
		
		CustomerImpl cust=new CustomerImpl(reseren);
		
		ArrayList<ScheduleBean> result =cust.viewScheduleByRoute("India", "Sri Lanka",dat);
		
		assertEquals(result.size(),1);
	}

	@Test
	public void testReserveTicket() throws SQLException {
		
		String dobirth="25/03/2019";
		String dateOfBirth[]=dobirth.split("/");
		LocalDate dat=LocalDate.of(Integer.parseInt(dateOfBirth[2]),Integer.parseInt(dateOfBirth[1]), Integer.parseInt(dateOfBirth[0]));
		
		String birth="21/06/2019";
		String OfBirth[]=birth.split("/");
		LocalDate datt=LocalDate.of(Integer.parseInt(OfBirth[2]),Integer.parseInt(OfBirth[1]), Integer.parseInt(OfBirth[0]));
		
		
		ReservationBean rb=new ReservationBean("InSr2341","InSr3465","Is1111",dat,datt,4,60000,"confirm");
		
ReservationBeanDaoImpl pas=mock(ReservationBeanDaoImpl.class);
		
	when(pas.createReservationBean(rb)).thenReturn("confirm");
	
	PassengerBean pbbb=new PassengerBean("InAu3456","InAu4763","Ram",32,"Male");
	PassengerBean pb=new PassengerBean("InAu3456","InAu4763","Antara",22,"Female");
	ArrayList<PassengerBean> albean=new ArrayList<PassengerBean>();
	
	albean.add(pb);
	albean.add(pbbb);
	
	
	CustomerImpl cus=mock(CustomerImpl.class);
	
	when(cus.addingPassengers(albean)).thenReturn("success");
		//when(passen.allPass("InAu3456")).thenReturn(true);
	
	CustomerImpl custom=new CustomerImpl(pas,cus);
	
	String result=custom.reserveTicket(rb, albean);
	assertEquals(result,"confirm");
		
	}

	@Test
	public void testCancelTicket() throws SQLException {
		PassengerBean rb=new PassengerBean("InAu3456","InAu4763","Ram",32,"Male");
		PassengerBean pb=new PassengerBean("InAu3456","InAu4763","Antara",22,"Female");
		
		PassengerBeanDaoImpl passen=mock(PassengerBeanDaoImpl.class);
		
		when(passen.allPass("InAu3456")).thenReturn(true);
		
		
		CustomerImpl cust=new CustomerImpl(passen);
		
		boolean result=cust.cancelTicket("InAu3456");
		assertEquals(result,true);
	}

	@Test
	public void testViewTicket() throws SQLException {
		String birth="21/06/2019";
		String OfBirth[]=birth.split("/");
		LocalDate dat=LocalDate.of(Integer.parseInt(OfBirth[2]),Integer.parseInt(OfBirth[1]), Integer.parseInt(OfBirth[0]));
		
		String dobirth="25/03/2019";
		String dateOfBirth[]=dobirth.split("/");
		LocalDate datt=LocalDate.of(Integer.parseInt(dateOfBirth[2]),Integer.parseInt(dateOfBirth[1]), Integer.parseInt(dateOfBirth[0]));
		
	
		
		
	ReservationBean rsb=new ReservationBean("InSr2341","InSr3465","Is1111",dat,datt,4,60000,"pending");
	
	PassengerBean rb=new PassengerBean("InAu3456","InAu4763","Ram",32,"Male");
	PassengerBean pb=new PassengerBean("InAu3456","InAu4763","Antara",22,"Female");

	ArrayList<PassengerBean>	albean=new ArrayList<PassengerBean>();
	
	albean.add(pb);
	albean.add(rb);
	
	PassengerBeanDaoImpl passen=mock(PassengerBeanDaoImpl.class);
	
	when(passen.findAllById("InAu3456")).thenReturn(albean);

	
	ReservationBeanDaoImpl reseren=mock(ReservationBeanDaoImpl.class);
	
	when(reseren.findByID("InAu3456")).thenReturn(rsb);
	
	CustomerImpl cust=new CustomerImpl(reseren,passen);
	
	Map<ReservationBean,PassengerBean> m=new HashMap<ReservationBean,PassengerBean>();
	
	m=cust.viewTicket("InAu3456");
	assertEquals(m,2);			

	
	}

	@Test
	public void testPrintTicket() {
	//	fail("Not yet implemented");
	}

	@Test
	public void testChangeBookingStatus() {
		
		String dobirth="25/03/2019";
		String dateOfBirth[]=dobirth.split("/");
		LocalDate dat=LocalDate.of(Integer.parseInt(dateOfBirth[2]),Integer.parseInt(dateOfBirth[1]), Integer.parseInt(dateOfBirth[0]));
		
		String birth="21/06/2019";
		String OfBirth[]=birth.split("/");
		LocalDate datt=LocalDate.of(Integer.parseInt(OfBirth[2]),Integer.parseInt(OfBirth[1]), Integer.parseInt(OfBirth[0]));
		
		
		
	ReservationBean rb=new ReservationBean("InSr2341","InSr3465","Is1111",dat,datt,4,60000,"pending");
		
		ReservationBeanDaoImpl reseren=mock(ReservationBeanDaoImpl.class);
		
			when(reseren.updateReservationBean(rb)).thenReturn(true);
		
		
			CustomerImpl cust=new CustomerImpl(reseren);
		
		boolean result = cust.changeBookingStatus(rb);
		
		assertEquals(result,true);
	}

	@Test
	public void testAddingPassengers() throws SQLException {
		PassengerBean rb=new PassengerBean("InAu3456","InAu4763","Ram",32,"Male");
		PassengerBean pb=new PassengerBean("InAu3456","InAu4763","Antara",22,"Female");
		ArrayList<PassengerBean>	albean=new ArrayList<PassengerBean>();
		
		albean.add(pb);
		albean.add(rb);
		
		PassengerBeanDaoImpl passen=mock(PassengerBeanDaoImpl.class);
		
		when(passen.createPassengerBean(pb)).thenReturn("success");
		when(passen.createPassengerBean(rb)).thenReturn("success");
		
		CustomerImpl cust=new CustomerImpl(passen);
		
		String status=cust.addingPassengers(albean);
		assertEquals(status,"success");
		
	}

}
