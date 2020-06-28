package jp.co.nhk.servlet.hotel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jp.co.nhk.bean.HotelBean;
import jp.co.nhk.dao.DAOException;
import jp.co.nhk.dao.HotelDAO;

/**
 * Servlet implementation class HotelUpadateServlet
 */
@WebServlet("/HotelUpdateServlet")
@MultipartConfig(maxFileSize = 1048576)
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String fileName = "";
		File uploadDir = new File(getServletContext().getRealPath("/upload"));
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		// パラメータの解析
		String action = request.getParameter("action");

		int id = Integer.parseInt(request.getParameter("nowid"));

		request.setAttribute("nowid", id);
		if (action == null || action.length() == 0) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/innUpdate.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("input")) {
			Part part = request.getPart("fileUpload");
			fileName = part.getSubmittedFileName();

			save(part, new File(uploadDir, fileName));

			request.setAttribute("uploadFilePath", "/upload/" + fileName);

			HotelBean bean = new HotelBean(id, request.getParameter("name"), request.getParameter("intro"),
					request.getParameter("address"),
					request.getParameter("checkin"), request.getParameter("checkout"), request.getParameter("tel"),
					fileName);
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
			fileName = request.getParameter("url");

			if (name.isEmpty() && intro.isEmpty() && address.isEmpty() && checkin.isEmpty() && checkout.isEmpty()
					&& tel.isEmpty() && fileName.isEmpty()) {
				request.setAttribute("message", "何か値を入力してください");
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				return;
			}

			//System.out.println(name + intro + address + checkin + checkout + tel);
			try {
				dao.update(id, name, intro, address, checkin, checkout, tel, fileName);
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	public void save(Part in, File out) throws IOException {//そのままコピペでOK
		BufferedInputStream br = new BufferedInputStream(in.getInputStream());
		try (BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(out))) {
			int len = 0;
			byte[] buff = new byte[1024];
			while ((len = br.read(buff)) != -1) {
				bw.write(buff, 0, len);
			}
		}
	}

}
