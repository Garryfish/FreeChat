package com.cy.pj.sys.service;

import com.cy.pj.sys.entity.SysUser;

public interface RegisterService {
    void doRegister(SysUser user);
    Boolean doInsertUser(SysUser user);
    Boolean findUserName(String username);
}
