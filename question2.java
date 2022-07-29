package training;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class question2{

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			
			Driver myDriver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts", "root", "Prequelbot");

			
			stmt = con.prepareStatement("INSERT INTO training VALUES (?, ?);");
			stmt.setInt(1, 2);
			stmt.setInt(2, 3);
			
			stmt.executeUpdate();
			
			stmt.executeUpdate("UPDATE training SET query_content = 2 WHERE query_content = 3;");
			
			stmt.executeUpdate();
			
			stmt = con.prepareStatement("SELECT query_content from training;");
			rs = stmt.executeQuery();
			


			
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
