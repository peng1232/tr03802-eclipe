package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SayingDAO;
import entity.Saying;

@WebServlet (urlPatterns = "/delete")
public class DeleteSayingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SayingDAO sdao = new SayingDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sid = request.getParameter("sid");
		String[] sids = sid.split(",");
		for(String s :sids) {
			sdao.doDelete(Integer.valueOf(s));
		}
	}

}
