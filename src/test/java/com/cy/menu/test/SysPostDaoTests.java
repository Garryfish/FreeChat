package com.cy.menu.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.pj.sys.dao.SysPostDao;
import com.cy.pj.sys.vo.SysPostUserCommentVo;



/**
* @author 作者：ling
* @version 创建时间：2019年10月22日 下午11:40:05
* @description 描述：
*/

@SpringBootTest
@RunWith(SpringRunner.class)
public class SysPostDaoTests {

	@Autowired
	private SysPostDao sysPostDao;
	
	
	@Test
	public void testSysPostDao() {
		List<SysPostUserCommentVo> list = sysPostDao.findObjects(1);
		for (SysPostUserCommentVo sysPostUserCommentVo : list) {
			System.out.println(sysPostUserCommentVo);
		}
	}
	
}
