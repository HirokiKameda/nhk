package jp.co.nhk.servlet.plan;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.nhk.bean.PlanBean;
import jp.co.nhk.dao.DAOException;
import jp.co.nhk.dao.PlanDAO;

/**
 * Servlet implementation class PlanShowServlet
 */
@WebServlet("/PlanShowServlet")
public class PlanShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlanShowServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
		String usertype = "nobody";
		usertype = (String) session.getAttribute("usertype");
		//String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("nowid"));
		request.setAttribute("nowid", id);

		request.setCharacterEncoding("UTF-8");
		PlanDAO dao = new PlanDAO();

		try {
			List<PlanBean> list = dao.findByHotel(id);
			request.setAttribute("plans", list);
		} catch (DAOException e) {
			e.printStackTrace();
		}

		if (usertype.contentEquals("admin")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/adminPlanList.jsp");
			dispatcher.forward(request, response);
		}
		if (usertype.contentEquals("member")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/memberPlanList.jsp");
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
