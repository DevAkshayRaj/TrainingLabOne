package databaseutils;

public interface UsersMasterDao {
	public int addUsers(UsersMasterDto obj);
	public boolean validateUser(UsersMasterDto obj);
	public int getUserStatus(UsersMasterDto obj);
	public int getUserId(UsersMasterDto obj);
	public int updateStatus(int arg,UsersMasterDto obj);
}
