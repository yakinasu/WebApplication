package userInformation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookDeleteServlet
 */
public class BookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookBean bookBean = new BookBean();
	BookInfoLogic deleteBookSql = new BookInfoLogic();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubBookHome
		String isbn = request.getParameter("isbn");
		System.out.println(isbn);
		try {
			deleteBookSql.deleteBookdb(isbn);
			RequestDispatcher dispatcher =request.getRequestDispatcher("/BookHome.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			RequestDispatcher dispatcher =request.getRequestDispatcher("/confirmError.jsp");
			dispatcher.forward(request, response);
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
