package jp.co.nhk.servlet.hotel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.nhk.bean.HotelBean;
import jp.co.nhk.dao.DAOException;
import jp.co.nhk.dao.HotelDAO;

/**
 * Servlet implementation class HotelDeleteServlet
 */
@WebServlet("/HotelDeleteServlet")
public class HotelDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HotelDeleteServlet() {
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
		request.setCharacterEncoding("UTF-8");
		// パラメータの解析
		String action = request.getParameter("action");
		HotelDAO dao = new HotelDAO();
		int id = Integer.parseInt(request.getParameter("nowid"));
		request.setAttribute("nowid", id);

		if (action == null || action.length() == 0) {

			try {
				HotelBean bean = dao.findBy(id);
				String name = bean.getName();
				request.setAttribute("name", name);
			} catch (DAOException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/innDeleteConfirm.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("confirm")) {

			try {
				dao.delete(id);
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/innDeleteComplete.jsp");
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
