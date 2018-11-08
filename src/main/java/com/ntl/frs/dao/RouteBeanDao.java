package com.ntl.frs.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ntl.frs.bean.RouteBean;

public interface RouteBeanDao {


	String createRouteBean(RouteBean routeBean) throws SQLException;
	int deleteRouteBean(ArrayList<String> al ) throws SQLException;
	boolean updateRouteBean(RouteBean routeBean) throws SQLException ;
	RouteBean findByID(String id) throws SQLException;
	ArrayList<RouteBean> findAll() throws SQLException;
	
}
