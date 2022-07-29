package training;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class question1{

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			Driver myDriver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts", "root", "Prequelbot");

			
			stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO training (query_id, query_content)VALUES (1, 1);");
			stmt.executeUpdate("UPDATE training SET query_content = 2 WHERE query_content = 1;");
			rs = stmt.executeQuery("SELECT query_content from training;");
			


			
			while (rs.next())
			{
				System.out.println(rs.getInt(1));
			}
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}

}
