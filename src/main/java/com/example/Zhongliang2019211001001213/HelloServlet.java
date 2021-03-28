package com.example.Zhongliang2019211001001213;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(name = "helloServlet",value = "/hello-servlet",
initParams = {
        @WebInitParam(name="driver", value="com.microsoft.sqlserver.jdbc.SQLServerDiver"),
        @WebInitParam(name="url", value="jdbc:sqlserver://localhost;databaseName=userdb"),
        @WebInitParam(name="username", value="sa"),
        @WebInitParam(name="password", value="admin123456")
}
)




public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDiver";
        String url = "jdbc:sqlserver://localhost;databaseName=userdb";
        String username = "sa";
        String password = "admin123456";

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println(con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public void destroy() {
    }
}