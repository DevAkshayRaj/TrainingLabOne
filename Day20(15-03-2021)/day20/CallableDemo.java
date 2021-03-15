package day20;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableDemo {
	public void callProc() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://192.168.0.8:3306/ey?characterEncoding=utf8"
					,"root","rohitsharma45");
			CallableStatement cs=con.prepareCall("{call proc(?,?)}");
			
			int id=10;
			cs.setInt(1, id);
			
			cs.registerOutParameter(2, Types.VARCHAR);
			
			cs.execute();
	
			System.out.println("The user Name for the id :"+id+"   is : "+cs.getString(2));
			con.close();
			cs.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new CallableDemo().callProc();
		
	}

}
