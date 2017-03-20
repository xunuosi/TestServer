package cn.xunuosi.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	/**
	 * 通过Key取出对应值的方法
	 * @return
	 */
	public static String getValue(String key,String fileName) {
		String value = null;
		String path = PropertiesUtil.class.getResource("/").getPath();
		Properties p = new Properties();
		System.out.println("PropertiesUtil path:" + path);
		try {
			p.load(new FileInputStream(new File(path+"/"+fileName)));
			value = p.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
