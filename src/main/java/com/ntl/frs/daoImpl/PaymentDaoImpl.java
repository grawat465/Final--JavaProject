package com.ntl.frs.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ntl.frs.bean.PaymentBean;
import com.ntl.frs.bean.RouteBean;
import com.ntl.frs.dao.PaymentDao;
import com.ntl.frs.utilImpl.DBUtilImpl;

public class PaymentDaoImpl implements PaymentDao{


	Connection con=DBUtilImpl.getDBConnection("jdbc");
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	
	public String createPaymentBean(PaymentBean paymentBean) throws SQLException {
		try {
			ps=con.prepareStatement("insert into frs_TBL_creditcard values(?,?,?,?,?)");
			ps.setString(1, paymentBean.getCreditCard());
			ps.setString(2, paymentBean.getValidFrom());
			ps.setString(3, paymentBean.getValidTo());
			ps.setInt(4,paymentBean.getBalance());
			ps.setString(5, paymentBean.getUserId());
			}catch(SQLException sq)
			{
				sq.printStackTrace();
				}
			int add=ps.executeUpdate();
			if(add>0)
			return "success";
			else {
				return null;
			}
		
	}

	
	public boolean updatePaymentBean(PaymentBean paymentBean) throws SQLException {
	return false;
	}

	
	public PaymentBean findByID(String userId,String id) throws SQLException {
		
		ps=con.prepareStatement("select * from frs_tbl_creditcard where CreditCardNumber='"+id+"' and userId='"+userId+"'");
		rs=ps.executeQuery();
		while(rs.next())
		{
		PaymentBean pbean=new PaymentBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
		
			return pbean;
		}
		return null;
	}

}
