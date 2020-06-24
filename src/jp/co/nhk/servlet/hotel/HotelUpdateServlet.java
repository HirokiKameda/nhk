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
 * Servlet implementation class HotelUpadateServlet
 */
@WebServlet("/HotelUpdateServlet")
public class HotelUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HotelUpdateServlet() {
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
		int id = Integer.parseInt(request.getParameter("nowid"));

		request.setAttribute("nowid", id);
		if (action == null || action.length() == 0) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/innUpdate.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("input")) {

			HotelBean bean = new HotelBean(id, request.getParameter("name"), request.getParameter("intro"),
					request.getParameter("address"),
					request.getParameter("checkin"), request.getParameter("checkout"), request.getParameter("tel"));
			request.setAttribute("bean", bean);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/innUpdateConfirm.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("confirm")) {
			HotelDAO dao = new HotelDAO();
			String name = request.getParameter("name");
			String intro = request.getParameter("intro");
			String address = request.getParameter("address");
			String checkin = request.getParameter("checkin");
			String checkout = request.getParameter("checkout");
			String tel = request.getParameter("tel");

			//System.out.println(name + intro + address + checkin + checkout + tel);
			try {
				dao.update(id, name, intro, address, checkin, checkout, tel);
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/innUpdateComplete.jsp");
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
