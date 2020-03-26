package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.sys.entity.SysTags;

@Mapper
public interface SysTagsDao {
	public List<SysTags> findObjects();
}
