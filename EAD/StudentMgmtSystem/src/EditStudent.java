import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class EditStudent
 */
@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		String classN =request.getParameter("class");
		String age =request.getParameter("age");
		System.out.print(firstName);
		System.out.print(lastName);
		System.out.print(fatherName);
		System.out.print(classN);
		System.out.print(age);
		System.out.print(email);
		
		try {
			Connection connection = (Connection) ConnectionUtility.getMySqlConnection();
			Statement statement = (Statement) connection.createStatement();
			String updateQuery ="UPDATE StudentDetails SET firstName = '"+firstName+"', lastName = '"+lastName+"', fatherName = '"+fatherName+"', "
					+ "class='"+classN+"',age = '"+age+"' WHERE email = '"+email+"'";
			statement.executeUpdate(updateQuery);
		    System.out.println("Database updated successfully ");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
