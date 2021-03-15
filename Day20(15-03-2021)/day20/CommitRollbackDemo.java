package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class CommitRollbackDemo {
	public static void main(String[] args) {
		Connection con=null;
		Savepoint sp=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://192.168.0.8:3306/ey?characterEncoding=utf8"
					,"root","rohitsharma45");
			con.setAutoCommit(false);
			Statement st=con.createStatement();
			st.execute("update emp set department='its' where name='akshay'");
			//con.commit();
			sp=con.setSavepoint("first");
			st.execute("update emp set department='risk' where naame='ramu'");
			con.commit();
		}
		catch(Exception e) {
			try {
				e.printStackTrace();
				con.rollback(sp);
				con.commit();
			}
			catch(Exception a) {
				a.printStackTrace();
			}
		}
	}

}
