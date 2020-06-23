package jp.co.nhk.servlet.plan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		//PlanDAO dao = new PlanDAO();
		//List<PlanBean> list = dao.findAll();
		//request.setAttribute("plan", list);

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if (action.equals("admin")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/adminPlantList.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("member")) {
			//HotelDAO dao = new HotelDAO();

			RequestDispatcher dispatcher = request.getRequestDispatcher("/memberPlantList.jsp");
			dispatcher.forward(request, response);
		}

		/*try {
			//EmpDAO dao = new EmpDAO();
			//List<EmpBean> list = dao.findAll();
			//request.setAttribute("emp", list);
			RequestDispatcher rd = request.getRequestDispatcher("/planList.jsp");
			rd.forward(request, response);
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラー");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);
		}*/

		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
