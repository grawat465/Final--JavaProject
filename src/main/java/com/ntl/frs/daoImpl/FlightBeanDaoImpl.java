 package com.ntl.frs.daoImpl;

import java.util.ArrayList;

import com.ntl.frs.bean.FlightBean;
import com.ntl.frs.dao.FlightBeanDao;
import com.ntl.frs.utilImpl.DBUtilImpl;

import java.sql.*;

public class FlightBeanDaoImpl implements FlightBeanDao{

	Connection con=DBUtilImpl.getDBConnection("jdbc");
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	
	public String createFlightBean(FlightBean flightBean) throws SQLException {
		
		ps=con.prepareStatement("insert into frs_TBL_flight values(?,?,?,?)");
		ps.setString(1, flightBean.getFlightID());
		ps.setString(2, flightBean.getFlightName());
		ps.setInt(3, flightBean.getSeatingCapacity());
		ps.setInt(4, flightBean.getReservationCapacity());
		int add=ps.executeUpdate();
		if(add>0)
		return "success";
		else {
			return null;
		}
	}

	
	public int deleteFlightBean(ArrayList<String> al) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean updateFlightBean(FlightBean flightBean) throws SQLException   {
		// TODO Auto-generated method stub
			
			ps=con.prepareStatement("update frs_TBL_Flight set FlightName='"+flightBean.getFlightName()+"', SeatingCapacity='"+flightBean.getSeatingCapacity()+"',ReservationCapacity='"+flightBean.getReservationCapacity()+"' where flightId='"+flightBean.getFlightID()+"'");
			int modify=ps.executeUpdate();
			if(modify>0)
				return true;
			else {
				return false;
			}
		}

		
	

	
	public FlightBean findByID(String id) throws SQLException {
		// TODO Auto-generated method stub
		
		ps=con.prepareStatement("select * from frs_tbl_flight where flightId='"+id+"'");
		rs=ps.executeQuery();
		while(rs.next())
		{
		FlightBean sbean=new FlightBean(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
		
			return sbean;
		}
		return null;
	}

	
	public ArrayList<FlightBean> findAll() throws SQLException {
		ArrayList<FlightBean> flight=new ArrayList<FlightBean>();
		ps=con.prepareStatement("select * from frs_tbl_flight ");
		rs=ps.executeQuery();
		while(rs.next())
		{
			FlightBean sp=new FlightBean(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
			flight.add(sp);
		}
		if(rs.first())
		{
			return flight;
		}
		return null;
	}

}
