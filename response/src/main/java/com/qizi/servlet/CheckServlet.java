package com.qizi.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : qizidog
 * @date : 2020-07-15 16:46
 * @description :
 * 将index.jsp提交的验证码和在DrawImage中保存至session的值比较
 * 判断验证码是否输入正确
 **/

public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 全部转化为小写字母，验证码不区分大小写
        String clientCheckcode = req.getParameter("validateCode").toLowerCase();//接收客户端浏览器提交上来的验证码
        String serverCheckcode = ((String) req.getSession().getAttribute("checkcode")).toLowerCase();//从服务器端的session中取出验证码
        System.out.println("client: "+clientCheckcode);
        System.out.println("server: "+serverCheckcode);
        if (clientCheckcode.equals(serverCheckcode)) {//将客户端验证码和服务器端验证比较，如果相等，则表示验证通过
            System.out.println("验证码验证通过！");
        }else {
            System.out.println("验证码验证失败！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
