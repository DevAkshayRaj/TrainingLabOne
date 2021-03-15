package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo3 {
	
	void createTable() {
		Connection con;
		ResultSet rs;
		Statement st;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://192.168.0.8:3306/ey?characterEncoding=utf8",
					"root","rohitsharma45");
			st=con.createStatement();
			int i=st.executeUpdate("create table employee(id int(5),name varchar(30),department varchar(10),designation varchar(20))");
	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Demo3().createTable();
	}
}
