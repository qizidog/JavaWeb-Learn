package com.qizi.servlet2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : qizidog
 * @date : 2020-07-11 18:02
 * @description :
 **/

public class PutContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = "douglas qi";
        /*
         * ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写servlet时，
         * 可以通过ServletConfig.getServletContext方法获得ServletContext对象。
         */
        ServletContext context = this.getServletConfig().getServletContext();  //获得ServletContext对象
        context.setAttribute("data", data);  //将data存储到ServletContext对象中
        resp.getWriter().println((String)context.getAttribute("data"));
        resp.getWriter().println("successfully set attribute: "+data);

        // 获取指定web站点的初始化上下文参数
        String contextInitParam = context.getInitParameter("url");
        resp.getWriter().println(contextInitParam);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
