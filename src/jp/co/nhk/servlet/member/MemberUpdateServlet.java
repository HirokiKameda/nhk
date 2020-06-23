package jp.co.nhk.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {

	public MemberUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String usertype = "nobody";
		usertype = (String) session.getAttribute("usertype");
		String action = request.getParameter("action");
		if ("nobody".equals(usertype)) {
			RequestDispatcher rd = request.getRequestDispatcher("memberLogin.jsp");
			rd.forward(request, response);
		}
		if ("member".equals(usertype)) {
			if ("nyuryoku".equals(action)) {
				RequestDispatcher rd = request.getRequestDispatcher("memberUpdate.jsp");
				rd.forward(request, response);
			} else if ("confirm".equals(action)) {
				RequestDispatcher rd = request.getRequestDispatcher("memberUpdateConfirm.jsp");
				rd.forward(request, response);
			} else if ("update".equals(action)) {
				RequestDispatcher rd = request.getRequestDispatcher("memberUpdateComplete.jsp");
				rd.forward(request, response);
			} else {
			}
		} else if ("admin".equals(usertype)) {
			if ("nyuryoku".equals(action)) {
				RequestDispatcher rd = request.getRequestDispatcher("adminMemberUpdate.jsp");
				rd.forward(request, response);
			} else if ("confirm".equals(action)) {
				RequestDispatcher rd = request.getRequestDispatcher("adminMemberUpdateConfirm.jsp");
				rd.forward(request, response);
			} else if ("update".equals(action)) {
				RequestDispatcher rd = request.getRequestDispatcher("adminMemberUpdateComplete.jsp");
				rd.forward(request, response);
			} else {
			}
		}
	}

}