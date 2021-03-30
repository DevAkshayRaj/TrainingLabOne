package databaseutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;


public class ItemDetailsMasterDaoImpl implements ItemDetailsMasterDao,Cloneable {
	private static Properties ps;
	private static ItemDetailsMasterDaoImpl implobj=null;
	private ItemDetailsMasterDaoImpl(Properties ps) {
		this.ps=ps;
	}
	public static ItemDetailsMasterDaoImpl getObject(Properties p) throws Exception{
		if(implobj==null) {
			implobj=new ItemDetailsMasterDaoImpl(p);
			return implobj;
		}
		return implobj.getClone();
	}
	private ItemDetailsMasterDaoImpl getClone() throws Exception {
		return (ItemDetailsMasterDaoImpl)super.clone();
	}
	@Override
	public int insertItemDetailsMaster(ItemDetailsMasterDto obj) {
		Connection con = null;
		int status = -1;
		try {
			con = DBUtil.getConnection(this.ps);
			String sql = "insert into ItemDetailsMaster values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, obj.getItemno());
			ps.setString(2, obj.getDesc());
			ps.setInt(3, obj.getUnits());
			ps.setInt(4, obj.getPrice());
			ps.setInt(5, obj.getShop());
			ps.setString(6, obj.getUrl());
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
			con = DBUtil.getConnection(this.ps);
			String sql = "update ItemDetailsMaster set desc=?,units=?,price=?,shopid=?,url=? where itemno=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, obj.getDesc());
			ps.setInt(2, obj.getUnits());
			ps.setInt(3, obj.getPrice());
			ps.setInt(4, obj.getShop());
			ps.setString(5, obj.getUrl());
			ps.setInt(6, obj.getItemno());
			
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
			con = DBUtil.getConnection(this.ps);
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
			con = DBUtil.getConnection(this.ps);
			String sql = "select * from ItemDetailsMaster where itemno=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				obj.setItemno(rs.getInt(1));
				obj.setDesc(rs.getString(2));
				obj.setUnits(rs.getInt(3));
				obj.setPrice(rs.getInt(4));
				obj.setShop(rs.getInt(5));
				obj.setUrl(rs.getString(6));
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
	public ArrayList<ItemDetailsMasterDto> getItemDetailsMasterAll(int shop) {
		Connection con = null;
		ItemDetailsMasterDto obj = null;
		ArrayList<ItemDetailsMasterDto> s = null;
		try {
			s = new ArrayList<>();
			obj = new ItemDetailsMasterDto();
			con = DBUtil.getConnection(this.ps);
			String sql = "select * from ItemDetailsMaster where shopid=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, shop);
			ResultSet rs= st.executeQuery();
			while (rs.next()) {
				obj=new ItemDetailsMasterDto();
				obj.setItemno(rs.getInt(1));
				obj.setDesc(rs.getString(2));
				obj.setUnits(rs.getInt(3));
				obj.setPrice(rs.getInt(4));
				obj.setShop(rs.getInt(5));
				obj.setUrl(rs.getString(6));
				//System.out.println(obj);
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
	
//	public static void main(String[] args) {
//		System.out.println(ItemDetailsMasterDaoImpl.getObject(ps).getItemDetailsMasterAll(2));
//	}

}
