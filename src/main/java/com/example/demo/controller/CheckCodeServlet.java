package com.example.demo.controller;

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
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/check")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@RequestMapping("/code")
	protected void check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置Servlet返回值类型是图片
		response.setContentType("image/jpeg");
		char codeTable[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't',
				'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P',
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };

		// 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		// 在内存中创建对象
		int width = 60, height = 22;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 获得图形上下文
		Graphics g = image.getGraphics();

		// 生成随机类
		Random random = new Random();

		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		// 画边框
		g.setColor(new Color(200, 200, 200));
		g.drawRect(0, 0, width - 1, height - 1);

		// 随机产生155条干扰线，使图像中的认证码不易被其他程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// 取随机产生的认证码(4位数字)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			// String rand=String.valueOf(random.nextInt(10));
			String rand = String.valueOf(codeTable[(int) (codeTable.length * Math.random())]);

			sRand += rand;
			// 将认证码显示到图像中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 13 * i + 6, 16);
		}

		// 将认证码存入session
		HttpSession session = request.getSession();
		session.setAttribute("rand", sRand);
		// 图像生效
		g.dispose();

		// 输出图像到页面
		// PrintWriter out = response.getWriter();
		// out.println(sRand);
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}
