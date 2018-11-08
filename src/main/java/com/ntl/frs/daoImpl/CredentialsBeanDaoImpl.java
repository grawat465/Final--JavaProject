package com.ntl.frs.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ntl.frs.bean.CredentialsBean;
import com.ntl.frs.dao.CredentialsBeanDao;
import com.ntl.frs.utilImpl.DBUtilImpl;

import java.sql.*;

public class CredentialsBeanDaoImpl implements CredentialsBeanDao{
	
			
			Statement stmt=null;
			ResultSet rs=null;
			PreparedStatement ps=null;
		
			static String str[]=new String[2];
			
			static Connection con;
			

			public CredentialsBeanDaoImpl() {
				super();
			}







	public String[] credentials(CredentialsBean credentialsBean){
		
		Connection con=DBUtilImpl.getDBConnection("jdbc");
		int flag=0;
		try {	
		stmt=con.createStatement();
		rs=stmt.executeQuery("select * from frs_TBL_User_Credentials");
		
			while(rs.next())
			{
				String id=rs.getString(1);
				String pass=rs.getString(2);
				if(credentialsBean.getUserID().equals(id) && credentialsBean.getPassword().equals(pass) && rs.getInt(4)==0)
				{
					str[0]= rs.getString(3);
					str[1]=""+rs.getInt(4);
					flag=1;
					
					return str;
				}
			}
			if(flag==0)
			{
				str[0]=str[1]="invalid";
				return str;
			}
		}
		catch(SQLException sq)
		{
			sq.printStackTrace();
		}
	
		return null;
				
			}
	
	


	

	/*@Override
	public int deleteCredentialsBean(ArrayList<String> al) {
		// TODO Auto-generated method stub
		return 0;
	}
*/

	
	public boolean updateCredentialsBean(CredentialsBean credentialsBean) {
		//System.out.println("ishanya");
		Connection con=DBUtilImpl.getDBConnection("jdbc");
		try {
			int z=((credentialsBean.getLoginStatus()+1)%2);
		ps=con.prepareStatement("update frs_TBL_User_Credentials set LoginStatus="+z+" where UserId='"+credentialsBean.getUserID()+"'");
		
		int state=ps.executeUpdate();
			if(state>0)
			{
				return true;
			}
			else {
			return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}


	
	public CredentialsBean findByID(String id) {
		// TODO Auto-generated method stub
		
		Connection con=DBUtilImpl.getDBConnection("jdbc");
		
		int flag=0;
		try {	
		stmt=con.createStatement();
		rs=stmt.executeQuery("select * from frs_TBL_User_Credentials where UserId='"+id+"'");
		
			
				
					while(rs.next()) {
						
					flag=1;
					
					CredentialsBean credentials=new CredentialsBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				
					return credentials;
					
				}
			
			if(flag==0)
			{
				
				return null;
			}
		}
		catch(SQLException sq)
		{
			sq.printStackTrace();
		}
		
		
		return null;
	}


	
	public ArrayList<CredentialsBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean changingPassword(CredentialsBean cd)
	{
		Connection con=DBUtilImpl.getDBConnection("jdbc");
		//System.out.println(cd.getPassword()+" "+cd.getUserID());
		
		try {
			ps=con.prepareStatement("update frs_TBL_User_Credentials set Password='"+cd.getPassword()+"' where userid='"+cd.getUserID()+"'");
			int change=ps.executeUpdate();
			if(change>0)
			{
				return true;
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}








	public String createCredentialsBean(CredentialsBean credentialsBean) {
		// TODO Auto-generated method stub
		return null;
	}








	public int deleteCredentialsBean(ArrayList<String> al) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
