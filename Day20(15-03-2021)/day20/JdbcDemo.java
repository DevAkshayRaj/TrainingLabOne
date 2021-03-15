package day20;

import java.sql.*;

public class JdbcDemo {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.8:3306/test?characterEncoding=utf8",
					"root", "rohitsharma45"); 
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from myusers");
			while (rs.next())
				System.out.println(rs.getString(1) + "  " + rs.getString(2));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}