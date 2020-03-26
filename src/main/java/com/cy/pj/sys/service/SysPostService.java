package com.cy.pj.sys.service;

import java.util.List;

import com.cy.pj.sys.entity.SysPost;
import com.cy.pj.sys.vo.SysPostUserCommentVo;

public interface SysPostService {
	//根据id查询对应帖子
	SysPost findObjectById(Integer id);

	//查询所有帖子信息(热门)
	List<SysPost> selectName();

	//查询帖子信息(首页)
	List<SysPostUserCommentVo> findIndexPostObjects(Integer id);

	//新增帖子
	int saveObject(SysPost entity);

	//查询点击量
	int selectOne(Integer id);

	//修改点击量
	int updateClick(Integer click,Integer id);


	//根据param模糊查询帖子
	List<SysPost> selectObjectsByParam(String param);

	//根据tagId模糊查询帖子
	List<SysPost> selectObjectsById(Integer id);
}
