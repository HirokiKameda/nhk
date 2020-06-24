package jp.co.nhk.servlet.reserve;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.nhk.dao.ReserveDAO;

/**
 * Servlet implementation class ReserveInsertServlet
 */
@WebServlet("/ReserveInsertServlet")
public class ReserveInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReserveInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		LocalDateTime date1 = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日,HH時mm分ss秒");

		String dateString = dateTimeFormatter.format(date1);
		String checkindate = request.getParameter("checkindate");
		String checkoutdate = request.getParameter("checkoutdate");
		String people = request.getParameter("people");
		String PlanId = request.getParameter("PlanId");

		String[] date = dateString.split(",", 0);
		String reservedate = date[0];
		String reservetime = date[1];

		ReserveDAO reDAO = new ReserveDAO();
		if (action.equals("input")) {
			request.setAttribute("reservedate", reservedate);
			request.setAttribute("reservetime", reservetime);
			request.setAttribute("checkindate", checkindate);
			request.setAttribute("checkoutdate", checkoutdate);
			request.setAttribute("people", people);
			request.setAttribute("PlanId", PlanId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/reserveInsertConfirm.jsp");
			dispatcher.forward(request, response);

		} else if (action.equals("confirm")) {
			HttpSession session = request.getSession(false);
			int memberId = 0;
			//memberId = (int) session.getAttribute("id");//管理者の場合idを頑張って持ってくる必要あり
			int rooms = (Integer.parseInt(people) + 1) / 2;
			int peopledata = Integer.parseInt(people);

			//			int planId=Integer.parseInt("PlanId");

			//			try {
			//				reDAO.insert(planId, memberId, reservedate, reservetime, checkindate, checkoutdate, rooms, peopledata);
			//			} catch (DAOException e) {
			//				e.printStackTrace();
			//			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/reserveInsertComplete.jsp");
			dispatcher.forward(request, response);

		}

	}

}
