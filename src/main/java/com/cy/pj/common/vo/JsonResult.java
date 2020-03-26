package com.cy.pj.common.vo;

import java.io.Serializable;

import com.cy.pj.sys.entity.SysUser;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JsonResult implements Serializable{

	private static final long serialVersionUID = 2080943344863436345L;
	
	private int state=1;
	private String message="ok";
	private Object data;
	
	public JsonResult(String message){
		this.message=message;
	}
	/**一般查询时调用，封装查询结果*/
	public JsonResult(Object data) {
		this.data=data;
	}
	/**出现异常时时调用*/
	public JsonResult(Throwable t){
		this.state=0;
		this.message=t.getMessage();
	}
}
