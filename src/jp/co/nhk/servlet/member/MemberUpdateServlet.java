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
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (name == "" && birthday == "" && tel == "" && address == "" && email == "" && password == "") {
			//if (name == null && birthday == null && tel == null && address == null && email == null && password == null) {
			request.setAttribute("message", "何か値を入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}

		if (password.length() < 8) {
			request.setAttribute("message", "パスワードの長さが足りません。");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

		HttpSession session = request.getSession(false);
		String usertype = "nobody";
		usertype = (String) session.getAttribute("usertype");

		int id = 0;
		if ("admin".equals(usertype)) {
			String idString = request.getParameter("id");
			id = Integer.parseInt(idString);
			session.setAttribute("id", id);
		}
		if ("member".equals(usertype)) {
			id = (int) session.getAttribute("id");
		}

		MemberBean newmember = new MemberBean(id, name, birthday, tel, address, email, password);
		MemberDAO memdao;
		String action = request.getParameter("action");

		try {
			memdao = new MemberDAO();

			if ("nobody".equals(usertype)) {
				request.setAttribute("message", "ログインしてください");
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
			if ("member".equals(usertype)) {
				if ("nyuryoku".equals(action)) {
					RequestDispatcher rd = request.getRequestDispatcher("memberUpdate.jsp");
					rd.forward(request, response);

				} else if ("confirm".equals(action)) {

					try {
						MemberBean member = memdao.findById(id);
						request.setAttribute("member", member);
						request.setAttribute("newmember", newmember);

						request.setAttribute("name", name);
						request.setAttribute("birthday", birthday);
						request.setAttribute("tel", tel);
						request.setAttribute("address", address);
						request.setAttribute("email", email);
						request.setAttribute("password", password);

						RequestDispatcher rd = request.getRequestDispatcher("memberUpdateConfirm.jsp");
						rd.forward(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if ("update".equals(action)) {
					memdao.updateData(id, newmember.getName(), newmember.getBirthday(), newmember.getAddress(),
							newmember.getTel(), newmember.getEmail(), newmember.getPassword());
					RequestDispatcher rd = request.getRequestDispatcher("memberUpdateComplete.jsp");
					rd.forward(request, response);
				} else {
				}
			} else if ("admin".equals(usertype)) {
				if ("nyuryoku".equals(action)) {
					request.setAttribute("id", id);
					RequestDispatcher rd = request.getRequestDispatcher("adminMemberUpdate.jsp");
					rd.forward(request, response);
				} else if ("confirm".equals(action)) {
					id = (int) session.getAttribute("id");
					try {
						MemberBean member = memdao.findById(id);
						request.setAttribute("member", member);
						request.setAttribute("newmember", newmember);

						request.setAttribute("id", id);
						request.setAttribute("name", name);
						request.setAttribute("birthday", birthday);
						request.setAttribute("tel", tel);
						request.setAttribute("address", address);
						request.setAttribute("email", email);
						request.setAttribute("password", password);

						RequestDispatcher rd = request.getRequestDispatcher("adminMemberUpdateConfirm.jsp");
						rd.forward(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if ("update".equals(action)) {
					id = (int) session.getAttribute("id");
					memdao.updateData(id, newmember.getName(), newmember.getBirthday(), newmember.getAddress(),
							newmember.getTel(), newmember.getEmail(), newmember.getPassword());
					RequestDispatcher rd = request.getRequestDispatcher("adminMemberUpdateComplete.jsp");
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