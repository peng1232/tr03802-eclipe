package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;

import dao.SayingDAO;
import entity.Saying;

@WebServlet (urlPatterns = "/json/insert2")
public class InsertSayingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SayingDAO sdao = new SayingDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("user");
		String content = request.getParameter("content");
		System.out.println(user);
		sdao.insert(new Saying(user, content));
		List<Saying> list = sdao.selectAll();
		String json = JSONObject.toJSONString(list);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(json);
	}

}
