package springdaodemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DaoDemoImpl {
	private DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void test(){
		jdbcTemplate=new JdbcTemplate(dataSource);
		int r=jdbcTemplate.queryForInt("select count(*) from users");
		System.out.println("Output Rows Count : "+r);
		String uname=jdbcTemplate.queryForObject("select upass from users where id=?",new Object[]{1},String.class);
		System.out.println(uname);
		
		UsersMasterDto obj=jdbcTemplate.queryForObject("select uname,upass,flag from users where id=10",new RowMapper<UsersMasterDto>() {
			@Override
			public UsersMasterDto mapRow(ResultSet rs, int arg1) throws SQLException {
				UsersMasterDto temp=new UsersMasterDto();
				temp.setName(rs.getString("uname"));
				temp.setPwd(rs.getString("upass"));
				temp.setFlag(rs.getInt("flag"));
				return temp;
			}
		});
		System.out.println(obj);
		
		List<UsersMasterDto> objs=jdbcTemplate.query("select uname,upass,flag from users",new RowMapper<UsersMasterDto>() {
			@Override
			public UsersMasterDto mapRow(ResultSet rs, int arg1) throws SQLException {
				UsersMasterDto temp=new UsersMasterDto();
				temp.setName(rs.getString("uname"));
				temp.setPwd(rs.getString("upass"));
				temp.setFlag(rs.getInt("flag"));
				return temp;
			}
		});
		
		System.out.println(objs);
	}
}
