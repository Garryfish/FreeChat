package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.sys.dao.SysTagsDao;
import com.cy.pj.sys.entity.SysTags;
import com.cy.pj.sys.service.SysTagsService;

@Service
public class SysTagsServiceImpl implements SysTagsService{

	@Autowired
	private SysTagsDao sysTagsDao;
	
	@Override
	public List<SysTags> findObjects() {
		// TODO Auto-generated method stub
		List<SysTags> tags = sysTagsDao.findObjects();
		if (tags==null) {
			throw new ServiceException("没有查询到分类信息");
		}
		return tags;
	}

}
