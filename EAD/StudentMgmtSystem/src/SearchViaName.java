import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchViaName
 */
@WebServlet("/SearchViaName")
public class SearchViaName extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		if ("".equals(firstName)) {
		firstName = "%";
		}
		String lastName = request.getParameter("lastName");
		if ("".equals(lastName)) {
		lastName = "%";
		}
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		try {
			Connection connection =ConnectionUtility.getMySqlConnection();
			Statement statement = (Statement) connection.createStatement();
			String sql = "SELECT * FROM StudentDetails WHERE firstName LIKE '"+ firstName + "' AND lastName LIKE '" + lastName+ "'";
			ResultSet rs=statement.executeQuery(sql);
			if(rs.getFetchSize()==0)
			{
				out.println("<body><h1>No data found with  this name</h1></body>");
				  out.println("<body><a href='http://localhost:8080/StudentMgmtSystem/SearchStudent.html'><button>Back</button></a></body>");
			}
			else
			{
			out.println("<head>");
			out.println("<style>");
			out.println("table, th, td{border: 1px solid black; margin: 2px;border-collapse: collapse; padding:2px}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Search Results</h1>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<td>First Name</td>");
			out.println("<td>Last Name</td>");
			out.println("<td>Father's Name</td>");
			out.println("<td>Email</td>");
			out.println("<td>Age</td>");
			out.println("<td>Class</td>");
			out.println("</tr>");
			out.println();
			while (rs.next()) {
			firstName = rs.getString("firstName");
			lastName = rs.getString("lastName");
			String fatherName = rs.getString("fatherName");
			String email = rs.getString("email");
			String classStudent = rs.getString("class");
			int age = rs.getInt("age");

			out.println("<tr>");
			out.println("<td>" + firstName + "</td>");
			out.println("<td>" + lastName + "</td>");
			out.println("<td>" + fatherName + "</td>");
			out.println("<td>" + email + "</td>");
			out.println("<td>" + age + "</td>");
			out.println("<td>" + classStudent + "</td>");
			out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");

		}
			out.close();
			} catch (Exception e) {
			e.printStackTrace();
			}
		} 
	}

	
