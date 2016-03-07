package core;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class MainWebApp
 */
public class MainWebApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// I know that should be in a configuration file, but just
	// for this example, those data will be constants.
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";

	/**
	 * @throws ServletException 
	 * @see HttpServlet#HttpServlet()
	 */
	public MainWebApp() throws ServletException {
		super();
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GitAppController controller = new GitAppController(USERNAME, PASSWORD);
		ServletContext context = getServletContext();
		InputStream inputStream = context.getResourceAsStream("/WEB-INF/test.aia");
		byte[] file = IOUtils.toByteArray(inputStream);
 		String nome = controller.createRepoAia(file);
		response.getWriter().append("Repository created, visit it <a href=\"https://github.com/gitaitest/"+nome+"\"> here </a>");
	}

	public static void main(String[] args) throws ServletException, IOException {
		MainWebApp m = new MainWebApp();
		m.doGet(null, null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
