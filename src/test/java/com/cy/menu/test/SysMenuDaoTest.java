package com.cy.menu.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.pj.sys.dao.SysPostDao;
import com.cy.pj.sys.service.SysPostService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysMenuDaoTest {
	@Autowired
	private SysPostDao sysMenuDao;
	@Autowired
	private SysPostService sysMenuService;
	@Test
	public void testSysMenuDao() {
		
	}

}
