package com.cy.pj.sys.service.impl;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.utils.JedisPoolUtil;
import com.cy.pj.common.utils.MailUtils;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.RegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.Jedis;

import java.util.UUID;


@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private SysUserDao userDao;

    @Override
    public void doRegister(SysUser user) {
        if(user==null){
           throw new ServiceException("保存的对象不能为空");
        }
        if(StringUtils.isEmpty(user.getUsername())){
            throw new ServiceException("用户名不能为空");
        }
        if(StringUtils.isEmpty(user.getPassword())){
            throw new ServiceException("密码不能为空");
        }
        if(StringUtils.isEmpty(user.getMobile())){
            throw new ServiceException("手机号不能为空");
        }
        if(StringUtils.isEmpty(user.getEmail())){
            throw new ServiceException("邮箱不能为空");
        }
        //对密码进行加密
        String password = user.getPassword();
        String salt = UUID.randomUUID().toString();
        SimpleHash md5 = new SimpleHash("MD5", password, salt);
        user.setSalt(salt);
        user.setPassword(md5.toHex());
        String createdUser = user.getUsername();
        String modifiedUser = user.getUsername();
        user.setCreatedUser(createdUser);
        user.setModifiedUser(modifiedUser);
        String activecode = UUID.randomUUID().toString();//生成一个随机数，作为邮箱的激活码
        //将User对象转化成json格式的数据
        ObjectMapper mapper = new ObjectMapper();
        String sUser = null;
        try {
            sUser = mapper.writeValueAsString(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将数据保存进redis缓存中
        Jedis jedis = JedisPoolUtil.getJedis();//使用自定义jedis池
        jedis.setex(activecode,60*60,sUser);//设置过期时间
        System.out.println(activecode);
        jedis.close();
        //发送邮件
        MailUtils.sendMail(user.getEmail(),"这是一封激活邮件，请在1小时内点击下方链接进行账号激活，<br/><a href=http://localhost/register/"+activecode+">请点击进行这里进行用户激活</a>","激活账户");

    }

    @Override
    public Boolean doInsertUser(SysUser user) {
        if(user==null){
            return false;
        }
        //设置状态码为1
        user.setValid(1);
        int rows = userDao.insertObject(user);
        if(rows==0){
            throw new ServiceException("数据写入失败");
        }
        return true;
    }

    @Override
    public Boolean findUserName(String username) {
        String name = userDao.findUserName(username);
        if(name!=null){
            return false;
        }
        return true;
    }


}
