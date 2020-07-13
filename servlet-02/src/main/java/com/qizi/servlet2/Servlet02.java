package com.qizi.servlet2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author : qizidog
 * @date : 2020-07-10 11:49
 * @description :
 **/

public class Servlet02 extends HttpServlet {
    /**
     * 定义ServletConfig对象来接收配置的初始化参数
     */
    private ServletConfig config;

    /**
     * 当servlet配置了初始化参数后，web容器在创建servlet实例对象时，
     * 会自动将这些初始化参数封装到ServletConfig对象中，并在调用servlet的init方法时，
     * 将ServletConfig对象传递给servlet。进而，程序员通过ServletConfig对象就可以
     * 得到当前servlet的初始化参数信息。
     */
    // 测试初始化参数时必须要重写init方法
    // 测试上下文环境参数时不能重写此方法
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("这里是servlet02");

//        this.getInitParameter();  // 初始化参数
//        this.getServletConfig();  // servlet配置
//        this.getServletContext();  // servlet上下文

        testInitParameter(resp);  // 测试初始化参数

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void testInitParameter(HttpServletResponse resp) throws IOException {
        //获取在web.xml中配置的初始化参数
        String paramVal = this.config.getInitParameter("name");//获取指定的初始化参数
        resp.getWriter().print(paramVal);
        resp.getWriter().println("<hr/>");

        //获取所有的初始化参数
        Enumeration<String> e = config.getInitParameterNames();
        while(e.hasMoreElements()){
            String name = e.nextElement();
            String value = config.getInitParameter(name);
            resp.getWriter().println(name + "=" + value + "<br/>");
        }
    }

}
