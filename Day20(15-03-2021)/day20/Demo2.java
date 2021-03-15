package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo2 {
	
	public void makeConnection() {
		Connection con;
		Statement st;
		ResultSet rs;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://192.168.0.8:3306/ey?characterEncoding=utf8",
					"root","rohitsharma45");
			st=con.createStatement();
			rs=st.executeQuery("select * from users");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}
			con.close();
			st.close();
			rs.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		new Demo2().makeConnection();
	}
}
