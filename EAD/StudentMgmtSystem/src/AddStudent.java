import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddStudent() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		String classN =request.getParameter("class");
		int age = Integer.parseInt(request.getParameter("age"));
		
		try {
			Connection connection = (Connection) ConnectionUtility.getMySqlConnection();
			Statement statement = (Statement) connection.createStatement();
			String updateQuery = "INSERT INTO StudentDetails VALUES('"+firstName+"','"+lastName+"','"+fatherName+"','"+email+"','"+classN+"','"+age+"')";
			statement.executeUpdate(updateQuery);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		out.println("<html><head><script>alert('Response Recorded');</script></head></html>");
		response.sendRedirect("index.html");
	}

}
