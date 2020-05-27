package volodymyr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import volodymyr.domain.User;
import volodymyr.service.UserService;
import volodymyr.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = UserServiceImpl.getUserService();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String userEmail = request.getParameter("userEmail");
		String password = request.getParameter("password");

		if (!firstName.isEmpty() && !lastName.isEmpty() && !address.isEmpty() && !userEmail.isEmpty()
				&& !password.isEmpty()) {
			userService.create(new User(firstName, lastName, address, userEmail, password));
		}

		request.getRequestDispatcher("cabinet.jsp").forward(request, response);
	}

}
