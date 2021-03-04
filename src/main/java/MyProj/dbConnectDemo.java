package MyProj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

public class dbConnectDemo {

	public static void main(String[] args) {
		try {
			String dbUrl = "jdbc:mysql://localhost:3306/java_project";
			Map<String, String> env = System.getenv();
			String user = env.get("MYSQL_USER");
			String password = env.get("MYSQL_PASS");
			// Get Connection
			Connection myConn = DriverManager.getConnection(dbUrl, user, password);
			// Create Statement
			Statement myStatement = myConn.createStatement();
			// Execute Query
			ResultSet myResultSet = myStatement.executeQuery("Select * from students");
			
			// Process the result set
			while(myResultSet.next()) {
				System.out.println("Student Name: " + myResultSet.getString("firstname") +
						" " + myResultSet.getString("lastname"));
			}
		} 
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}

