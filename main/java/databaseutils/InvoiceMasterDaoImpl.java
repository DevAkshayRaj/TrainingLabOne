package databaseutils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
//import java.time.Instant;
import java.time.LocalDate;
//import java.time.ZoneId;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import java.sql.ResultSet;
import java.sql.Statement;

public class InvoiceMasterDaoImpl implements InvoiceMasterDao,Cloneable{
	private static Properties prop;
	private static InvoiceMasterDaoImpl cdetails;
	private InvoiceMasterDaoImpl(Properties pa) throws Exception{
		this.prop=pa;
	}
	public static InvoiceMasterDaoImpl getObject(Properties p)throws Exception {
		if(cdetails==null) {
			cdetails=new InvoiceMasterDaoImpl(p);
			return cdetails;
		}
		return (InvoiceMasterDaoImpl)cdetails.getClone(); 
	}
	private InvoiceMasterDaoImpl getClone() throws Exception{
		return (InvoiceMasterDaoImpl)super.clone();
	}
	@Override
	public int insertInvoice(InvoiceMasterDto invMasterDTO) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtil.getConnection(this.prop);
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
			con=DBUtil.getConnection(this.prop);
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
			con=DBUtil.getConnection(this.prop);
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
			con=DBUtil.getConnection(this.prop);
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
			con=DBUtil.getConnection(this.prop);
			String sql="select * from InvoiceMaster";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				obj=new InvoiceMasterDto();
				Date date = rs.getDate(2);
				//ZoneId defaultZoneId = ZoneId.systemDefault();
				//Instant instant = date.toInstant();
				//LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
				LocalDate localDate =LocalDate.parse(date.toString());
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
	@Override
	public int getInvoiceNumber() {
		Connection con=null;
		int invn=0;
		try {
			con=DBUtil.getConnection(this.prop);
			String sql="select invno from invoicemaster order by invno desc limit 1;";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			rs.next();
			invn=(int)rs.getLong(1);
			DBUtil.closeConnection();
			return invn;
		}
		catch(Exception e) {
			DBUtil.closeConnection(e);
			e.printStackTrace();
		}
		return invn;
	}
	
//	public static void main(String[] args) {
//		System.out.println(
//		new InvoiceMasterDaoImpl().getInvoiceMasterAll());
//	}
}
