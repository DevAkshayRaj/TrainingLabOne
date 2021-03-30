package service;

import databaseutils.CustomerDetialsDto;

public interface LoginService {
	public boolean checkUser(String uname,String upass);
	public boolean checkFLag(String uname,String upass);
	public int updateFLag(String uname,String upass,int flag);
	public int getId(String uname,String upass);
	public int registerUser(String uname,String upass,CustomerDetialsDto obj);
	public String getEmail(int a);
}
