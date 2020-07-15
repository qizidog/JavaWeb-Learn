package com.qizi.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author : qizidog
 * @date : 2020-07-12 15:10
 * @description :
 * 实现从浏览器中下载图片
 **/

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/集成开发环境.png");
        String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
        System.out.println("realPath: "+realPath);
        System.out.println("fileName: "+fileName);
        System.out.println("contextPath: "+this.getServletContext().getContextPath());

        resp.setHeader("content-disposition", "attachment;filename="+
                URLEncoder.encode(fileName, "UTF-8"));  // 转码，避免中文乱码问题

        FileInputStream fis = new FileInputStream(realPath);
        ServletOutputStream os = resp.getOutputStream();
        int len;
        byte[] flush = new byte[1024];
        while ((len=fis.read(flush))!=-1){
            os.write(flush, 0, len);
        }
        os.close();
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
