package com.hww.learnShiro_chapter04.test;

import org.junit.Assert;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class ConfigurationCreateTest {
	
	@Test
	public void test() {
		//IniSecurityManagerFactory 是创建 SecurityManager的工厂
		//支持classpath:（类路径） , file:（文件系统） , url: （网络） 3种路径格式。默认是文件系统
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-config.ini");
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		subject.login(token);
		
		Assert.assertEquals(true, subject.isAuthenticated());
	}

}
