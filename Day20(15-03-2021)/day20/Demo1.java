package day20;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;


public class Demo1 {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://192.168.0.8:3306/ey?characterEncoding=utf8","root","rohitsharma45");
			DatabaseMetaData dbmd=conn.getMetaData();
			System.out.println(dbmd.getURL());
			System.out.println(dbmd.getDefaultTransactionIsolation());
			System.out.println(dbmd.getSQLKeywords());
			System.out.println(dbmd.supportsSelectForUpdate());
			System.out.println(dbmd.supportsTransactions());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
