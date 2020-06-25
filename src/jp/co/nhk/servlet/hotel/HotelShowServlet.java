package jp.co.nhk.servlet.hotel;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.nhk.bean.HotelBean;
import jp.co.nhk.dao.DAOException;
import jp.co.nhk.dao.HotelDAO;

/**
 * Servlet implementation class HotelShowServlet
 */
@WebServlet("/HotelShowServlet")
public class HotelShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HotelShowServlet() {
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
		HttpSession session = request.getSession(false);
		String usertype = "nobody";
		usertype = (String) session.getAttribute("usertype");
		request.setCharacterEncoding("UTF-8");
		HotelDAO dao = new HotelDAO();
		try {
			List<HotelBean> list = dao.findAll();
			request.setAttribute("inns", list);
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if (usertype.contentEquals("admin")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/innList.jsp");
			dispatcher.forward(request, response);
		}
		if (usertype.contentEquals("member")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/memInnList.jsp");
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
