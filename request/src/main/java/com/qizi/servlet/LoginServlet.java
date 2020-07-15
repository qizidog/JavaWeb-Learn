package com.qizi.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author : qizidog
 * @date : 2020-07-15 20:51
 * @description :
 **/

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String[] hobbys = req.getParameterValues("hobbys");
        System.out.println(uname+":"+pwd+"————"+ Arrays.toString(hobbys));

        req.getRequestDispatcher("/success").forward(req, resp);  // 转发
//        resp.sendRedirect(req.getContextPath()+"/success");  // 重定向
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
