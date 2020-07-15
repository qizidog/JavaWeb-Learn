package com.qizi.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : qizidog
 * @date : 2020-07-15 20:58
 * @description :
 **/

public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        resp.setCharacterEncoding("UTF-8");  // 不知道为什么不起作用(好像跟转发有关系)
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        resp.getWriter().println("<h1>登录成功</h1>");
        System.out.println("登录成功");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
