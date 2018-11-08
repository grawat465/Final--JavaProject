package com.ntl.frs.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ntl.frs.bean.FlightBean;
import com.ntl.frs.bean.RouteBean;
import com.ntl.frs.dao.RouteBeanDao;
import com.ntl.frs.utilImpl.DBUtilImpl;

public class RouteBeanDaoImpl implements RouteBeanDao{

	Connection con=DBUtilImpl.getDBConnection("jdbc");
	PreparedStatement ps=null,pss=null;
	ResultSet rs=null;
	
	
	public String createRouteBean(RouteBean routeBean) throws SQLException {

		try {
			ps=con.prepareStatement("insert into frs_TBL_Route values(?,?,?,?,?)");
			ps.setString(1, routeBean.getRouteID());
			ps.setString(2, routeBean.getSource());
			ps.setString(3, routeBean.getDestination());
			ps.setString(4,routeBean.gettravelDuration());
			ps.setInt(5, routeBean.getFare());
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

	
	public int deleteRouteBean(ArrayList<String> al) throws SQLException {
		int flag=1;
		for(String i:al) {
		try {
			pss=con.prepareStatement("delete from frs_tbl_schedule where routeId='"+i+"'");
			int d=pss.executeUpdate();
			
				ps=con.prepareStatement("delete from frs_tbl_route where routeId='"+i+"'");
				int del=ps.executeUpdate();
				if(del==0)
				{
					System.out.println("in deletion");
					flag=0;
					return 0;
				}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		}
		System.out.println(flag);
		return flag;
		
	}

	
	public boolean updateRouteBean(RouteBean routeBean) throws SQLException {
		ps=con.prepareStatement("update frs_tbl_route set source='"+routeBean.getSource()+"', Destination='"+routeBean.getDestination()+"',fare='"+routeBean.getFare()+"' where RouteId='"+routeBean.getRouteID()+"'");
		int modify=ps.executeUpdate();
		if(modify>0)
		{
			return true;
		}
		return false;
	}

	
	public RouteBean findByID(String id) throws SQLException {
		ps=con.prepareStatement("select * from frs_tbl_route where routeId='"+id+"'");
		
		rs=ps.executeQuery();
		while(rs.next())
		{
		RouteBean rbean=new RouteBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
		
			return rbean;
		}
		return null;
	}

	
	public ArrayList<RouteBean> findAll() throws SQLException {
		ArrayList<RouteBean> route=new ArrayList<RouteBean>();
		ps=con.prepareStatement("select * from frs_tbl_route ");
		rs=ps.executeQuery();
		while(rs.next())
		{
			RouteBean sp=new RouteBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
			route.add(sp);
		}
		if(rs.first())
		{
			return route;
		}
		return null;
	}

}
