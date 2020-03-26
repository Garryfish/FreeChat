package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
@Data
public class SysPost implements Serializable{

	private static final long serialVersionUID = 2366941226104488364L;
	private Integer id;
	private String postname;//帖子名称
	private String content;//帖子回答
	private Date createdtime;//帖子创建时间
	private Date modifiedtime;
	private Integer postClicks;//点击量
	private Integer tagId;//对应分类编号
	private Integer userId;//对应用户id
	private String newDate;
	private List<SysComment> list;
}
