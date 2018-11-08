package com.ntl.UtilImpl;

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

import com.ntl.frs.bean.PassengerBean;
import com.ntl.frs.bean.PaymentBean;
import com.ntl.frs.daoImpl.PassengerBeanDaoImpl;
import com.ntl.frs.daoImpl.PaymentDaoImpl;
import com.ntl.frs.serviceImpl.CustomerImpl;
import com.ntl.frs.utilImpl.PaymentImpl;

public class PaymentImplTest {


	@Test
	public void testFindByCardNumber() throws SQLException {
		
		
		PaymentBean paid=new PaymentBean("234678654980","20/10/2013","19/12/2024",50000,"Is1112");
		
		PaymentDaoImpl pay=mock(PaymentDaoImpl.class);
		
		when(pay.findByID("Is1112","234678654980")).thenReturn(paid);
		
		
		PaymentImpl cust=new PaymentImpl(pay);
		
		boolean status=cust.findByCardNumber("Is1112","234678654980");
		assertEquals(status,true);
		
	}

	@Test
	public void testProcess() throws SQLException {
		
		PaymentBean paid=new PaymentBean("234678654980","20/10/2013","19/12/2024",50000,"Is1112");
		
		PaymentDaoImpl pay=mock(PaymentDaoImpl.class);
		
		when(pay.createPaymentBean(paid)).thenReturn("success");
		
		
		PaymentImpl cust=new PaymentImpl(pay);
		
		String status=cust.process(paid);
		assertEquals(status,"success");
		
	}

}
