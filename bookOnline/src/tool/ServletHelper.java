package tool;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletHelper {
	static final Logger logger = Logger.getLogger("");
	public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String url)
			throws IOException, ServletException {
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} catch (IOException e) {
			logger.severe("urlが正常ではありません。");
		}

	}
}
