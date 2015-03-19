/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.webapp.service.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.subject.Subject;

import com.google.common.collect.Maps;
import com.webapp.common.util.SpringContextHolder;
import com.webapp.dao.UserDao;
import com.webapp.model.User;
import com.webapp.security.SystemAuthorizingRealm.Principal;


/**
 * 用户工具类
 * @author ThinkGem
 * @version 2013-5-29
 */
public class UserUtils {

	private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);


	public static final String CACHE_USER = "user";
	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";
	
	public static User getUser(){
		User user = (User)getCache(CACHE_USER);
		if (user == null){
			try{
				Subject subject = SecurityUtils.getSubject();
				Principal principal = (Principal)subject.getPrincipal();
				if (principal!=null){
					user = userDao.get(principal.getId());
//					Hibernate.initialize(user.getRoleList());
					putCache(CACHE_USER, user);
				}
			}catch (UnavailableSecurityManagerException e) {
				
			}catch (InvalidSessionException e){
				
			}
		}
		if (user == null){
			user = new User();
			try{
				SecurityUtils.getSubject().logout();
			}catch (UnavailableSecurityManagerException e) {
				
			}catch (InvalidSessionException e){
				
			}
		}
		return user;
	}
	
	public static User getUserById(Serializable id){
		if(id!=null) {
			return userDao.get(id);
		} else {
			return null;
		}
	}
	
	// ============== User Cache ==============
	
		public static Object getCache(String key) {
			return getCache(key, null);
		}
		
		public static Object getCache(String key, Object defaultValue) {
			Object obj = getCacheMap().get(key);
			return obj==null?defaultValue:obj;
		}

		public static void putCache(String key, Object value) {
			getCacheMap().put(key, value);
		}

		public static void removeCache(String key) {
			getCacheMap().remove(key);
		}
		
		public static Map<String, Object> getCacheMap(){
			Map<String, Object> map = Maps.newHashMap();
			try{
				Subject subject = SecurityUtils.getSubject();
				Principal principal = (Principal)subject.getPrincipal();
				return principal!=null?principal.getCacheMap():map;
			}catch (UnavailableSecurityManagerException e) {
				
			}catch (InvalidSessionException e){
				
			}
			return map;
		}
	
}
