package databaseutils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
	//private static Properties ps;
	private static ThreadLocal<Connection> thread=new ThreadLocal<Connection>();

	synchronized public static Connection getConnection(Properties ps) {
		Connection con = null;
		try {
			con = thread.get();
			if (con == null) {
				String url = ps.getProperty("url");
				String uname = ps.getProperty("uname");
				String upass = ps.getProperty("upass");
				con = DriverManager.getConnection(url,uname,upass);
				con.setAutoCommit(false);
				thread.set(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return con;
	}

	synchronized public static void closeConnection() {
		try {
			Connection con = thread.get();
			con.commit();
			con.close();
			thread.remove();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	synchronized public static void closeConnection(Exception ee) {
		if (ee == null) {
			closeConnection();
			return;
		}
		try {
			Connection con = thread.get();
			con.rollback();
			con.commit();
			con.close();
			thread.remove();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
