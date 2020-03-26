package com.cy.pj.common.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
    private static JedisPool jedisPool;
    static{
        InputStream in = JedisPoolUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties p = new Properties();
        try {
            p.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据，设置JedisPoolConfig
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(p.getProperty("MAX_TOTAL")));
        config.setMaxIdle(Integer.parseInt(p.getProperty("MAX_IDLE")));
        config.setTestOnBorrow(Boolean.parseBoolean(p.getProperty("TEST_ON_BORROW")));
        //初始化JedisPool
        jedisPool = new JedisPool(config,p.getProperty("ADDR"),Integer.parseInt(p.getProperty("PORT")));
    }
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
