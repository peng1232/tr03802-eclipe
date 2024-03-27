package Userzuo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/user/yzm")
public class yzm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random rm = new Random();
		String x = "";
		for (int i = 0; i < 4; i++) {
			x += rm.nextInt(10);
		}

		// 设置响应类型为图片
		response.setContentType("image/png");
		// 创建一张空白图片
		BufferedImage bi = new BufferedImage(101, 51, BufferedImage.TYPE_INT_RGB);
		// 获取画笔
		Graphics g = bi.getGraphics();
		// 画现状
		g.drawRect(0, 0, 100, 50);
		g.drawLine(100, 40, 10, 10);
		g.drawLine(100, 10, 10, 40);
		// 设置颜色
		g.setColor(Color.pink);
		g.setFont(new Font("微软雅黑", Font.BOLD, 20));
		// 画文字
		String zi = x;
		// 保存验证码
		g.drawString(zi, 25, 35);
		// 输出到浏览器
		request.getSession().setAttribute("yzm", zi);
		ImageIO.write(bi, "png", response.getOutputStream());
		// 释放资源
		g.dispose();
		
	}

}
