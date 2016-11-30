package com.freemark.autocode.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.junit.Test;

import com.waterfox.demo.User;

import common.util.file.FileUtils;
import common.util.http.HttpClientEntry;

/**
 * java通过反射机制获得 类名 类bean getter和setter方法
 * @Title ReflectUtil
 * @Description 
 * @author ch
 * @Date 2016年7月5日 上午10:09:56
 */
public class ReflectUtil {
	/**
	 * 反射bean对象的所有属性。必须要有getter和setter
	 * 通过  包全称
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static Field[] getBeanAndType(String className)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Field[] fields = null;
		Object o = Class.forName(className).newInstance();
		fields = o.getClass().getDeclaredFields();
		return fields;
	}

	/**
	 * 反射bean对象的所有属性。必须要有getter和setter
	 * 通过  类字节
	 * @param objClass
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static Field[] getBeanAndType(Class objClass)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Field[] fields = null;
		Object o = Class.forName(objClass.getName()).newInstance();
		fields = o.getClass().getDeclaredFields();
		return fields;
	}

	public static Field[] getMethod(Class objClass)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Field[] fields = null;
		Object o = Class.forName(objClass.getName()).newInstance();
		fields = o.getClass().getDeclaredFields();
		return fields;
	}

	public ArrayList<ReflectBean> getBean()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Field[] field = new ReflectUtil().getBeanAndType(User.class);
		ArrayList<ReflectBean> arrayList = new ArrayList<ReflectBean>();
		for (Field field2 : field) {
			ReflectBean reflectBean = new ReflectBean();
			String name = field2.getName();
			Type type = field2.getGenericType();// 数据类型
			// System.out.println(name);
			String beanType = type.toString().replace("class", "").trim();
			name = name.toUpperCase().substring(0, 1) + name.substring(1, name.length());
			reflectBean.setBeanName(name);
			reflectBean.setBeanType(beanType);
			reflectBean.setBeanSetMethod("set" + name);
			reflectBean.setBeanGetMethod("get" + name);
			arrayList.add(reflectBean);
		}
		return arrayList;
	}

}
