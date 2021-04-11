package databaseutils;

import java.util.List;

public interface UsersMasterDao {
	public boolean insertUsersDetails(UsersMasterDto UsersDetails);
	public boolean updateUsersDetails(UsersMasterDto UsersDetails);
	public boolean deleteUsersDetails(int userId);
	public List<UsersMasterDto> findCustomerByName(String userName);
	public UsersMasterDto findCustomerById(int  userId);
	public List<UsersMasterDto> getAllUsersDetails();
}
