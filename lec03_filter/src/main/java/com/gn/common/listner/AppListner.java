package com.gn.common.listner;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppListner
 *
 */
@WebListener
public class AppListner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AppListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("서버 시작 시 호출");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("서버 종료 시 호출");
    }
	
}
