package com.cy.pj.sys.controller;

import javax.servlet.http.HttpServletRequest;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.service.SysUserRealmService;


@RestController
@RequestMapping("/user/")
public class LoginController {
	
	@Autowired
	private KaptchaController kaptchaController;
	@Autowired
	private SysUserRealmService sysUserRealmService;

	@RequestMapping("doLogin")
	public JsonResult doLogin(HttpServletRequest request,boolean isRememberMe,String username,String password,String validCode){
		//1.获取Subject对象
		Subject subject=SecurityUtils.getSubject();
		//2.通过Subject提交用户信息,交给shiro框架进行认证操作
		//2.1对用户进行封装
		UsernamePasswordToken token=  new UsernamePasswordToken(username,password,validCode);
		String rightCode = (String)request.getSession().getAttribute("rightCode");
		System.out.println("rightCode:" + rightCode + "---------tryCode:" + validCode);
		if(isRememberMe) {
			token.setRememberMe(true); 
		}
		//2.2对用户信息进行身份认证
		subject.login(token);
		if(!rightCode.equals(validCode)) throw new ServiceException("验证码不正确");
		//分析:
		//1)token会传给shiro的SecurityManager
		//2)SecurityManager将token传递给认证管理器
		//3)认证管理器会将token传递给realm
		return new JsonResult("login_ok");
	}

	
//	@RequestMapping("/imgvrifyControllerDefaultKaptcha")
//	public JsonResult doCheckKaptcha(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
//		ModelAndView result = kaptchaService.imgvrifyControllerDefaultKaptcha(httpServletRequest, httpServletResponse);
//		return new JsonResult(result);
//	}

}
