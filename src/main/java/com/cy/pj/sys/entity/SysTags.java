package com.cy.pj.sys.entity;

import java.io.Serializable;

public class SysTags implements	Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9016180740619602637L;
	private Integer id;
	private String tagname;
	private Integer tagClicks;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTagname() {
		return tagname;
	}
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	public Integer getTagClicks() {
		return tagClicks;
	}
	public void setTagClicks(Integer tagClicks) {
		this.tagClicks = tagClicks;
	}
	@Override
	public String toString() {
		return "SysTags [id=" + id + ", tagname=" + tagname + ", tagClicks=" + tagClicks + "]";
	}
	
	
	
	
}
