package spms.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;

// ServletContext에 보관된 Connection 객체 사용  
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		try {
			ServletContext sc = this.getServletContext();

			MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
			
			memberDao.delete(Integer.parseInt(request.getParameter("no")));
			
			response.sendRedirect("list");
			
		} catch (Exception e) {
			throw new ServletException(e);
			
		} 

	}
}
