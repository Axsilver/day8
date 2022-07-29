package training;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class question3{

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			
			Driver myDriver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts", "root", "Prequelbot");

			
			CallableStatement cstmt = con.prepareCall("{call trainingProcedure()};");
			
			cstmt.execute();
			
			System.out.println("Success");
			
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}

}
