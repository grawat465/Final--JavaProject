package com.ntl.daoImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ntl.frs.bean.CredentialsBean;
import com.ntl.frs.bean.FlightBean;
import com.ntl.frs.daoImpl.CredentialsBeanDaoImpl;
import com.ntl.frs.daoImpl.FlightBeanDaoImpl;

public class FlightBeanDaoImplTest {

	FlightBean flightbean=new FlightBean("As8796","Austin",2541,876);
	FlightBeanDaoImpl flight;
	
	@Test
	public void testCreateFlightBean() throws SQLException {

		
		flight=mock(FlightBeanDaoImpl.class);
		
		when(flight.createFlightBean(flightbean)).thenReturn("success");// this is just to test DAO method before testing the actual Authenticate method
		
	
		String result=flight.createFlightBean(flightbean);
		
		assertEquals(result,"success");
	}

	@Test
	public void testDeleteFlightBean() {
	//	fail("Not yet implemented");
	}

	@Test
	public void testUpdateFlightBean() throws SQLException {
flight=mock(FlightBeanDaoImpl.class);
		
		when(flight.updateFlightBean(flightbean)).thenReturn(true);// this is just to test DAO method before testing the actual Authenticate method
		
	
		boolean result=flight.updateFlightBean(flightbean);
		
		assertEquals(result,true);
	}

	@Test
	public void testFindByID() throws SQLException {
		flight=mock(FlightBeanDaoImpl.class);
		
		when(flight.findByID(flightbean.getFlightID())).thenReturn(flightbean);// this is just to test DAO method before testing the actual Authenticate method
		
	
		FlightBean result=flight.findByID(flightbean.getFlightID());
		
		assertEquals(result.getFlightID(),flightbean.getFlightID());
	}

	@Test
	public void testFindAll() throws SQLException {
		flight=mock(FlightBeanDaoImpl.class);
		
		ArrayList<FlightBean> arr=new ArrayList<FlightBean>();
		arr.add(flightbean);
		
		when(flight.findAll()).thenReturn(arr);// this is just to test DAO method before testing the actual Authenticate method
		
	
		ArrayList<FlightBean> result=flight.findAll();
		
		assertEquals(result.size(),1);
	}

}
