package com.cy.pj.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.utils.newDateUtils;
import com.cy.pj.sys.common.annotation.RequiredLog;
import com.cy.pj.sys.dao.SysPostDao;
import com.cy.pj.sys.entity.SysPost;
import com.cy.pj.sys.service.SysPostService;
import com.cy.pj.sys.vo.SysPostUserCommentVo;

import io.micrometer.core.instrument.util.StringUtils;


@Service
public class SysPostServiceImpl implements SysPostService{
	@Autowired
	private SysPostDao sysPostDao;


	@Override
	@RequiredLog("菜单查询")
	//通过帖子id查询对应帖子信息
	public SysPost findObjectById(Integer id) {
		SysPost object = sysPostDao.findObjectById(id);
		String newDate = newDateUtils.newDate(object.getCreatedtime());
		object.setNewDate(newDate);
		return object;
	}

	//查询所有帖子信息（热门）
	@Override
	public List<SysPost> selectName() {
		List<SysPost> findAllObjects = sysPostDao.selectName();
		for (SysPost sysPost : findAllObjects) {
			String newDate=newDateUtils.newDate(sysPost.getCreatedtime());
			sysPost.setNewDate(newDate);
		}
		return findAllObjects;
	}

	//查询帖子信息（首页）
	@Override
	public List<SysPostUserCommentVo> findIndexPostObjects(Integer id) {
		id=(id-1)*4;
		List<SysPostUserCommentVo> indexPageObjects = sysPostDao.findObjects(id);
		for (SysPostUserCommentVo sysIndexPost : indexPageObjects) {
			
			String newDate=newDateUtils.newDate(sysIndexPost.getSysPost().getCreatedtime());
			sysIndexPost.getSysPost().setNewDate(newDate);
			/*
			 * String newDate=newDateUtils.newDate(sysPost.getCreatedtime());
			 * sysPost.setNewDate(newDate);
			 */
		}
		return indexPageObjects;
	}

	//新增帖子信息
	public int saveObject(SysPost entity) {
		//1.合法性验证
		if(entity==null)
			throw new ServiceException("保存数据不能为空");
		if(StringUtils.isEmpty(entity.getPostname()))
			throw new ServiceException("角色名不能为空");
		//2.保存数据
		entity.setCreatedtime(new Date());
		int rows=sysPostDao.insertObject(entity);
		//3.返回结果
		return rows;
	}

	//根据id查询帖子对应点击量
	@Override
	public int selectOne(Integer id) {
		
		return sysPostDao.selectOne(id);
	}

	//根据id修改帖子对应点击量
	@Override
	public int updateClick(Integer click, Integer id) {
		
		return sysPostDao.updateClick(click, id);
	}


	@Override
	public List<SysPost> selectObjectsByParam(String param) {
		List<SysPost> searchObjects = sysPostDao.searchObjects(param);
		for (SysPost sysPost : searchObjects) {
			String newDate = newDateUtils.newDate(sysPost.getCreatedtime());
			sysPost.setNewDate(newDate);
		}
		return searchObjects;
	}

	@Override
	public List<SysPost> selectObjectsById(Integer id) {
		List<SysPost> searchObjectsById = sysPostDao.searchObjectsById(id);
		
		return searchObjectsById;
	}




}
