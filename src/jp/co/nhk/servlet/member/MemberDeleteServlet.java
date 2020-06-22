package jp.co.nhk.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/MemberDeleteServlet")
public class MemberDeleteServlet extends HttpServlet {

	public MemberDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String usertype = (String) sc.getAttribute("usertype");
		String action = request.getParameter("action");
		if ("member".equals(usertype)) {
			if ("confirm".equals(action)) {
				RequestDispatcher rd = request.getRequestDispatcher("memberDeleteConfirm.jsp");
				rd.forward(request, response);
			} else if ("delete".equals(action)) {
				RequestDispatcher rd = request.getRequestDispatcher("memberDeleteComplete.jsp");
				rd.forward(request, response);
			} else {
			}
		}
		if ("admin".equals(usertype)) {
			if ("confirm".equals(action)) {
				RequestDispatcher rd = request.getRequestDispatcher("adminMemberDeleteConfirm.jsp");
				rd.forward(request, response);
			} else if ("delete".equals(action)) {
				RequestDispatcher rd = request.getRequestDispatcher("adminMemberDeleteComplete.jsp");
				rd.forward(request, response);
			} else {
			}
		}
	}
}
