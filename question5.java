package training;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class question5{

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			
			Driver myDriver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts", "root", "Prequelbot");

			con.setAutoCommit(false);
			
			
			stmt = con.prepareStatement("INSERT INTO training VALUES (?, ?);");
			stmt.setInt(1, 2);
			stmt.setInt(2, 3);
			
			stmt.executeUpdate();
			
			stmt = con.prepareStatement("INSERT INTO training VALUES (?, ?);");
			stmt.setInt(1, 2);
			stmt.setInt(2, 3);
			
			stmt.executeUpdate();
			
			con.commit();
			

			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}

}
