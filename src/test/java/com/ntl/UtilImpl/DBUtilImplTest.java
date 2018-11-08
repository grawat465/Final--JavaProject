package com.ntl.UtilImpl;


import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;

import com.ntl.frs.utilImpl.DBUtilImpl;

//import test.com.ntl.srs.utilImpl.MockitoJUnitRunner;


//@RunWith(MockitoJUnit.class)
class DBUtilImplTest {

	

	@Test
	void testGetDBConnection() {
		Connection conn=null;
		conn=DBUtilImpl.getDBConnection("jdbc");
		assertEquals(conn.toString(), "com.mysql.cj.jdbc.ConnectionImpl@b86de0d");

	}

}
