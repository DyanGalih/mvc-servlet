package com.dyangalih.controllers;

import com.dyangalih.models.LoginBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        LoginBean loginBean = new LoginBean();
        loginBean.setName(name);
        loginBean.setPassword(password);
        request.setAttribute("bean", loginBean);

        boolean status = loginBean.validate();

        RequestDispatcher requestDispatcher;

        if(status){
            requestDispatcher = request.getRequestDispatcher("login-success.jsp");
            requestDispatcher.forward(request, response);
        }else{
            requestDispatcher = request.getRequestDispatcher("login-error.jsp");
            requestDispatcher.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request, response);
    }
}
