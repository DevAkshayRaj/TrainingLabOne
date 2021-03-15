package day20;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestUtil {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		
		es.execute(()->{
			try {
				Connection con=DButil.getConnectionObject();
				System.out.println(con);
				Connection con2=DButil.getConnectionObject();
				System.out.println(con2);
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from emp");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				}
				DButil.closeConnection();
				}
				catch(Exception e) {
					DButil.closeConnection(e);
					e.printStackTrace();
				}
		});
		
		es.execute(()->{
			try {
				
				Connection con2=DButil.getConnectionObject();
				System.out.println(con2);
				DButil.closeConnection();
				Connection con=DButil.getConnectionObject();
				System.out.println(con);
				Connection con3=DButil.getConnectionObject();
				System.out.println(con3);
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from emp");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				}
				DButil.closeConnection();
				}
				catch(Exception e) {
					DButil.closeConnection(e);
					e.printStackTrace();
				}
		});
		
		es.shutdown();
	}
}
