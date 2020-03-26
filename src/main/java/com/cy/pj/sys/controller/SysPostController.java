package com.cy.pj.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysComment;
import com.cy.pj.sys.entity.SysPost;
import com.cy.pj.sys.service.SysCommentService;
import com.cy.pj.sys.service.SysPostService;
import com.cy.pj.sys.vo.SysPostUserCommentVo;

@Controller
@RequestMapping("/")
@ResponseBody
public class SysPostController {
	@Autowired
	private SysPostService sysPostService;
	@Autowired
	private SysCommentService sysCommentService;
//查询帖子信息
	@RequestMapping("doFindObjects")
	public JsonResult doFindObjects(Integer id) {
		SysPost object = sysPostService.findObjectById(id);
		return new JsonResult(object);
	}

	//查询帖子对应回复
	@RequestMapping("doFindPostComments")
	public JsonResult doFindPostComments(Integer id) {
		System.out.println(id);
		List<SysComment> postComments = sysCommentService.findPostComments(id);
		return new JsonResult(postComments);
	}

//新增回复内容
	@RequestMapping("insertComments") 
	public JsonResult insertComment(SysComment entity) {
		sysCommentService.insertComment(entity); 
		return new JsonResult("insert ok"); }

	//查询所有帖子信息
	@RequestMapping("findByName")
	public JsonResult findother() {
		 List<SysPost> selectOne = sysPostService.selectName();
		return new  JsonResult(selectOne);
	}
	
	
	//查询帖子信息（首页）
	@RequestMapping("doFindIndexPostObjects")
	public JsonResult doFindIndexPostObjects(Integer id){
		List<SysPostUserCommentVo> pageObjects = sysPostService.findIndexPostObjects(id);
		return new JsonResult(pageObjects);
	}
	
	//新增帖子信息
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysPost entity){
		System.out.println(entity);
		sysPostService.saveObject(entity);
		return new JsonResult("发表成功");    
	}
	
	//增加帖子点击量
	@RequestMapping("SelectOne")
	public void SelectOne(Integer id) {
		int selectOne = sysPostService.selectOne(id);
		System.out.println(selectOne);

		 int updates=selectOne+1;
		 sysPostService.updateClick(updates, id);

	}
	
	
	@RequestMapping("searchPost")
	public JsonResult searchPost(String postname) {
		System.out.println(postname);
		List<SysPost> selectObjectsByParam = sysPostService.selectObjectsByParam(postname);
		return new JsonResult(selectObjectsByParam);  
	}
	
	@RequestMapping("searchPostById")
	public JsonResult searchPostById(Integer tagId) {
		List<SysPost> selectObjectsById = sysPostService.selectObjectsById(tagId);
		return new JsonResult(selectObjectsById);  
	}


}
