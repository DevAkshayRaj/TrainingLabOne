package databaseutils;

import java.util.Set;

public interface CustomerDetialsDao {
	public int insertCustomerDetials(CustomerDetialsDto obj);
	public int deleteCustomerDetials(long custno);
	public int updateCustomerDetials(CustomerDetialsDto obj);
	public CustomerDetialsDto getCustomerDetials(long custno);
	public Set<CustomerDetialsDto> getCustomerDetialsAll();
	public String getEmail(long id);
}
