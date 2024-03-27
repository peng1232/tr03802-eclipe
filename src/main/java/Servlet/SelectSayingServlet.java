package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SayingDAO;
import entity.Saying;

@WebServlet (urlPatterns = "/select")
public class SelectSayingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SayingDAO sdao = new SayingDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Saying> list = sdao.selectAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);;
	}

}
