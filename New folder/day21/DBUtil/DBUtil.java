package day21.DBUtil;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
	private static Properties props;
	private static ThreadLocal<Connection> thread = new ThreadLocal<>();

	static {
		try {
			if (props == null) {
				props = new Properties();
			}
			props.load(new FileInputStream("db.properties"));
			Class.forName(props.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection con=thread.get();
		try {
			if(con==null) {
				String url=props.getProperty("url");
				String uname=props.getProperty("uname");
				String upass=props.getProperty("upass");
				con=DriverManager.getConnection(url,uname,upass);
				con.setAutoCommit(false);
				thread.set(con);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	
		return con;
	}
	
	public static void closeConnection() {
		Connection con=thread.get();
		if(con!=null) {
			try {
				con.commit();
				con.close();
				thread.remove();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeConnection(Exception e) {
		Connection con=thread.get();
		if(e==null) {
			closeConnection();
			return;
		}
		if(con!=null) {
			try {
				con.rollback();
				con.commit();
				con.close();
				thread.remove();
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
	}

}
