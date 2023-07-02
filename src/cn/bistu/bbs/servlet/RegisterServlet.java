package cn.bistu.bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bistu.bbs.entity.UserEntity;

import cn.bistu.bbs.service.UserServiceInf;
import cn.bistu.bbs.service.impl.UserServiceImpl;


public class RegisterServlet extends HttpServlet{

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
//		 String user_id = request.getParameter("user_id");

        String user_name = request.getParameter("user_name");
        String user_password = request.getParameter("user_password");
        String user_email = request.getParameter("user_email");

        UserEntity user = new UserEntity();


        user.setUsername(user_name);
        user.setPassword(user_password);
        user.setEmail(user_email);

        UserServiceInf service = new UserServiceImpl();
        service.saveUser(user);

        //PrintWriter out=response.getWriter();

        response.sendRedirect("login.jsp");
        //out.print("<a href='login.jsp'>注册成功,请返回登录界面</a>");

    }
}
