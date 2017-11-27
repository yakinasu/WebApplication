package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BookBean;
import logic.BookInfoLogic;

/**
 * Servlet implementation class searchBookInfoServlet
 */
public class searchBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookBean bookBean = new BookBean();
	BookInfoLogic searchBookSql = new BookInfoLogic();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchBookInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		if (request.getParameter("upload") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage/ChangeKey.html");
			dispatcher.forward(request, response);
			return;
		}
		String isbn = request.getParameter("isbn");
		bookBean = searchBookSql.selectBookdb(isbn);
		if (bookBean == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login/confirmError.html");
			dispatcher.forward(request, response);
			return;
		} else {
			request.setAttribute("bookList", bookBean);
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage/searchResult.jsp");
			dispatcher.forward(request, response);
			return;

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
