package com.cy.pj.sys.vo;
/**
* @author 作者：ling
* @version 创建时间：2019年10月22日 下午11:18:42
* @description 描述：
*/

import java.io.Serializable;

import com.cy.pj.sys.entity.SysPost;

public class SysPostUserCommentVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7254510989252486870L;
	private SysPost sysPost;
	private String username;
	private Integer commentCount;
	public SysPost getSysPost() {
		return sysPost;
	}
	public void setSysPost(SysPost sysPost) {
		this.sysPost = sysPost;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	@Override
	public String toString() {
		return "SysPostUserCommentVo [sysPost=" + sysPost + ", username=" + username + ", commentCount=" + commentCount
				+ "]";
	}
	public SysPostUserCommentVo(SysPost sysPost, String username, Integer commentCount) {
		super();
		this.sysPost = sysPost;
		this.username = username;
		this.commentCount = commentCount;
	}
	
	public SysPostUserCommentVo() {
		// TODO Auto-generated constructor stub
	}
	
}
