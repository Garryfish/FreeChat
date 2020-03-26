package com.cy.pj.common.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringShiroConfig {
	@Bean
	public SecurityManager newSecurityManager() {
		DefaultWebSecurityManager sManager=
				new DefaultWebSecurityManager();
		return sManager;
	}

	@Bean("shiroFilterFactory")
	public ShiroFilterFactoryBean newShiroFilterFactoryBean(
			@Autowired SecurityManager securityManager
			/*@Autowired CacheManager cacheManager*/) {
		ShiroFilterFactoryBean sfBean=
				new ShiroFilterFactoryBean();
		sfBean.setSecurityManager(securityManager);
		//假如没有认证请求先访问此认证的url
		sfBean.setLoginUrl("/login");
		//定义map指定请求过滤规则(哪些资源允许匿名访问,哪些必须认证访问)
		LinkedHashMap<String,String> map=
				new LinkedHashMap<>();
		//静态资源允许匿名访问:"anon"
		map.put("/css/**","anon");
		map.put("/fonts/**","anon");
		map.put("/img/**","anon");
		map.put("/js/**","anon");
		map.put("/index","anon");
		map.put("/single-blog","anon");
		map.put("/tag","anon");
		map.put("/contact","anon");
		map.put("/cateogry","anon");
		map.put("/login","anon");
		map.put("/regist","anon");
		map.put("/user/doLogin","anon");
		map.put("/doSignOut","logout");
		//除了匿名访问的资源,其它都要认证("authc")后访问
//		map.put("/insertComments","user");
//		map.put("/doSaveObject","user");
		sfBean.setFilterChainDefinitionMap(map);
		return sfBean;
	}

	@Bean
	public SecurityManager newSecurityManager(@Autowired Realm realm
			/*@Autowired CacheManager cacheManager*/) {
		DefaultWebSecurityManager sManager=
				new DefaultWebSecurityManager();
		sManager.setRealm(realm);
		//		sManager.setCacheManager(cacheManager);
		sManager.setRememberMeManager(newRememberMeManager());
		sManager.setSessionManager(newSessionManager());
		return sManager;
	}

	//	@Bean
	//	public CacheManager newCacheManager() {
	//		return new MemoryConstrainedCacheManager();
	//	}

	public SimpleCookie newCookie() {
		SimpleCookie c=new SimpleCookie("rememberMe");
		c.setMaxAge(10*60);
		return c;
	}

	public CookieRememberMeManager newRememberMeManager() {
		CookieRememberMeManager cManager=
				new CookieRememberMeManager();
		cManager.setCookie(newCookie());
		return cManager;
	}

	public DefaultWebSessionManager newSessionManager() {
		DefaultWebSessionManager sManager=
				new DefaultWebSessionManager();
		sManager.setGlobalSessionTimeout(60*60*1000);
		return sManager;
	}
}
