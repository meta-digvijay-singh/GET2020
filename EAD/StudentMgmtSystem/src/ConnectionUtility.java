import java.sql.*;

public class ConnectionUtility {

	private static Connection connection;

	public static Connection getMySqlConnection() throws SQLException, ClassNotFoundException {
		if(connection == null){
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/ead_session3";
			String dbname = "root";
			String dbpassword = "admin";
			Class.forName(driver);
			connection = DriverManager.getConnection(url,dbname,dbpassword);
		}
		return connection;
	}
}