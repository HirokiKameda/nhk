package jp.co.nhk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/////
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=SJIS");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>HelloServlet</title></head><body>");
		out.println("<h1>ようこそ！HelloServletへ！</h1></body></html>");

		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//http://localhost:8080/jmaster/hello
		//

	}

}
