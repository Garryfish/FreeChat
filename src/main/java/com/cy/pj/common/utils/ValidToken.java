package com.cy.pj.common.utils;

import org.apache.shiro.authc.UsernamePasswordToken;

public class ValidToken extends UsernamePasswordToken{
	private static final long serialVersionUID = -76222656930207167L;
	
	private String validCode;
	
	public ValidToken(String username,String password,String validCode) {
		super(username, password, false, "");
		this.validCode=validCode;
	}

	public String getValidCode() {
		return validCode;
	}
}
