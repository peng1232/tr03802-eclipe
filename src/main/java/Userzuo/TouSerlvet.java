package Userzuo;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
* @Description: 
* @author: 铭
* @date 2024年3月7日 下午1:46:53
*/
@WebServlet(urlPatterns = "/user/tou")
@MultipartConfig
public class TouSerlvet extends HttpServlet {
	UserDAO udao=  new UserDAO();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//拿到上传的文件对象
		Part part = request.getPart("photo");
		if(part!=null) {
			//文件对应的信息
			String file= part.getHeader("content-disposition");
			//文件名称
			String filename = file.split(";")[2].split("=")[1].replaceAll("\"", "");
			//文件后缀
			String houzui = filename.substring(filename.lastIndexOf("."),filename.length());
			//新文件名
			String newname = UUID.randomUUID().toString().toUpperCase();
			//工程路径
			String root = getServletContext().getRealPath("");
			File wen = new File(root,"images");
			//查看images文件夹是否存在
			if(!wen.exists()) {
				wen.mkdir();
			}
			//保存图片
			part.write(wen+"\\"+newname+houzui);
			//更改库中路径
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			udao.headUpdate(user.getUid(),newname+houzui );
			//刷新数据
			user.setHead(newname+houzui);
			session.setAttribute("user", user);
			request.getRequestDispatcher("zhuye.jsp").forward(request, response);
		}
	}
}
