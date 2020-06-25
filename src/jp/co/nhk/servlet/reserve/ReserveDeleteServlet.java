package jp.co.nhk.servlet.reserve;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.nhk.dao.DAOException;
import jp.co.nhk.dao.ReserveDAO;

/**
 * Servlet implementation class ReserveDeleteServlet
 */
@WebServlet("/ReserveDeleteServlet")
public class ReserveDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReserveDeleteServlet() {
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

		String action = request.getParameter("action");
		String PlanId = request.getParameter("PlanId");
		int planId = Integer.parseInt(PlanId);
		request.setAttribute("PlanId", PlanId);

		ReserveDAO resdao = new ReserveDAO();
		if (action.equals("delete")) {
			try {
				request.setAttribute("reslist", resdao.findBy(planId));
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/reserveDeleteConfirm.jsp");
			dispatcher.forward(request, response);

		}
		if (action.equals("ok")) {
			try {
				resdao.deleteData(planId);
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/reserveDeleteComplete.jsp");
			dispatcher.forward(request, response);

		}
	}

}
