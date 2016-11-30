package com.freemark.autocode.utils;

/**
 * 获得反射对象的所有方法和属性值
 * @Title ReflectBean
 * @Description 
 * @author ch
 * @Date 2016年8月12日 下午4:34:48
 */
public class ReflectBean {

	String beanName;// 属性名
	String beanGetMethod;// 属性方法
	String beanSetMethod;// 属性方法
	String beanType;

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getBeanGetMethod() {
		return beanGetMethod;
	}

	public void setBeanGetMethod(String beanGetMethod) {
		this.beanGetMethod = beanGetMethod;
	}

	public String getBeanSetMethod() {
		return beanSetMethod;
	}

	public void setBeanSetMethod(String beanSetMethod) {
		this.beanSetMethod = beanSetMethod;
	}

	public String getBeanType() {
		return beanType;
	}

	public void setBeanType(String beanType) {
		this.beanType = beanType;
	}

}
