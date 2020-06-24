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

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		int nowid = Integer.parseInt(request.getParameter("nowid"));

		request.setAttribute("nowid", nowid);

		if (action == null || action.length() == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/planInsert.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("input")) {
			PlanBean bean = new PlanBean(nowid, request.getParameter("name"), request.getParameter("detail"),
					Integer.parseInt(request.getParameter("price")),
					Integer.parseInt(request.getParameter("maxrooms")));
			request.setAttribute("bean", bean);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/planInsertConfirm.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("confirm")) {
			PlanDAO dao = new PlanDAO();

			String name = request.getParameter("name");
			String detail = request.getParameter("detail");
			//String price = request.getParameter("price");
			int price = Integer.parseInt(request.getParameter("price"));
			int maxrooms = Integer.parseInt(request.getParameter("maxrooms"));
			try {
				dao.insert(nowid, name, detail, price, maxrooms);
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
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
