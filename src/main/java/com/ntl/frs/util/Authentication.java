package com.ntl.frs.util;

import com.ntl.frs.bean.CredentialsBean;

public interface Authentication {
	boolean authenticate(CredentialsBean credentialsBean);
	String authorize(String Userid);
	boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) ;
}
