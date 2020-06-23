package jp.co.nhk.servlet.plan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.nhk.bean.PlanBean;
import jp.co.nhk.dao.DAOException;
import jp.co.nhk.dao.PlanDAO;

/**
 * Servlet implementation class PlanDeleteServlet
 */
@WebServlet("/PlanDeleteServlet")
public class PlanDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlanDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		request.setCharacterEncoding("UTF-8");
		PlanDAO dao = new PlanDAO();

		///*
		int id = Integer.parseInt(request.getParameter("nowid"));
		request.setAttribute("nowid", id);
		//*/

		// パラメータの解析
		String action = request.getParameter("action");

		if (action == null || action.length() == 0) {
			try {
				PlanBean bean = dao.findBy(id);
				String name = bean.getName();
				request.setAttribute("name", name);
			} catch (DAOException e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/planDeleteConfirm.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("confirm")) {
			try {
				dao.delete(id);
			} catch (DAOException e) {
				e.printStackTrace();
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/planDeleteComplete.jsp");
			dispatcher.forward(request, response);
		}

	}

}
