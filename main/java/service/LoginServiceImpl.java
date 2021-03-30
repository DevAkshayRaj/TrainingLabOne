package service;

import java.io.FileInputStream;
import java.util.Properties;

import databaseutils.CustomerDetialsDaoImpl;
import databaseutils.CustomerDetialsDto;
import databaseutils.UsersMasterDaoImpl;
import databaseutils.UsersMasterDto;

public class LoginServiceImpl implements LoginService, Cloneable {
	private Properties ps;
	private static LoginServiceImpl loginsericeimpl = null;

	private LoginServiceImpl(Properties ps) {
		this.ps = ps;
	}

	synchronized public static LoginServiceImpl getObject(Properties prop) throws Exception {
		if (loginsericeimpl == null) {
			loginsericeimpl = new LoginServiceImpl(prop);
			return loginsericeimpl;
		}
		return loginsericeimpl.getClone();
	}

	synchronized private LoginServiceImpl getClone() throws Exception {
		return (LoginServiceImpl) super.clone();
	}

	@Override
	public boolean checkUser(String uname, String upass) {
		try {
			UsersMasterDto obj = new UsersMasterDto();
			obj.setName(uname);
			obj.setPwd(upass);
			UsersMasterDaoImpl validate = UsersMasterDaoImpl.getObject(this.ps);
			return validate.validateUser(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean checkFLag(String uname, String upass) {
		try {
			UsersMasterDto obj = new UsersMasterDto();
			obj.setName(uname);
			obj.setPwd(upass);
			UsersMasterDaoImpl validate = UsersMasterDaoImpl.getObject(this.ps);
			if (validate.getUserStatus(obj) == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int updateFLag(String uname, String upass, int flag) {
		try {
			UsersMasterDto obj = new UsersMasterDto();
			obj.setName(uname);
			obj.setPwd(upass);
			UsersMasterDaoImpl validate = UsersMasterDaoImpl.getObject(this.ps);
			return validate.updateStatus(flag, obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int registerUser(String uname, String upass, CustomerDetialsDto cdat) {
		try {
			UsersMasterDto obj = new UsersMasterDto();
			obj.setName(uname);
			obj.setPwd(upass);
			UsersMasterDaoImpl validate = UsersMasterDaoImpl.getObject(this.ps);
			CustomerDetialsDaoImpl cdatutil = CustomerDetialsDaoImpl.getObject(this.ps);
			validate.addUsers(obj);
			cdat.setCustno(validate.getUserId(obj));
			return cdatutil.insertCustomerDetials(cdat);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	@Override
	public int getId(String uname, String upass) {
		try {
			UsersMasterDaoImpl validate = UsersMasterDaoImpl.getObject(this.ps);
			UsersMasterDto obj = new UsersMasterDto();
			obj.setName(uname);
			obj.setPwd(upass);
			return validate.getUserId(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	@Override
	public String getEmail(int id) {
		try {
			CustomerDetialsDaoImpl cdatutil = CustomerDetialsDaoImpl.getObject(this.ps);
			return cdatutil.getEmail(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getPhone(int id) {
		try {
			CustomerDetialsDaoImpl cdatutil = CustomerDetialsDaoImpl.getObject(this.ps);
			return cdatutil.getPhone(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//	public static void main(String[] args) throws Exception{
//		Properties p=new Properties();
//		p.load(new FileInputStream("C:\\Workspace\\ShoppingPage\\src\\main\\webapp\\WEB-INF\\db.properties"));
//		LoginServiceImpl ll= LoginServiceImpl.getObject(p);
//		//CustomerDetialsDaoImpl dd= CustomerDetialsDaoImpl.getObject(p);
//		System.out.println(ll.getPhone(10));
//	}
}
