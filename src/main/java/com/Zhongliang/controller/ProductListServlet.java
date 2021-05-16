package com.Zhongliang.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name="ProductListServlet",value="/admin/productList")
public class ProductListServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/WEB-INF/views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}