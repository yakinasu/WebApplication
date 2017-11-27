package servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BookBean;
import logic.BookInfoLogic;
import tool.ServletHelper;

/**
 * Servlet implementation class bookAddServlet
 */
public class AddBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletHelper send = new ServletHelper();
	static final Logger logger = Logger.getLogger("");
	BookBean bookBean = new BookBean();
	BookInfoLogic addBookSql = new BookInfoLogic();
	ArrayList<BookBean> bookList = new ArrayList<BookBean>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF8");
		String bookTytle = request.getParameter("tytle");
		String isbn = request.getParameter("isbn");
		String page = request.getParameter("page");
		String author = request.getParameter("author");
		bookBean.setBean(isbn, bookTytle, page, author);
		try {
			addBookSql.insertBookInfodb(bookBean);
			RequestDispatcher dispatcher =request.getRequestDispatcher("MainPage/BookHome.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			send.sendDispatcher(request, response, "Login/confirmError.html");
		}
	}
}
