package com.weavedm.shiro.util;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ServletContextAware;


public class ApplicationContextUtil implements ApplicationContextAware,ServletContextAware {
	private static ApplicationContext context;// 声明一个静态变量保存
	public static ServletContext servletContext = null;

	/**
	 * 设置ServletContext
	 * 
	 * @param sct
	 *            ServletContext实例
	 */
	public void setServletContext(ServletContext sct) {
		servletContext = sct;
	}

	/**
	 * 返回ServletContext实例
	 * 
	 * @return ServletContext实例
	 */
	public static ServletContext getServletContext() {
		return servletContext;
	}

	public void setApplicationContext(ApplicationContext contex) throws BeansException {
		this.context = contex;
	}

	public static ApplicationContext getContext() {
		return context;
	}

	/**
	 * 从spring Bean池中获取实例
	 * 
	 * @param beanId
	 * @return spring Bean池中获取的实例
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanId) {
		return (T) context.getBean(beanId);
	}

}