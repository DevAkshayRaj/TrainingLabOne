package day21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import day21.DBUtil.DBUtil;

public class CustomerDetialsDaoImpl implements CustomerDetialsDao{

	@Override
	public int insertCustomerDetials(CustomerDetialsDto obj) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtil.getConnection();
			String sql="insert into CustomerDetails values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, obj.getCustno());
			ps.setString(2, obj.getName());
			ps.setString(3, obj.getAddress());
			ps.setString(4, obj.getEmail());
			ps.setString(5, obj.getPhone());
			status=ps.executeUpdate();
			DBUtil.closeConnection();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			DBUtil.closeConnection(e);
		}
		return status;
	}

	@Override
	public int deleteCustomerDetials(long custno) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtil.getConnection();
			String sql="DELETE FROM CustomerDetails WHERE custno=? LIMIT 1;";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, custno);
			status=ps.executeUpdate();
			DBUtil.closeConnection();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			DBUtil.closeConnection(e);
		}
		return status;
	}

	@Override
	public int updateCustomerDetials(CustomerDetialsDto obj) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtil.getConnection();
			String sql="update CustomerDetails set name=?,address=?,email=?,phone=? where custno=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getAddress());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getPhone());
			ps.setLong(5, obj.getCustno());
			status=ps.executeUpdate();
			DBUtil.closeConnection();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			DBUtil.closeConnection(e);
		}
		return status;
	}

	@Override
	public CustomerDetialsDto getCustomerDetials(long custno) {
		Connection con=null;
		CustomerDetialsDto obj=null;
		try {
			obj=new CustomerDetialsDto();
			con=DBUtil.getConnection();
									  //CustomerDetails
			String sql="select * from CustomerDetails where custno=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, custno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				obj.setCustno(rs.getLong(1));
				obj.setName(rs.getString(2));
				obj.setAddress(rs.getString(3));
				obj.setEmail(rs.getString(4));
				obj.setPhone(rs.getString(5));
			}
			DBUtil.closeConnection();
			ps.close();
			rs.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			DBUtil.closeConnection(e);
			return null;
		}
		return obj;
	}

	@Override
	public Set<CustomerDetialsDto> getCustomerDetialsAll() {
		Connection con=null;
		CustomerDetialsDto obj=null;
		Set<CustomerDetialsDto> s=null;
		try {
			s=new HashSet<>();
			obj=new CustomerDetialsDto();
			con=DBUtil.getConnection();
			String sql="select * from CustomerDetails";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				obj.setCustno(rs.getLong(1));
				obj.setName(rs.getString(2));
				obj.setAddress(rs.getString(3));
				obj.setEmail(rs.getString(4));
				obj.setPhone(rs.getString(5));
				s.add(obj);
			}

			DBUtil.closeConnection();
			st.close();
			rs.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			DBUtil.closeConnection(e);
			return null;
		}
		
		return s;
	}
	public static void main(String[] args) {
		System.out.println(new CustomerDetialsDaoImpl().getCustomerDetials(132323232));
	}
}
