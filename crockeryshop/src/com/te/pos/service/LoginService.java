package com.te.pos.service;

import com.te.pos.dao.LoginDAO;
import com.te.pos.security.AESEncryptionDecryptionUtility;

public class LoginService {

	public Boolean loginToSystem(String username,String password) throws Exception{
		Boolean allowUserToLogin=false;
		allowUserToLogin=new LoginDAO().loginToSystem(username, AESEncryptionDecryptionUtility.encrypt(password));
		return allowUserToLogin;
	}

}
