package day21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import day21.DBUtil.DBUtil;

public class ItemDetailsMasterDaoImpl implements ItemDetailsMasterDao {

	@Override
	public int insertItemDetailsMaster(ItemDetailsMasterDto obj) {
		Connection con = null;
		int status = -1;
		try {
			con = DBUtil.getConnection();
			String sql = "insert into ItemDetailsMaster values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, obj.getItemno());
			ps.setString(2, obj.getDesc());
			ps.setInt(3, obj.getUnits());
			ps.setInt(4, obj.getPrice());
			status = ps.executeUpdate();
			DBUtil.closeConnection();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.closeConnection(e);
		}
		return status;
	}

	@Override
	public int updateItemDetailsMaster(ItemDetailsMasterDto obj) {
		Connection con = null;
		int status = -1;
		try {
			con = DBUtil.getConnection();
			String sql = "update ItemDetailsMaster set desc=?,units=?,price=? where itemno=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, obj.getDesc());
			ps.setInt(2, obj.getUnits());
			ps.setInt(3, obj.getPrice());
			ps.setInt(4, obj.getItemno());
			status = ps.executeUpdate();
			DBUtil.closeConnection();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.closeConnection(e);
		}

		return status;
	}

	@Override
	public int deleteItemDetailsMaster(int itemno) {
		Connection con = null;
		int status = -1;
		try {
			con = DBUtil.getConnection();
			String sql = "DELETE FROM ItemDetailsMaster WHERE itemno=? LIMIT 1;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemno);
			status = ps.executeUpdate();
			DBUtil.closeConnection();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.closeConnection(e);
		}

		return status;
	}

	@Override
	public ItemDetailsMasterDto getItemDetailsMaster(int itemno) {
		Connection con = null;
		ItemDetailsMasterDto obj = null;
		try {
			obj = new ItemDetailsMasterDto();
			con = DBUtil.getConnection();
			String sql = "select * from ItemDetailsMaster where itemno=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				obj.setItemno(rs.getInt(1));
				obj.setDesc(rs.getString(2));
				obj.setUnits(rs.getInt(3));
				obj.setPrice(rs.getInt(4));
			}
			DBUtil.closeConnection();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.closeConnection(e);
			return null;
		}
		return obj;
	}

	@Override
	public Set<ItemDetailsMasterDto> getItemDetailsMasterAll() {
		Connection con = null;
		ItemDetailsMasterDto obj = null;
		Set<ItemDetailsMasterDto> s = null;
		try {
			s = new HashSet<>();
			obj = new ItemDetailsMasterDto();
			con = DBUtil.getConnection();
			String sql = "select * from ItemDetailsMaster";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				obj.setItemno(rs.getInt(1));
				obj.setDesc(rs.getString(2));
				obj.setUnits(rs.getInt(3));
				obj.setPrice(rs.getInt(4));
				s.add(obj);
			}

			DBUtil.closeConnection();
			st.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.closeConnection(e);
			return null;
		}

		return s;
	}
	
	public static void main(String[] args) {
		System.out.println(new ItemDetailsMasterDaoImpl().getItemDetailsMasterAll());
	}

}
