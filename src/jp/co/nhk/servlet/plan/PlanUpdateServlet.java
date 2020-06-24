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
 * Servlet implementation class PlanUpdateServlet
 */
@WebServlet("/PlanUpdateServlet")
public class PlanUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlanUpdateServlet() {
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

		//		HttpSession session = request.getSession(false);
		//		String usertype = "nobody";
		//		usertype = (String) session.getAttribute("usertype");

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		int price = -1;
		int maxrooms = -1;

		int id = Integer.parseInt(request.getParameter("nowid"));
		request.setAttribute("nowid", id);

		if (action == null || action.length() == 0) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/planUpdate.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("input")) {
			if (request.getParameter("price") == null || request.getParameter("price").length() != 0) {
				price = Integer.parseInt(request.getParameter("price"));
			}
			if (request.getParameter("maxrooms") == null || request.getParameter("maxrooms").length() != 0) {
				maxrooms = Integer.parseInt(request.getParameter("maxrooms"));
			}
			PlanBean bean = new PlanBean(request.getParameter("name"), request.getParameter("detail"),
					price, maxrooms, id);
			request.setAttribute("bean", bean);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/planUpdateConfirm.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("confirm")) {
			PlanDAO dao = new PlanDAO();
			String name = request.getParameter("name");
			String detail = request.getParameter("detail");

			if (request.getParameter("price") == null || request.getParameter("price").length() != 0) {
				price = Integer.parseInt(request.getParameter("price"));
			}
			if (request.getParameter("maxrooms") == null || request.getParameter("maxrooms").length() != 0) {
				maxrooms = Integer.parseInt(request.getParameter("maxrooms"));
			}

			try {
				PlanBean pb = dao.findBy(id);
				int hotelId = pb.getHotelId();
				dao.update(id, hotelId, name, detail, price, maxrooms);
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/planUpdateComplete.jsp");
			dispatcher.forward(request, response);
		}
	}

}
