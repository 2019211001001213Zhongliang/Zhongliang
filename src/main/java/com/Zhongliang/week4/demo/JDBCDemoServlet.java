package com.Zhongliang.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//@WebServlet(
//        urlPatterns = {"/jdbc"},
//        initParams = {
//                @WebInitParam(name="driver", value="com.microsoft.sqlserver.jdbc.SQLServerDiver"),
//                @WebInitParam(name="url", value="jdbc:sqlserver://localhost;databaseName=userdb"),
//                @WebInitParam(name="username", value="sa"),
//                @WebInitParam(name="password", value="admin123456")
//        },loadOnStartup = 1
//)



public class JDBCDemoServlet extends HttpServlet {
    Connection c=null;//class variable

    @Override
    public  void init() throws ServletException {
        //only one connection
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDiver";
        //String url="jdbc:sqlserver://localhost:databaseName=userdb";
        //String username="sa";
        //String password="admin123456";
        //code like this is bad way --- because chnage in not east
        //for example change password of db- change in java code
        ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");
        //get servlet --> getIniParameters


        try {
            Class.forName(driver);
            c = DriverManager.getConnection(url,username,password);
            System.out.println("init-->" + c);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //connection within do get--many times - bad way
        System.out.println("i am doGet");
        //we need to use con within doget
        String sql ="select * from usertable";
        try {
            ResultSet resultSet= c.createStatement().executeQuery(sql);
            PrintWriter writer = response.getWriter();
            writer.println("<html>");
            writer.println("   <head>");
            writer.println("       <meta charset='UTF-8'>");
            writer.println("       <title>查询所有人员</title>");
            writer.println("   </head>");
            writer.println("   <body>");
            writer.println("       <table border='1'>");
            writer.println("           <tr>");
            writer.println("               <td>ID</td>");
            writer.println("               <td>UserName</td>");
            writer.println("               <td>Password</td>");
            writer.println("               <td>Email</td>");
            writer.println("               <td>Gender</td>");
            writer.println("               <td>Birthdate</td>");
            writer.println("           </tr>");
            while(resultSet.next()){
                writer.println("           <tr>");
                writer.println("               <td>"+resultSet.getInt("ID")+"</td>");
                writer.println("               <td>"+resultSet.getString("UserName")+"</td>");
                writer.println("               <td>"+resultSet.getInt("Password")+"</td>");
                writer.println("               <td>"+resultSet.getString("Email")+"</td>");
                writer.println("               <td>"+resultSet.getString("Gender")+"</td>");
                writer.println("               <td>"+resultSet.getDate("Birthdate")+"</td>");
                writer.println("           </tr>");
            }
            writer.println("       </table>");
            writer.println("   </body>");
            writer.println("</html>");
            c.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    public void destroy(){
        super.destroy();
        try{
            c.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
