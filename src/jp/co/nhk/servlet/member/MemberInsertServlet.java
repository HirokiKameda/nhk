package jp.co.nhk.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/MemberInsertServlet")
public class MemberInsertServlet extends HttpServlet {

	public MemberInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		if (password.length() < 9) {
			request.setAttribute("message", "パスワードの長さが足りません。");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

		String action = request.getParameter("action");
		if ("confirm".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("memberInsertConfirm.jsp");
			rd.forward(request, response);
		} else if ("insert".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("memberInsertComplete.jsp");
			rd.forward(request, response);
		} else {
		}
	}

}
