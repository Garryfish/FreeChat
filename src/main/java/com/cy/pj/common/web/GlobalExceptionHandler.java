package com.cy.pj.common.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cy.pj.common.vo.JsonResult;

//@ControllerAdvice//描述的类表示一个全局异常处理类
@RestControllerAdvice//等同于@ControllerAdvice+@ResponseBody  
					 //@ResponseBody从方法上提到类上方
@ResponseBody
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)//描述的方法为一个异常处理方法
	//@ResponseBody
	public JsonResult doHandleRuntimeException(RuntimeException e) {
		e.printStackTrace();//也可以写日志
		return new JsonResult(e);//封装异常信息
	}
}
