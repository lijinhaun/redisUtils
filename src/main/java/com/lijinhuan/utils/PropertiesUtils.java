package com.lijinhuan.utils;
/**
 * properties工具类
 * @author Administrator
 *
 */

import java.awt.event.MouseWheelEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertiesUtils{
	
	private static Properties PROPERTIES = new Properties();
	
	//初始化数据
	static{
		FileInputStream fileInputStream = null;
		try {
			String path = PropertiesUtils.class.getClassLoader().getResource("").getPath();
			path = path + File.separator +"redis.properties";
			fileInputStream = new FileInputStream(path);
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
	
	public static String get(String key){
		return (String) PROPERTIES.get(key);
	}

//	public static void main(String[] args) throws IOException {
//		System.out.println(PROPERTIES.get("REDIS_ADDR"));
//	}
}

