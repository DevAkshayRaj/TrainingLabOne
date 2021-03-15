package day20;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DButil {
	private static Properties props;
	private static ThreadLocal<Connection> thread;
	static {
		try{
			thread=new ThreadLocal<>();
			props=new Properties();
			props.load(new FileInputStream("db.properties"));
			Class.forName(props.getProperty("driver"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	synchronized public static Connection getConnectionObject() {
		Connection con=null;
		try {
			con=thread.get();
			if(con==null) {
				con=DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("uname"),props.getProperty("upass"));
				con.setAutoCommit(false);
				thread.set(con);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return con;
	}
	synchronized public static void closeConnection() {
		try {
			Connection con=thread.get();
			con.commit();
			con.close();
			thread.remove();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	synchronized public static void closeConnection(Exception e) {
		Connection con=null;
		try {
			con=thread.get();
			if(con!=null) {
				con.rollback();
				con.commit();
				con.close();
				thread.remove();
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
		}
	}
}
