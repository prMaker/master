package com.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("���ٳɹ�");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		
		System.out.println("�����ɹ�");
		
	}

}
