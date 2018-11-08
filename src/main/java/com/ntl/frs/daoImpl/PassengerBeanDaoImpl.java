package com.ntl.frs.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ntl.frs.bean.FlightBean;
import com.ntl.frs.bean.PassengerBean;
import com.ntl.frs.bean.ReservationBean;
import com.ntl.frs.dao.PassengerBeanDao;
import com.ntl.frs.utilImpl.DBUtilImpl;

public class PassengerBeanDaoImpl implements PassengerBeanDao{

	Connection con=DBUtilImpl.getDBConnection("jdbc");
	PreparedStatement ps=null;
	ResultSet rs=null;
	ReservationBeanDaoImpl rserve =new ReservationBeanDaoImpl();
	
	public String createPassengerBean(PassengerBean passengerBean) throws SQLException {
		
		//System.out.println("pass "+passengerBean.getReservationID()+" and "+passengerBean.getName());
		ReservationBean rbn=new ReservationBean();
		rbn=rserve.findByID(passengerBean.getReservationID());
	//	System.out.println("rbn "+rbn.getScheduleID());
		passengerBean.setScheduleID(rbn.getScheduleID());
		
		ps=con.prepareStatement("insert into frs_tbl_passenger values(?,?,?,?,?)");
		ps.setString(1, passengerBean.getReservationID());
		ps.setString(2,passengerBean.getScheduleID());
		ps.setString(3, passengerBean.getName());
		ps.setInt(4, passengerBean.getAge());
		ps.setString(5, passengerBean.getGender());
		
		int ans=ps.executeUpdate();
		if(ans>0)
		{
			return "Success";
		}
		return null;
	}

	
	public int deletePassengerBean(ArrayList<String> al) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public boolean updatePassengerBean(PassengerBean passengerBean) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public PassengerBean findByID(String id) throws SQLException {
		
		ps=con.prepareStatement("select * from frs_tbl_passenger where reservationId='"+id+"'");
		rs=ps.executeQuery();
		while(rs.next())
		{
			PassengerBean sp=new PassengerBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			System.out.println("Govind "+sp.getReservationID());
			return sp;
		}
		
		
		return null;
	}

	
	public ArrayList<PassengerBean> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean allPass(String id) throws SQLException {
		
		ps=con.prepareStatement("delete from frs_tbl_passenger where reservationId='"+id+"'");
		int test=ps.executeUpdate();
		if(test>0)
		{
			return true;
		}
		return false;
	}
	
	public ArrayList<PassengerBean> findAllById(String id) throws SQLException 
	{
		ArrayList<PassengerBean> al=new ArrayList();
		
		ps=con.prepareStatement("select * from frs_tbl_passenger where reservationId='"+id+"'");
		rs=ps.executeQuery();
		while(rs.next())
		{
			PassengerBean sp=new PassengerBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			al.add(sp);
		}
		if(al!=null)
		{
			return al;
		}
		
		return null;
	}

	public ArrayList<PassengerBean> findByFlight(String flightId) throws SQLException
	{
		ArrayList<PassengerBean> al=new ArrayList();
		
		ps=con.prepareStatement("select frs_tbl_passenger.reservationId,frs_tbl_passenger.scheduleId,frs_tbl_passenger.name,frs_tbl_passenger.age,frs_tbl_passenger.gender from frs_tbl_passenger inner join frs_tbl_schedule on frs_tbl_passenger.scheduleId=frs_tbl_schedule.scheduleId where frs_tbl_schedule.flightId='"+flightId+"'");
		rs=ps.executeQuery();
		while(rs.next())
		{
			PassengerBean sp=new PassengerBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			al.add(sp);
		}
		if(al!=null)
		{
			return al;
		}
		
		return null;
	}
	
}
