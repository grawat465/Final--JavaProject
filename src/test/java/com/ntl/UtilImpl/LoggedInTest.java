package com.ntl.UtilImpl;



import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
//import org.testng.annotations.BeforeTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ntl.frs.bean.CredentialsBean;
import com.ntl.frs.daoImpl.CredentialsBeanDaoImpl;
import com.ntl.frs.utilImpl.LoggedIn;
import com.ntl.srs.serviceImpl.CustomerImplTest;

public class LoggedInTest {

	
	CredentialsBeanDaoImpl cred;
	
	

	/**
	 * 
	 */
	public LoggedInTest() {
		super();
	}


//
//	public LoggedInTest(CredentialsBeanDaoImpl credd) {
//		super();
//		cred=credd;
//	}

	
	
	@Test
	 public void testAuthenticate() {
		cred=mock(CredentialsBeanDaoImpl.class);
		when(cred.findByID("Is1111")).thenReturn(new CredentialsBean("Is1111","Ishanya@333","A",0));// this is just to test DAO method before testing the actual Authenticate method
		
		LoggedIn log=new LoggedIn(cred);
		
		boolean result = log.authenticate(new CredentialsBean("Is1111","Ishanya@333","A",0));
		
		assertTrue(result);
	}
	
	
	

	@Test
	public 	void testAuthorize() {
		cred=mock(CredentialsBeanDaoImpl.class);
		when(cred.findByID("Is1111")).thenReturn(new CredentialsBean("Is1111","Ishanya@333","A",0));// this is just to test DAO method before testing the actual Authenticate method
		LoggedIn log=new LoggedIn(cred);
		String result = log.authorize("Is1111");
		assertEquals(result, "A");
	}

	@Test
	public 	void testChangeLoginStatus() {
	
	CredentialsBean cd=new CredentialsBean("Is1112","Ishanya@222","A",0);
		boolean val=true;
		cred=mock(CredentialsBeanDaoImpl.class);
		when(cred.findByID("Is1112")).thenReturn(cd);// this is just to test DAO method before testing the actual Authenticate method
		
		when(cred.updateCredentialsBean(cd)).thenReturn(val);// this is just to test DAO method before testing the actual Authenticate method
		
		
		LoggedIn log=new LoggedIn(cred);
		boolean result=log.changeLoginStatus(cd, 0);
		assertTrue(result);
	}

}
