package userInformation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * ホーム画面に変遷
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");

		String user = request.getParameter("userName");
		String password = request.getParameter("password");
		if(user.equals("test") && password.equals("1234")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/BookHome.jsp");
			dispatcher.forward(request, response);
		}
		else if (user.equals("kanri") && password.equals("1234")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Bookadmin.html");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("LoginFailed.html");
			dispatcher.forward(request, response);
		}

	}

	/**
	 *ユーザー新規登録
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		// result.jsp にページ遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.html");
		dispatcher.forward(request, response);
	}

}
