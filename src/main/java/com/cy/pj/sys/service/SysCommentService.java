package com.cy.pj.sys.service;

import java.util.List;


import com.cy.pj.sys.entity.SysComment;


public interface SysCommentService {
	
	List<SysComment> findPostComments(Integer id);
	
	int insertComment(SysComment entity);
}
