package com.lijinhuan.utils;
/**
 * properties工具类
 * @author Administrator
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils{
	
	private static Properties PROPERTIES = new Properties();
	
	//初始化数据
	static{
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("redis.properties");
			PROPERTIES.load(fileInputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Object get(String key){
		return PROPERTIES.get(key);
	}
}

