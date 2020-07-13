package com.qizi.servlet2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : qizidog
 * @date : 2020-07-12 11:36
 * @description :
 **/

public class TestGetResources extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("content-type","text/html;charset=UTF-8");
        getAA(resp);
        getBB(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void getAA(HttpServletResponse resp) throws IOException {
        ServletContext context = this.getServletContext();
        InputStream is = context.getResourceAsStream("/WEB-INF/classes/aa.properties");
        Properties prop = new Properties();
        prop.load(is);
        String uname = prop.getProperty("username");
        String pwd = prop.getProperty("password");
        resp.getWriter().println("the info of aa.properties is as follow: ");
        resp.getWriter().println(uname);
        resp.getWriter().println(pwd);
        resp.getWriter().println("<hr/>");
    }

    private void getBB(HttpServletResponse resp) throws IOException {
        ServletContext context = this.getServletContext();
        InputStream is = context.getResourceAsStream("/WEB-INF/classes/com/qizi/servlet2/bb.properties");
        Properties prop = new Properties();
        prop.load(is);
        String uname = prop.getProperty("username");
        String pwd = prop.getProperty("password");
        resp.getWriter().println("the info of bb.properties is as follow: ");
        resp.getWriter().println(uname);
        resp.getWriter().println(pwd);
        resp.getWriter().println("<hr/>");
    }
}
