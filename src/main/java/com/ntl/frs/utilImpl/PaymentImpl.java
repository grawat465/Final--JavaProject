package com.ntl.frs.utilImpl;

import java.sql.SQLException;

import com.ntl.frs.bean.PaymentBean;
import com.ntl.frs.daoImpl.PaymentDaoImpl;
import com.ntl.frs.util.Payment;

public class PaymentImpl implements Payment {

	PaymentDaoImpl pay=new PaymentDaoImpl();
	PaymentBean pb=new PaymentBean();
	
	
	
	
	/**
	 * 
	 */
	public PaymentImpl() {
		super();
	}


	public PaymentImpl(PaymentDaoImpl pet) {
		super();
		pay=pet;
	}

	
	public boolean findByCardNumber(String userid, String cardnumber) throws SQLException {
		pb=pay.findByID(userid, cardnumber);
		if(pb!=null)
		{
			return true;
		}
		return false;
	}

	
	public String process(PaymentBean payment ) throws SQLException {
		String state=pay.createPaymentBean(payment);
		if(state!=null)
		{
			return state;
		}
		return null;
	}

	



}
