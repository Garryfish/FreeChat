package com.cy.pj.common.utils;

import org.apache.shiro.SecurityUtils;

import com.cy.pj.sys.entity.SysUser;

public class ShiroUtils {
	public static SysUser getUser() {
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		return user;
	}
}
