package jp.co.nhk.servlet.plan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlanInsertServlet
 */
@WebServlet("/PlanInsertServlet")
public class PlanInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlanInsertServlet() {
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

		//dao.insert(request.getParameter("id"), request.getParameter("hotelId"), request.getParameter("detail"), request.getParameter("price"), request.getParameter("maxrooms"));
		//List<PlanBean> list = dao.findAll();
		//request.setAttribute("plan", list);
		//request.setAttribute("message", "一件追加しました。");

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if (action.equals("input")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/planInsertConfirm.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("confirm")) {
			//HotelDAO dao = new HotelDAO();

			RequestDispatcher dispatcher = request.getRequestDispatcher("/planInsertComplete.jsp");
			dispatcher.forward(request, response);
		}

		//メモ
		/*
		if (action.equals("input")) {
			PlanBean pb = new PlanBean();
			String detail = request.getParameter("detail");
			int price = Integer.parseInt(request.getParameter("price"));
			int maxrooms = Integer.parseInt(request.getParameter("maxrooms"));
		
			// PlanBeanに変更内容を入れてJSPへフォワードする
			request.setAttribute("plan", pb);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/planInsertConfirm.jsp");
			dispatcher.forward(request, response);
		
		} else if (action.equals("confirm")) {
			request.setAttribute("emps", list);
			gotoPage(request, response, "/showItem.jsp");
		
		} else {
			request.setAttribute("message", "正しく操作してください");
			gotoPage(request, response, "/errInternal.jsp");
		}
		*/

		/*
		try {
			EmpDAO dao = new EmpDAO();
		
			dao.setEmp(request.getParameter("name"), request.getParameter("age"), request.getParameter("tel"));
			List<EmpBean> list = dao.findAll();
			request.setAttribute("emp", list);
			request.setAttribute("message", "一件追加しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/Result.jsp");
			rd.forward(request, response);
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラー");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);
		}
		*/

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
