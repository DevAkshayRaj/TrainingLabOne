package day21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import day21.DBUtil.DBUtil;

public class ItemDetailsDaoImpl implements ItemDetailsDao{

	@Override
	public int insertItem(ItemDetails obj) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtil.getConnection();
			String sql="insert into ItemDetails values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, obj.getInvno());
			ps.setInt(2,obj.getItemno());
			ps.setInt(3,obj.getQty());
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
	public int deleteItem(long invno) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtil.getConnection();
			String sql="DELETE FROM ItemDetails WHERE invno=? LIMIT 1;";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, invno);
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
	public int updateInvoice(ItemDetails obj) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtil.getConnection();
			String sql="update ItemDetails set itemno=?,qty=? where invno=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, obj.getItemno());
			ps.setInt(2,obj.getQty());
			ps.setLong(3, obj.getInvno());
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
	public ItemDetails getItemDetails(long invno) {
		Connection con=null;
		ItemDetails obj=null;
		try {
			obj=new ItemDetails();
			con=DBUtil.getConnection();
			String sql="select * from ItemDetails where invno=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, invno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			obj.setInvno(invno);
			obj.setItemno(rs.getInt(2));
			obj.setQty(rs.getInt(3));
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
	public Set<ItemDetails> getItemDetailsAll(String invno) {
		Connection con=null;
		ItemDetails obj=null;
		Set<ItemDetails> s=null;
		try {
			s=new HashSet<>();
			obj=new ItemDetails();
			con=DBUtil.getConnection();
			String sql="select * from ItemDetails where invno=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setLong(1, Long.parseLong(invno));
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				obj.setInvno(rs.getLong(1));
				obj.setItemno(rs.getInt(2));
				obj.setQty(rs.getInt(3));
				s.add(obj);
				obj=new ItemDetails();
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
		String temp="8978675456";
		System.out.println(new ItemDetailsDaoImpl().getItemDetailsAll(temp));
	}
	
}
