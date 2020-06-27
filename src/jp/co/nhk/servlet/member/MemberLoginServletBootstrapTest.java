package jp.co.nhk.servlet.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.nhk.bean.MemberBean;
import jp.co.nhk.dao.MemberDAO;

/**
 * Servlet implementation class MemberLoginServlet
 */

@WebServlet("/MemberLoginServletBootstrapTest")
public class MemberLoginServletBootstrapTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberLoginServletBootstrapTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String adminUSERNAME = "admin";
		String adminPASSWORD = "himitu";
		String EMAIL = "member";
		String PASSWORD = "himitu";

		HttpSession session = request.getSession();

		boolean usersession = false;

		try {
			MemberDAO memdao = new MemberDAO();
			List<MemberBean> list = new ArrayList<MemberBean>();
			list = memdao.findAll();
			request.setAttribute("list", list);
			for (MemberBean data : list) {
				if (data.getEmail().equals(request.getParameter("email"))
						&& data.getPassword().equals(request.getParameter("password"))) {
					request.setAttribute("id", data.getId());//多分sessionの書き間違いだけど消してない
					session.setAttribute("id", data.getId());
					System.out.println(data.getName());
					usersession = true;
				}
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

		String usertype = "nobody";
		usertype = request.getParameter("usertype");
		// アプリケーションスコープの保存領域を確保

		// アプリケーションスコープに保存
		session.setAttribute("usertype", usertype);

		// アプリケーションスコープからインスタンスを取得
		usertype = (String) session.getAttribute("usertype");

		if ((adminUSERNAME.equals(request.getParameter("username")))
				&& (adminPASSWORD.equals(request.getParameter("password")))
				&& (usertype.equals("admin"))) {
			request.setAttribute("isLogin", "0");
			RequestDispatcher rd = request.getRequestDispatcher("adminMenu.jsp");
			rd.forward(request, response);
		} else if ((EMAIL.equals(request.getParameter("email")))
				&& (PASSWORD.equals(request.getParameter("password")))
				&& (usertype.equals("member"))) {
			request.setAttribute("isLogin", "0");
			RequestDispatcher rd = request.getRequestDispatcher("memberMenuBootstrapTest.jsp");
			rd.forward(request, response);
		} else if (usersession) {
			request.setAttribute("isLogin", "0");
			RequestDispatcher rd = request.getRequestDispatcher("memberMenuBootstrapTest.jsp");
			rd.forward(request, response);
		} else if (usertype.equals("admin")) {
			request.setAttribute("isLogin", "1");
			RequestDispatcher rd = request.getRequestDispatcher("adminLoginBootstrapTest.jsp");
			rd.forward(request, response);
		} else if (usertype.equals("member")) {
			request.setAttribute("isLogin", "1");
			RequestDispatcher rd = request.getRequestDispatcher("memberLoginBootstrapTest.jsp");
			rd.forward(request, response);
		}

	}

}
