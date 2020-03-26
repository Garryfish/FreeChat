package com.cy.pj.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.utils.newDateUtils;
import com.cy.pj.sys.dao.SysPostCommentDao;
import com.cy.pj.sys.entity.SysComment;
import com.cy.pj.sys.service.SysCommentService;
@Service
public class SysPostCommentServiceImpl implements SysCommentService{
	@Autowired
	private SysPostCommentDao sysPostCommentDao;
	//查询回复信息
	@Override
	public List<SysComment> findPostComments(Integer id) {
		List<SysComment> postComments = 
				sysPostCommentDao.findPostComments(id);
		for(SysComment i:postComments) {
			String newDate = newDateUtils.newDate(i.getCreatedtime());
			i.setNewDate(newDate);
		}
		return postComments;
	}
	
	
	//新增回复
	@Override
	public int insertComment(SysComment entity) {
		entity.setCreatedtime(new Date());
		int rows = sysPostCommentDao.insertComment(entity);
		return rows;
	}

}
