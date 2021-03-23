package validate.mysql;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
	//private static Properties ps;
	private static ThreadLocal<Connection> thread;
	static {
		try {
			thread = new ThreadLocal<>();
			//ps = new Properties();
			//ps.load(new FileInputStream("db.properties"));
			Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	synchronized public static Connection getConnection() {
		Connection con = null;
		try {
			con = thread.get();
			if (con == null) {
//				String url = ps.getProperty("url");
//				String uname = ps.getProperty("uname");
//				String upass = ps.getProperty("upass");
				con = DriverManager.getConnection("jdbc:mysql://192.168.0.8:3306/ey?characterEncoding=utf8", "root","rohitsharma45");
				con.setAutoCommit(false);
				thread.set(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return con;
	}

	public static void closeConnection() {
		try {
			Connection con = thread.get();
			con.commit();
			con.close();
			thread.remove();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void closeConnection(Exception ee) {
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
