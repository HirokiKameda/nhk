package jp.co.nhk.servlet.hotel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		if (action == null || action.length() == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/innUpdate.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("input")) {
			//HotelDAO dao = new HotelDAO(); findby

			RequestDispatcher dispatcher = request.getRequestDispatcher("/innUpdateConfirm.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("confirm")) {
			//HotelDAO dao = new HotelDAO();

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
