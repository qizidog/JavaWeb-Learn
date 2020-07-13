package com.qizi.servlet2;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author : qizidog
 * @date : 2020-07-11 18:02
 * @description :
 **/

public class GetContextServlet extends HttpServlet {
//    private ServletConfig config;
////
////    @Override
////    public void init(ServletConfig config) throws ServletException {
////        this.config = config;
////    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        testServletContext(resp);  // 测试上下文环境
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void testServletContext(HttpServletResponse resp) throws IOException {
        ServletContext context = this.getServletContext();
        String data = (String)context.getAttribute("data");
        resp.getWriter().println("the context data is: "+data);

        // 看一下全部的初始化参数有些什么
        Enumeration<String> initParameterNames = context.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = context.getInitParameter(name);
            resp.getWriter().println(name + "=" + value);
        }
    }
}
