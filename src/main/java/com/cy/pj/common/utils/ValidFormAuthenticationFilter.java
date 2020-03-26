package com.cy.pj.common.utils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class ValidFormAuthenticationFilter extends FormAuthenticationFilter {
	
	@Override
	protected AuthenticationToken createToken(String username,String password,ServletRequest request, ServletResponse response) {
		String validCode = request.getParameter("validCode");
		return new ValidToken(username,password,validCode);
    }
}
