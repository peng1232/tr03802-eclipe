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
@WebServlet(urlPatterns = "/user/login")
public class dengluSerlvet extends HttpServlet {
	UserDAO udao=  new UserDAO();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String yzm = request.getParameter("yzm");
		String name =request.getParameter("name");
		String passwrod = request.getParameter("passwrod");
		if(yzm.equals(request.getSession().getAttribute("yzm"))) {
			User user = udao.dengLv(name, passwrod);
			if(user!=null) {
				request.getSession().setAttribute("user", user);
				response.sendRedirect("zhuye.jsp");
			}else {
				request.setAttribute("flag", "2");
				request.setAttribute("name", name);
				request.setAttribute("passwrod", passwrod);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else {
			//验证码错误
			request.setAttribute("flag", "1");
			request.setAttribute("name", name);
			request.setAttribute("passwrod", passwrod);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
}
