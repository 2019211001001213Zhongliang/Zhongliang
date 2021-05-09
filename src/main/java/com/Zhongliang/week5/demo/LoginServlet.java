package com.Zhongliang.week5.demo;
import com.Zhongliang.dao.UserDao;
import com.Zhongliang.model.User;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        con =(Connection)getServletContext().getAttribute("dbConn");

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password= request.getParameter("password");
        UserDao userDao=new UserDao();
        try {
            User user= userDao.findByUsernamePassword(con ,name,password);
            if(user!=null){
                String rememberMe=request.getParameter("remember");
                if (rememberMe!=null &&rememberMe.equals("1"))
                {
                    Cookie usernameCookie = new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie= new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie = new Cookie("cRememberMe",request.getParameter("remember"));
                    usernameCookie.setMaxAge(10);
                    passwordCookie.setMaxAge(10);
                    rememberMeCookie.setMaxAge(10);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);

                }


                HttpSession session=   request.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);


                session.setAttribute("user",user);
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