package com.ntl.UtilImpl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
//import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ntl.frs.bean.CredentialsBean;
import com.ntl.frs.bean.ProfileBean;
import com.ntl.frs.daoImpl.CredentialsBeanDaoImpl;
import com.ntl.frs.daoImpl.ProfileBeanDaoImpl;
import com.ntl.frs.utilImpl.LoggedIn;
import com.ntl.frs.utilImpl.PaymentImpl;
import com.ntl.frs.utilImpl.SignedUp;

public class SignedUpTest {


	public SignedUpTest() {
		super();
	}

	LoggedIn log=null;
	CredentialsBeanDaoImpl cred;
	ProfileBeanDaoImpl prof;
	
//	@Test
	public void testLogin() {
		
		CredentialsBean cdf=new CredentialsBean("Go4372","Govind@123","C",0);
		
		//cred=mock(CredentialsBeanDaoImpl.class);
		
		boolean value=true;
		
		
//		when(cred.findByID("Go4372")).thenReturn(cdf);// this is just to test DAO method before testing the actual Authenticate method
//		
//		when(cred.updateCredentialsBean(cdf)).thenReturn(value);// this is just to test DAO method before testing the actual Authenticate method
//		
		log=mock(LoggedIn.class);
		
		when(log.authenticate(cdf)).thenReturn(value);
		when(log.authorize("Go4372")).thenReturn("C");
		when(log.changeLoginStatus(cdf,0)).thenReturn(value);
		
		
		SignedUp sign=new SignedUp(log);
		String result = sign.login(cdf);
		
		assertEquals(result,"C");
		
	}

	
	
	
	@Test
	public void testLogout() {
		
		CredentialsBean cp=new CredentialsBean("Is1111","Ishanya@222","A",1);
		boolean val=true;
		
		CredentialsBeanDaoImpl cred=mock(CredentialsBeanDaoImpl.class);
		when(cred.findByID(cp.getUserID())).thenReturn(cp);
		
		
		LoggedIn loog=mock(LoggedIn.class);
		when(loog.changeLoginStatus(cp,1)).thenReturn(val);
		
		
		
		SignedUp sign=new SignedUp(loog,cred);
		boolean s=sign.logout("Is1111");
		assertEquals(false,s);
	}

	
//	@Test
	public void testChangePassword() {
		CredentialsBean cne=new CredentialsBean("Is1111","Ishanya#234","A",1);
		//CredentialsBean cnew=new CredentialsBean("Is1111","Ishanya#234","A",1);
		
		cred=mock(CredentialsBeanDaoImpl.class);
		
		
			when(cred.changingPassword(cne)).thenReturn(true);// this is just to test DAO method before testing the actual Authenticate method
		
		SignedUp sign=new SignedUp(cred);
		String s=sign.changePassword(cne,"Ishanya#234");
		assertEquals(s,"Is1111");
	}

	//@Test
	public void testRegister() {
		
		String dobirth="25/03/1996";
		String dateOfBirth[]=dobirth.split("/");
		LocalDate dob=LocalDate.of(Integer.parseInt(dateOfBirth[2]),Integer.parseInt(dateOfBirth[1]), Integer.parseInt(dateOfBirth[0]));
		
		
		ProfileBean p=new ProfileBean("Ra1234","Ram","Sharma",dob,"Male","sector tz","NOida","G.noida","UP","13242","8978676756","ram@gmail.com","ramji");
		//ProfileBean pe=new ProfileBean("Ra1234","Ram","Sharma",dob,"Male","sector tz","NOida","G.noida","UP","13242","8978676756","ram@gmail.com","ramji");
		
		
		prof=mock(ProfileBeanDaoImpl.class);
		when(prof.createProfileBean(p)).thenReturn("success");// this is just to test DAO method before testing the actual Authenticate method
		
		SignedUp signup=new SignedUp(prof);
		
		String s=signup.register(p);
		assertEquals(s,"success");
	}

	

	
	
}
