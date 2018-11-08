package com.ntl.frs.util;

import java.sql.SQLException;

import com.ntl.frs.bean.PaymentBean;

public interface Payment {

	boolean findByCardNumber(String userid, String cardnumber) throws SQLException;
	String process(PaymentBean payment) throws SQLException;
	


	
}
