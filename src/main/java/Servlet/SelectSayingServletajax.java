package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONArray;

import dao.SayingDAO;
import entity.Saying;

@WebServlet (urlPatterns = "/json/select2")
public class SelectSayingServletajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SayingDAO sdao = new SayingDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Saying> list = sdao.selectAll();
		//转换成json对象
		String json = JSONArray.toJSONString(list);
		//将json数组返回到客户端浏览器
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(json);
	}

}
