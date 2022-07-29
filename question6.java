package training;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class question6{

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			Driver myDriver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts", "root", "Prequelbot");

			stmt = con.createStatement();
			
			stmt.addBatch("INSERT INTO training VALUES (10, 10);");
			stmt.addBatch("INSERT INTO training VALUES (11, 11);");
			stmt.addBatch("INSERT INTO training VALUES (12, 12);");

			stmt.executeBatch();
			
			
			pstmt = con.prepareCall("INSERT INTO training VALUES (?, ?);");
			
			pstmt.setInt(1, 13);
			pstmt.setInt(2, 13);
			pstmt.addBatch();
			
			pstmt.setInt(1, 14);
			pstmt.setInt(2, 14);
			pstmt.addBatch();
			
			pstmt.setInt(1, 15);
			pstmt.setInt(2, 15);
			pstmt.addBatch();
			
			pstmt.executeBatch();
			
			

			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}

}
