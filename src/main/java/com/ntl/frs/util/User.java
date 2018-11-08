package com.ntl.frs.util;

import com.ntl.frs.bean.CredentialsBean;
import com.ntl.frs.bean.ProfileBean;

public interface User {
	String login(CredentialsBean credentialsBean);
	boolean logout(String userId) ;
	String changePassword(CredentialsBean credentialsBean, String newPassword) ;
	String register(ProfileBean profileBean);
}
