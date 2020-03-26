package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysUserService;

@Controller
@RequestMapping("/")
@ResponseBody
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
	
	//查询用户信息
	@RequestMapping("doFindUserObjects")
	public JsonResult doFindObjects(Integer id){
		SysUser userObject = sysUserService.findUserObject(id);
		return new JsonResult(userObject);
	}
}
