package com.qizi.servlet2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : qizidog
 * @date : 2020-07-11 23:44
 * @description :
 **/

public class TestDispatcher01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = "<h1><font color='red'>abcdefghjkl</font></h1>";
        resp.getOutputStream().write(data.getBytes());
        ServletContext context = this.getServletConfig().getServletContext();
        // 获取请求转发对象("/"代表当前webapp应用的根目录)
        RequestDispatcher rd = context.getRequestDispatcher("/sd2");
        rd.forward(req, resp);  // 实现请求转发
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
