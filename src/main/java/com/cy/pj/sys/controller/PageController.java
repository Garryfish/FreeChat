package com.cy.pj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.utils.ShiroUtils;
import com.cy.pj.common.utils.newDateUtils;
import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysPost;
import com.cy.pj.sys.entity.SysUser;

/*在此controller中定义项目中的页面*/

@Controller
@RequestMapping("/")
public class PageController {


	// 返回各模块的页面
	@RequestMapping("{moduleUI}")
	public String doMenuUI(@PathVariable String moduleUI) {
		return moduleUI;
	}
	
	@RequestMapping("getLoginUser")
	@ResponseBody
	public JsonResult getLoginUser() {
		System.out.println();
		String newDate = newDateUtils.newDate(ShiroUtils.getUser().getCreatedTime());
		ShiroUtils.getUser().setNewTime(newDate);
		return new JsonResult(ShiroUtils.getUser());
	}
	
}
