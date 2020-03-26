package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cy.pj.sys.entity.SysPost;
import com.cy.pj.sys.vo.SysPostUserCommentVo;
@Mapper
public interface SysPostDao {
	//基于id查询对应帖子信息
	@Select("select * from sys_posts where id=#{id}")
	SysPost findObjectById(Integer id);
	
	//查询全部帖子(热门)
	@Select("select * from sys_posts order by post_clicks desc limit 0,20")
	List<SysPost> selectName();
	
	//查询帖子(首页)
	@Select("select * from sys_posts order by createdtime desc limit #{pageCurret},4")
	List<SysPost> findIndexPostObjects(Integer id);
	
	//新增帖子
	@Insert("insert into sys_posts (id,postname,content,createdtime,modifiedtime, post_clicks,user_id,tag_id) values"
			+ " (null,#{postname},#{content},now(),null, 0,#{userId},#{tagId})")
	int insertObject(SysPost entity);
	
	//根据帖子id查询对应点击量
	@Select("select post_clicks from sys_posts where id = #{id}")
	int selectOne(Integer id);
	
	//根据id修改对应帖子点击量
	@Update("update sys_posts set post_clicks=#{click} where id=#{id}")
	int updateClick(@Param("click")Integer click,@Param("id")Integer id);
	
	//查询对象（帖子内容+作者+评论数）
	List<SysPostUserCommentVo> findObjects(Integer currentPage);
	
	

	//查询所有对象(模糊查询)
	@Select("select * from sys_posts where postname like concat('%',#{param},'%')")
	List<SysPost> searchObjects(String param);
	
	@Select("select * from sys_posts where tag_id=#{tagId} ")
	List<SysPost> searchObjectsById(Integer tagId);
	

	
}
