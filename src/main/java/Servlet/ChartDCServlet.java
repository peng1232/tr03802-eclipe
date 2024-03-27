package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VEO.ChartDCVO;
import dao.SayingDAO;

@WebServlet (urlPatterns = "/chartDC")
public class ChartDCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SayingDAO sdao = new SayingDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ChartDCVO> list = sdao.charDC();
		Integer total = 0;
		for(ChartDCVO c:list) {
			total+=c.getCount();
		}
		request.setAttribute("list", list);
		request.setAttribute("total", total);
		request.getRequestDispatcher("tongji.jsp").forward(request, response);;
	}

}
