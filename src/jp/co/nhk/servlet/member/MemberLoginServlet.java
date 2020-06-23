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
@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberLoginServlet() {
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

		try {
			MemberDAO memdao = new MemberDAO();
			List<MemberBean> list = new ArrayList<MemberBean>();
			list = memdao.findAll();
			request.setAttribute("list", list);
			for (MemberBean data : list) {
				if (data.getEmail() == request.getParameter("email")
						&& data.getPassword() == request.getParameter("password")) {
					request.setAttribute("id", data.getId());
					System.out.println(data.getName());
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
			RequestDispatcher rd = request.getRequestDispatcher("memberMenu.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("isLogin", "1");
			RequestDispatcher rd = request.getRequestDispatcher("adminLogin.jsp");
			rd.forward(request, response);
		}

	}

}
