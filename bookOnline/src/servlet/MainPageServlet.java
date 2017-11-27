package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainPageServlet
 */
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		if (request.getParameter("add") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage/bookAdd.html");
			dispatcher.forward(request, response);
			return;
		}
		if (request.getParameter("search") != null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage/searchHome.html");
			dispatcher.forward(request, response);
			return;
		}
		if (request.getParameter("upload") != null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage/ChangeKey.html");
			dispatcher.forward(request, response);
			return;
		}
	}
}
