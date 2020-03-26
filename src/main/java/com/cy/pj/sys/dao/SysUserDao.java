package com.cy.pj.sys.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.sys.entity.SysUser;

@Mapper
public interface SysUserDao {
	
	//根据用户id查询用户信息
	@Select("select username from sys_users where id = #{userId}")
	SysUser findUserObject(Integer id);
	
	//新增用户
	int insertObject(SysUser user);
	
	//根据用户名查询用户名字
    String findUserName(String username);
    
    //根据用户名查询用户信息
    SysUser FindUserByName(@Param("username")String username);
}
