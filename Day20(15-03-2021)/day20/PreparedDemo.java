package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PreparedDemo {
	void getRows() {
		PreparedStatement st;
		Connection con;
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://192.168.0.8:3306/ey?characterEncoding=utf8"
					,"root","rohitsharma45");
			String sql="select * from emp where id=?";
			st=con.prepareStatement(sql);
			st.setInt(1, 1);
			rs=st.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			con.close();
			rs.close();
			st.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new PreparedDemo().getRows();
	}

}
