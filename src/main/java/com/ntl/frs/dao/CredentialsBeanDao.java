package com.ntl.frs.dao;


import java.util.ArrayList;

import com.ntl.frs.bean.CredentialsBean;


public interface CredentialsBeanDao {

		
		String createCredentialsBean(CredentialsBean credentialsBean) ;
		int deleteCredentialsBean(ArrayList<String> al );
		boolean updateCredentialsBean(CredentialsBean credentialsBean);
		CredentialsBean findByID(String id);
		ArrayList<CredentialsBean> findAll();
		
	}

	

