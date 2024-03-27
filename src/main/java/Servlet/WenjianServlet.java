package Servlet;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet (urlPatterns = "/wenjian")
@MultipartConfig
public class WenjianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("desc"));
		//获取上传的对象
		Part part = request.getPart("photo");
		//找到文件名
		String cp = part.getHeader("content-disposition");
		String fileName = cp.split(";")[2].split("=")[1].replaceAll("\"", "");
		//文件后缀名
		fileName = fileName.substring(fileName.lastIndexOf(".")-1,fileName.length());
		//随机生成字符串
		String rndString = UUID.randomUUID().toString().toUpperCase();
		//获取发布后的工程更目录
		String root = this.getServletContext().getRealPath("");
		System.out.println(root);
		//发布之后的工程路径
		File file = new File(root, "images");
		if(!file.exists()) {
			file.mkdir();
		}
		//保存到服务器中 路径+"/"+文件名+后缀名
		part.write(file+"\\"+rndString+fileName);
		//存储上传后保存的路径
		request.setAttribute("photo", rndString+fileName);
		//转发
		request.getRequestDispatcher("wenjianshangchuang.jsp").forward(request, response);
	}

}
