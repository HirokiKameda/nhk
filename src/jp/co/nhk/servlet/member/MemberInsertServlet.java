package jp.co.nhk.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.nhk.dao.MemberDAO;

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
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (password.length() < 8) {
			request.setAttribute("message", "パスワードの長さが足りません。");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		MemberDAO memdao;
		String action = request.getParameter("action");
		try {
			memdao = new MemberDAO();
			if ("confirm".equals(action)) {

				request.setAttribute("name", name);
				request.setAttribute("birthday", birthday);
				request.setAttribute("tel", tel);
				request.setAttribute("address", address);
				request.setAttribute("email", email);
				request.setAttribute("password", password);

				RequestDispatcher rd = request.getRequestDispatcher("memberInsertConfirm.jsp");
				rd.forward(request, response);
			} else if ("insert".equals(action)) {
				HttpSession session = request.getSession(false);
				session.setAttribute("id", memdao.addData(name, birthday, address, tel, email, password));
				session.setAttribute("usertype", "member");
				RequestDispatcher rd = request.getRequestDispatcher("memberInsertComplete.jsp");
				rd.forward(request, response);
			} else {
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
