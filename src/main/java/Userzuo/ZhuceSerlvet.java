package Userzuo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @Description: 
* @author: 铭
* @date 2024年3月7日 下午1:46:53
*/
@WebServlet(urlPatterns = "/user/zhece")
public class ZhuceSerlvet extends HttpServlet {
	UserDAO udao=  new UserDAO();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String passwrod = request.getParameter("passwrod");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String head = "default.jpg";
		User u = new User(null, name, passwrod, tel, address, head);
		udao.insert(u);
		response.sendRedirect("login.jsp");
		
	}
}
