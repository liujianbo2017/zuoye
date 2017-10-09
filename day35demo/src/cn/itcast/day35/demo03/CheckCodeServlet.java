package cn.itcast.day35.demo03;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCodeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 生成验证码字符串
		String src = "23456789abcdefghijkmnpqrstuvwxzy";
		// 使用随机数从此字符串中取得四个字符，组成一个四个字符的验证码
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		// 循环四次
		for (int i = 0; i < 4; i++) {
			// 从源字符串中随机取得一个字符
			char c = src.charAt(r.nextInt(src.length()));
			// 追加到StringBuilder中
			sb.append(c);
		}
		String checkCode = sb.toString();
		System.out.println(checkCode);
		// 生成验证码图片
		// BufferedImage对象就是一个图片，可以把它理解为一张画板
		BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		// 得到画笔
		Graphics g = image.getGraphics();
		// 设置画笔为灰色
		g.setColor(new Color(210, 210, 255));
		//// 在画布的全范围填充矩形，相当于设置背景色
		g.fillRect(0, 0, 80, 30);
		// 画东西，Java中图片的坐标系，左上角是0，0点，往下是X增，往右是Y增
		// 文字 的坐标系00点在左下角
		for (int i = 0; i < 4; i++) {
			// 设置颜色，10~20之间的随机字体大小和随机颜色
			g.setFont(new Font("仿宋", Font.BOLD, 20 + r.nextInt(7)));
			g.setColor(new Color(r.nextInt(150), r.nextInt(150), r.nextInt(150)));
			// 画一个字符
			g.drawString(checkCode.charAt(i) + "", i * 20 + r.nextInt(10), 20 + r.nextInt(10));
			// 画干扰线
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), r.nextInt(30));
		}
		//把图片内容发回给浏览器（resp.getOutputStream()）
		//使用ImageIO的工具类进行图片内容的发送
		ImageIO.write(image, "jpeg", resp.getOutputStream() );

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
