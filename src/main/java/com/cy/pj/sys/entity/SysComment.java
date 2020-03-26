package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class SysComment implements Serializable{
	
	private static final long serialVersionUID = -5275913968156792392L;
	private Integer id;
	private String content;
	private Date createdtime;
	private Date modifiedtime;
	private Integer postId;
	private String newDate;
	
}
