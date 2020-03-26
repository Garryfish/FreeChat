package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.sys.entity.SysComment;


/*
 * 此Dao对象负责操作sys——role——menus中间表数据
 */
@Mapper
public interface SysPostCommentDao {
	@Select("select * from sys_comments where post_id=#{id} order by createdtime desc")
	List<SysComment> findPostComments(Integer id);
	
	//新增评论信息
	@Insert("insert into sys_comments (content,createdtime,post_id) "
			+ "values (#{content},#{createdtime},#{postId})")
	int insertComment(SysComment entity);
}
