package day21;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;
import java.sql.ResultSet;
import java.sql.Statement;

import day21.DBUtil.DBUtil;

public class InvoiceMasterDaoImpl implements InvoiceMasterDao{
	
	@Override
	public int insertInvoice(InvoiceMasterDto invMasterDTO) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtil.getConnection();
			String sql="insert into InvoiceMaster values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, invMasterDTO.getInvno());
			ps.setDate(2, Date.valueOf(invMasterDTO.getInvDate()));
			ps.setLong(3, invMasterDTO.getCustomerno());
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
	public int deleteInvoice(long invno) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtil.getConnection();
			String sql="DELETE FROM InvoiceMaster WHERE invno=? LIMIT 1;";
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
	public int updateInvoice(InvoiceMasterDto invMasterDTO) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtil.getConnection();
			String sql="update InvoiceMaster set invdate=?,custno=? where invno=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setDate(1, Date.valueOf(invMasterDTO.getInvDate()));
			ps.setLong(2, invMasterDTO.getCustomerno());
			ps.setLong(3, invMasterDTO.getInvno());
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
	public InvoiceMasterDto getInvoiceMaster(long invo) {
		Connection con=null;
		InvoiceMasterDto obj=null;
		try {
			obj=new InvoiceMasterDto();
			con=DBUtil.getConnection();
			String sql="select * from InvoiceMaster where invno=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, invo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			Date date = rs.getDate(2);
			//System.out.println(date);
			LocalDate localDate = new java.sql.Date( date.getTime())
                    .toLocalDate();
			//System.out.println(localDate);
			obj.setInvno(rs.getLong(1));
			obj.setInvDate(localDate);
			obj.setCustomerno(rs.getLong("custno"));
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
	public Set<InvoiceMasterDto> getInvoiceMasterAll() {
		Connection con=null;
		InvoiceMasterDto obj=null;
		Set<InvoiceMasterDto> s=null;
		try {
			s=new HashSet<InvoiceMasterDto>();
			obj=new InvoiceMasterDto();
			con=DBUtil.getConnection();
			String sql="select * from InvoiceMaster";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Date date = rs.getDate(2);
				ZoneId defaultZoneId = ZoneId.systemDefault();
				Instant instant = date.toInstant();
				LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
				obj.setInvno(rs.getLong(1));
				obj.setInvDate(localDate);
				obj.setCustomerno(rs.getLong("custno"));
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
	
}
