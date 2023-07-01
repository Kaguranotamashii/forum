package cn.bistu.bbs.servlet;

import cn.bistu.bbs.service.UserServiceInf;
import cn.bistu.bbs.service.impl.UserServiceImpl;
import com.xh.bbs.entity.UserEntity;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/account")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("ID");
        String pwd = req.getParameter("PWD");

        UserServiceInf service = new UserServiceImpl();
        UserEntity user1 = service.login(user, pwd);

        System.out.println(user);
        System.out.println(pwd);
        PrintWriter out = resp.getWriter();
        out.println("<link rel='stylesheet' type='text/css' href='css/easyui.css' />");
        out.println("<link rel='stylesheet' type='text/css' href='css/icon.css' />");
        out.println("<script type='text/javascript' src='js/jquery-1.11.2.js'></script>");
        out.println("<script type='text/javascript' src='js/jquery.easyui.min.js'></script>");

        String html = "<div id='confirmdialog' class='easyui-dialog' title='消息确认' style='width:300px;height:160px;padding:10px'";
        html = html + "data-options=\"iconCls: 'icon-no',buttons: [{text:'确定',iconCls:'icon-ok',handler:function(){$('#confirmdialog').dialog('close');window.location.href='login.jsp';}}]\"";
        html = html + ">用户名或密码有错!</div>";
        out.print(html);
        out.flush();
        out.close();


    }
}
