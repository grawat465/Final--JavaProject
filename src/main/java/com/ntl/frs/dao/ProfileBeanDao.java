package com.ntl.frs.dao;

import java.util.ArrayList;

import com.ntl.frs.bean.ProfileBean;

public interface ProfileBeanDao {

	
	String createProfileBean(ProfileBean profileBean) ;
	int deleteProfileBean(ArrayList<String> al );
	boolean updateProfileBean(ProfileBean ProfileBean);
	ProfileBean findByID(String id);
	ArrayList<ProfileBean> findAll();
	
}
