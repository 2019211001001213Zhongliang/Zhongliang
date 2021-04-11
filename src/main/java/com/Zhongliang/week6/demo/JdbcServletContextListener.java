package com.Zhongliang.week6.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcServletContextListener implements ServletContextListener {

    public JdbcServletContextListener() {
        System.out.println("-----");
    }


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Connection dbConn;
        ServletContext c = sce.getServletContext();
        try {
            Class.forName(c.getInitParameter("driver"));
            dbConn = DriverManager.getConnection(c.getInitParameter("url"),
                    c.getInitParameter("Username"),
                    c.getInitParameter("Password"));
            c.setAttribute("dbConn",dbConn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}