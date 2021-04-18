package com.Zhongliang.week5.demo;
import com.Zhongliang.dao.UserDao;
import com.Zhongliang.model.User;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {

        con =(Connection)getServletContext().getAttribute("dbConn");

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password= request.getParameter("password");
        UserDao userDao=new UserDao();
        try {
            User user= userDao.findByUsernamePassword(con,name,password);
            if(user!=null){
                request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
            }else{
                request.setAttribute("msg" ,"username or password Error");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response); }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(name + password);
        System.out.println(con);
        try {
            if( con != null){
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}