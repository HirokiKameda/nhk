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
 * Servlet implementation class HotelInsertServlet
 */
@WebServlet("/HotelInsertServlet")
public class HotelInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HotelInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		// パラメータの解析
		String action = request.getParameter("action");

		if (action.equals("input")) {
			HotelBean bean = new HotelBean(request.getParameter("name"), request.getParameter("intro"),
					request.getParameter("address"),
					request.getParameter("checkin"), request.getParameter("checkout"), request.getParameter("tel"));
			request.setAttribute("bean", bean);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/innInsertConfirm.jsp");

			dispatcher.forward(request, response);
		} else if (action.equals("confirm")) {
			HotelDAO dao = new HotelDAO();

			String name = request.getParameter("name");
			String intro = request.getParameter("intro");
			String address = request.getParameter("address");
			String checkin = request.getParameter("checkin");
			String checkout = request.getParameter("checkout");
			String tel = request.getParameter("tel");

			System.out.println(name + intro + address + checkin + checkout + tel);

			try {
				dao.insert(name, intro, address, checkin, checkout, tel);
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/innInsertComplete.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
