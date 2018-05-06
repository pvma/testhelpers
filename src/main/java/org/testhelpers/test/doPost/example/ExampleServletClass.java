package org.testhelpers.test.doPost.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExampleServletClass extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ExampleDaoClass exampleDaoClass;

	@Override
	public void init(ServletConfig config) throws ServletException {
		exampleDaoClass = new ExampleDaoClass();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// set response headers
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String name = exampleDaoClass.getLastName(1);

		// create HTML form
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>\r\n").append("<html>\r\n").append("		<head>\r\n")
				.append("			<title>Form input</title>\r\n").append("		</head>\r\n")
				.append("		<body>\r\n").append("			<form action=\"welcome\" method=\"POST\">\r\n")
				.append("				Enter your name: \r\n")
				.append("				<input type=\"text\" name=\"user\" />\r\n")
				.append("				<input type=\"submit\" value=\"Submit\" />\r\n")
				.append("			</form>\r\n").append("		</body>\r\n").append("</html>\r\n");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String name = exampleDaoClass.getName(1);
		String lastName = exampleDaoClass.getLastName(1);
		
		// create HTML response
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>\r\n").append("<html>\r\n").append("		<head>\r\n")
				.append("			<title>Welcome message</title>\r\n").append("		</head>\r\n")
				.append("		<body>\r\n");
		if (user != null && !user.trim().isEmpty()) {
			writer.append("	Welcome " + user + ".\r\n");
			writer.append("	You successfully completed this javatutorial.net example.\r\n");
		} else {
			writer.append("	You did not entered a name!\r\n");
		}
		writer.append("		</body>\r\n").append("</html>\r\n");
	}

}
