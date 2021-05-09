package com.Zhongliang.week3.demo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    public Connection dbConn;
    public void init() {


        try { Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
            dbConn = DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"), getServletConfig().getServletContext().getInitParameter("Username"), getServletConfig().getServletContext().getInitParameter("Password"));
        } catch (Exception e) {
            System.out.println(e); } }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name, password, email, gender, date;
        name = request.getParameter("name");
        password = request.getParameter("password");
        email = request.getParameter("email");
        gender = request.getParameter("gender");
        date = request.getParameter("date");
        PrintWriter writer = response.getWriter();
        String[][] r = new String[1000][6];
        int a = 0;
        try {
            Statement createDbStatement = dbConn.createStatement();
            String ADDdbRequire = "insert into usertable values('" + name + "','" + password + "','" + email + "','" + gender + "','" + date + "')";
            createDbStatement.executeUpdate(ADDdbRequire);

        } catch (Exception e) {
            System.out.println(e);
        }

        response.sendRedirect("WEB-INF/views/login.jsp");
    }}