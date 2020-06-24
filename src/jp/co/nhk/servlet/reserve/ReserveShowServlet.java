package jp.co.nhk.servlet.reserve;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReserveShowServlet
 */
@WebServlet("/ReserveShowServlet")
public class ReserveShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReserveShowServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//String action = request.getParameter("action");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminReserveList.jsp");
		dispatcher.forward(request, response);

		//二次開発用
		//管理者側からと、会員側からのアクセスで場合分け
		/*
		if (action.equals("admin")) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminReserveList.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("member")) {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/memberReserveList.jsp");
			dispatcher.forward(request, response);
		}
		*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

	}

}
