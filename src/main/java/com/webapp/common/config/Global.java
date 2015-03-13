package com.webapp.common.config;

import java.util.HashMap;
import java.util.Properties;

import com.webapp.common.util.PropertiesLoader;



public class Global {
	
	/**
	 * Save Global Settings
	 */
	private static HashMap<String,String> map = new HashMap<String, String>();
	
	/**
	 * Load from properties
	 */
	private static PropertiesLoader propertiesLoader = new PropertiesLoader("housing.properties");
	
	/**
	 * Get Config
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = propertiesLoader.getProperty(key);
			map.put(key, value);
		}
		return value;
	}
	
	/////////////////////////////////////////////////////////
	
	/**
	 *  Get Administration Path
	 */
	public static String getAdminPath() {
		return getConfig("adminPath");
	}
	
	/**
	 * Get Front Path
	 */
	public static String getFrontPath() {
		return getConfig("frontPath");
	}
	
	/**
	 * Get URL suffix
	 */
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}
}
