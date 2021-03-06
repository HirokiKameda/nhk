package jp.co.nhk.servlet.member;

import java.io.IOException;

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

		HttpSession session = request.getSession(false);
		String usertype = "nobody";
		usertype = (String) session.getAttribute("usertype");

		int id = 0;
		if ("admin".equals(usertype)) {
			String idString = request.getParameter("id");
			id = Integer.parseInt(idString);
			//	session.setAttribute("id", id);
		}
		if ("member".equals(usertype)) {
			id = (int) session.getAttribute("id");
		}

		MemberDAO memdao;
		String action = request.getParameter("action");
		try {
			memdao = new MemberDAO();
			if ("member".equals(usertype)) {
				if ("confirm".equals(action)) {
					MemberBean member = memdao.findById(id);
					//					request.setAttribute("member", member);
					request.setAttribute("name", member.getName());
					request.setAttribute("birthday", member.getBirthday());
					request.setAttribute("tel", member.getTel());
					request.setAttribute("address", member.getAddress());
					request.setAttribute("email", member.getEmail());
					request.setAttribute("password", member.getPassword());
					request.setAttribute("id", id);
					RequestDispatcher rd = request.getRequestDispatcher("memberDeleteConfirm.jsp");
					rd.forward(request, response);
				} else if ("delete".equals(action)) {
					memdao.deleteData(id);
					RequestDispatcher rd = request.getRequestDispatcher("memberDeleteComplete.jsp");
					rd.forward(request, response);
				} else {
				}
			}
			if ("admin".equals(usertype)) {
				if ("confirm".equals(action)) {
					MemberBean member = memdao.findById(id);
					//					request.setAttribute("member", member);
					request.setAttribute("name", member.getName());
					request.setAttribute("birthday", member.getBirthday());
					request.setAttribute("tel", member.getTel());
					request.setAttribute("address", member.getAddress());
					request.setAttribute("email", member.getEmail());
					request.setAttribute("password", member.getPassword());
					request.setAttribute("id", id);
					RequestDispatcher rd = request.getRequestDispatcher("adminMemberDeleteConfirm.jsp");
					rd.forward(request, response);
				} else if ("delete".equals(action)) {
					memdao.deleteData(id);
					RequestDispatcher rd = request.getRequestDispatcher("adminMemberDeleteComplete.jsp");
					rd.forward(request, response);
				} else {
				}
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
