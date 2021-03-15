package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo4 {
	public void insertValues() {
		Connection con;
		Statement st;
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://192.168.0.8:3306/ey?characterEncoding=utf8",
			"root","rohitsharma45");
			st=con.createStatement();
//			st.executeUpdate("insert into emp values(1,'akshay','it','associate')");
//			st.executeUpdate("insert into emp values(2,'Raj','it','support')");
//			st.executeUpdate("insert into emp values(3,'ramu','Risk','support')");
			rs=st.executeQuery("select * from emp");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Demo4().insertValues();
	}

}
