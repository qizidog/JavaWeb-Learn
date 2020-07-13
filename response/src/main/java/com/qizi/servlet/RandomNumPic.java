package com.qizi.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author : qizidog
 * @date : 2020-07-12 21:01
 * @description :
 **/

public class RandomNumPic extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置refresh响应头控制浏览器每隔5秒钟刷新一次
        resp.setHeader("refresh", "3");

        //1.在内存中创建一张图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //2.得到图片
        //Graphics g = image.getGraphics();
        Graphics2D g = (Graphics2D)image.getGraphics();
        g.setColor(Color.WHITE);//设置图片的背景色
        g.fillRect(0, 0, 80, 20);//填充背景色
        //3.向图片上写数据
        g.setColor(Color.BLUE);//设置图片上字体的颜色
        g.setFont(new Font(null, Font.BOLD, 20));
        g.drawString(makeNum(), 0, 20);

        //4.设置响应头控制浏览器浏览器以图片的方式打开
        resp.setContentType("image/jpeg");//等同于response.setHeader("Content-Type", "image/jpeg");
        //5.设置响应头控制浏览器不缓存图片数据
        resp.setDateHeader("expries", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");
        //6.将图片写给浏览器
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 生成随机数字
     * @return num
     */
    private String makeNum(){
        Random random = new Random();
        String num = random.nextInt(9999999)+"";
        // 保证最后得到的数字是7位数
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7-num.length(); i++) {
            sb.append("0");
        }
        num = sb.toString()+num;
        return num;
    }
}
