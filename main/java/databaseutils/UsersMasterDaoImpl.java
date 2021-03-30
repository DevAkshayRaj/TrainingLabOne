package databaseutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class UsersMasterDaoImpl implements UsersMasterDao,Cloneable {
	private static final String addSql="INSERT INTO users(uname,upass,flag) VALUES(?,?,?)";
	private static final String validateSql="SELECT flag FROM users WHERE uname=? and upass=?";
	private static final String validateSqlid="SELECT id FROM users WHERE uname=? and upass=?";
	private static final String updateSql="update users set flag=? where uname=? and upass=?";
	private Properties prop;
	private static UsersMasterDaoImpl userdaoimplobj=null;
	private UsersMasterDaoImpl(Properties prop) {
		this.prop=prop;
	}
	synchronized public static UsersMasterDaoImpl getObject(Properties ps) throws Exception{
		if(userdaoimplobj==null) {
			userdaoimplobj=new UsersMasterDaoImpl(ps);
			return userdaoimplobj;
		}
		return userdaoimplobj.getClone();
	}
	synchronized private UsersMasterDaoImpl getClone() throws Exception{
		return (UsersMasterDaoImpl)super.clone();
	}
	@Override
	public int addUsers(UsersMasterDto obj) {
		int status=-1;
		try {
			Connection con=DBUtil.getConnection(prop);
			PreparedStatement ps=con.prepareStatement(addSql);
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getPwd());
			ps.setInt(3, 0);
			status=ps.executeUpdate();
			DBUtil.closeConnection();
		}catch(Exception e) {
			DBUtil.closeConnection(e);
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public int updateStatus(int arg,UsersMasterDto obj) {
		int status=-1;
		try {
			Connection con=DBUtil.getConnection(prop);
			PreparedStatement ps=con.prepareStatement(updateSql);
			ps.setInt(1, arg);
			ps.setString(2, obj.getName());
			ps.setString(3, obj.getPwd());
			status=ps.executeUpdate();
			DBUtil.closeConnection();
		}catch(Exception e) {
			DBUtil.closeConnection(e);
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public boolean validateUser(UsersMasterDto obj) {
		boolean status=false;
		try {
			System.out.println("USER MASTER :::::::::::::"+this.prop.getProperty("driver"));
			Connection con=DBUtil.getConnection(this.prop);
			PreparedStatement ps=con.prepareStatement(validateSql);
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getPwd());
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			DBUtil.closeConnection();
		}catch(Exception e) {
			DBUtil.closeConnection(e);
			e.printStackTrace();
		}
		return status;
	}
	
	
	@Override
	public int getUserId(UsersMasterDto obj) {
		int status=-1;
		try {
			Connection con=DBUtil.getConnection(prop);
			PreparedStatement ps=con.prepareStatement(validateSqlid);
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getPwd());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				status=rs.getInt("id");
			}
			DBUtil.closeConnection();
		}catch(Exception e) {
			DBUtil.closeConnection(e);
			e.printStackTrace();
		}
		return status;	
		}
	
	@Override
	public int getUserStatus(UsersMasterDto obj) {
		int status=-1;
		try {
			Connection con=DBUtil.getConnection(prop);
			PreparedStatement ps=con.prepareStatement(validateSql);
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getPwd());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				status=rs.getInt("flag");
			}
			DBUtil.closeConnection();
		}catch(Exception e) {
			DBUtil.closeConnection(e);
			e.printStackTrace();
		}
		return status;	
		}
//	public static void main(String[] args) {
//		
//		UsersMasterDto obj=new UsersMasterDto();
//		obj.setName("akshayraj");
//		obj.setPwd("akshay123");
//		System.out.println(new UsersMasterDaoImpl().updateStatus(0,obj));
//	}

}
