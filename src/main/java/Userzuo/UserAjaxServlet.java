package Userzuo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONArray;

/**
* @Description: 
* @author: 铭
* @date 2024年3月11日 上午11:07:15
*/
@WebServlet(urlPatterns = "/user/query")
public class UserAjaxServlet extends HttpServlet{
	UserDAO udao= new UserDAO();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> selectAll = udao.selectAll();
		String json = JSONArray.toJSONString(selectAll);
		System.out.println(json);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(json);
	}
}
