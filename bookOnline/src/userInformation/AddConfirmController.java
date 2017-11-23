package userInformation;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.ServletHelper;

/**
 * Servlet implementation class SendToConfirmationServlet
 */
public class AddConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServletHelper send = new ServletHelper();
    BookBean bookBean = new BookBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddConfirmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PrintWriter pw = response.getWriter();

		//HTMLを出力
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>入力確認画面</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<p>ISBNCode :" + bookBean.getIsbn() +"</p>");
		pw.println("<p>ISBNCode :" + bookBean.getBookTytle() +"</p>");
		pw.println("<p>ISBNCode :" + bookBean.getAuthor() +"</p>");
		pw.println("<p>ISBNCode :" + bookBean.getTotalPage() +"</p>");
		pw.println("<form method=\"get\" action =\"./BookAddServlet\">");
		pw.println("<input type = \"submit\"  class = \"button\" value = \"確認する\">");
		pw.println("</body>");

	}

}
