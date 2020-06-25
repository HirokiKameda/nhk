package jp.co.nhk.servlet.reserve;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.nhk.bean.HotelBean;
import jp.co.nhk.bean.ReserveBean;
import jp.co.nhk.dao.DAOException;
import jp.co.nhk.dao.HotelDAO;
import jp.co.nhk.dao.ReserveDAO;

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

		HttpSession session = request.getSession(true);

		String action = (String) session.getAttribute("usertype");

		//二次開発用
		//管理者側からと、会員側からのアクセスで場合分け
		ReserveDAO redao = new ReserveDAO();
		HotelDAO hodao = new HotelDAO();
		if (action.equals("admin")) {
			List<ReserveBean> list = new ArrayList<ReserveBean>();
			try {
				list = redao.findAll();
			} catch (DAOException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			List<HotelBean> list2 = new ArrayList<HotelBean>();
			//			try {
			//				list2 = hodao.findAll();
			//			} catch (DAOException e1) {
			//				// TODO 自動生成された catch ブロック
			//				e1.printStackTrace();
			//			}
			//List<String> hotelList=new ArrayList<String>();
			int index = 0;
			for (ReserveBean data : list) {
				try {
					list2.add(hodao.findBy(data.getHotelId()));
					//					data.setHotelname(list2.get(index).getName());
					list.get(index).setHotelname(list2.get(index).getName());
					index++;
				} catch (DAOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
					System.out.println("宿データなし");
					//					data.setHotelname("すでにないデータです");
					list.get(index).setHotelname("すでにないデータです");
					index++;
				}
			}

			request.setAttribute("list", list);
			//	request.setAttribute("hotellist", list2);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/adminReserveList.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("member")) {
			List<ReserveBean> list = new ArrayList<ReserveBean>();
			try {
				request.setAttribute("list", redao.findByMember((int) session.getAttribute("id")));
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/memberReserveList.jsp");
			dispatcher.forward(request, response);
		}

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
