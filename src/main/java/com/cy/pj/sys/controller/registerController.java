package com.cy.pj.sys.controller;

import com.cy.pj.common.utils.JedisPoolUtil;
import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.RegisterService;
import com.cy.pj.sys.vo.RegisterWarn;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.io.IOException;

@Controller
@RequestMapping("/register/")
public class registerController {
    @Autowired
    private RegisterService registerService;
    @RequestMapping("doRegister")
    @ResponseBody
    public JsonResult doRegister(SysUser user){
        registerService.doRegister(user);
        return new JsonResult(new RegisterWarn("注册成功，请登录邮箱进行激活"));
    }
    @RequestMapping("{activecode}")
    public String doCheckEmail(@PathVariable String activecode){
        Jedis jedis = JedisPoolUtil.getJedis();
        String sUser = jedis.get(activecode);
        //将json格式的数据转换为user对象
        ObjectMapper objectMapper = new ObjectMapper();
        SysUser user = null;
        try {
            user = objectMapper.readValue(sUser, SysUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Boolean flag = registerService.doInsertUser(user);
        if(!flag){//如果注册失败，跳回注册页面
            return "register";
        }
        return "register_ok";
    }
    @RequestMapping("doFindUserName")
    @ResponseBody
    public JsonResult doFindUserName(String username) {
        Boolean flag = registerService.findUserName(username);
        return new JsonResult(flag);
    }

}
