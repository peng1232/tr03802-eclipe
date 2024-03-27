package Servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SayingDAO;

@WebServlet (urlPatterns = "/page")
public class ListPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    SayingDAO sdao = new SayingDAO();   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取数据
		Integer curpage = Integer.valueOf(request.getParameter("curpage"));
		Integer pagesize = Integer.valueOf(request.getParameter("pagesize"));
		if(curpage ==null||pagesize==null) {
			curpage = 1;
			pagesize = 3;
		}
		//调用dao
		Map<String, Object> map = sdao.selectByPage(curpage, pagesize);
		request.setAttribute("map", map);
		
		//跳转
		request.getRequestDispatcher("list-page.jsp").forward(request, response);;
	}

}
