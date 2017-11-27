package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.BookInfoLogic;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookInfoLogic updateBookSql = new BookInfoLogic();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String key = request.getParameter("key");
			String isbn = request.getParameter("isbn");
			String record = request.getParameter("record");
			updateBookSql.updataBookdb(key, isbn, record);
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage/BookHome.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e){
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login/confirmError.html");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
