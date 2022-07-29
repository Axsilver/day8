package training;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class question4{

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			
			Driver myDriver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts", "root", "Prequelbot");

			DatabaseMetaData dbData = con.getMetaData();
			
			System.out.println(dbData.getDatabaseMajorVersion());
			System.out.println(dbData.getDatabaseProductName());
			System.out.println(dbData.getDriverName());
			System.out.println(dbData.getSchemas());
			
			
			stmt = con.prepareStatement("SELECT query_content from training;");
			
			rs = stmt.executeQuery();			
			
			
			while(rs.next())
			{
				ResultSetMetaData rsData = rs.getMetaData();				
				System.out.println(rsData.getColumnCount());
			}
			
			
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}

}
