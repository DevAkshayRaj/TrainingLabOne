package databaseutils;

import java.util.List;

public interface CustomerDetailsDao {
	public boolean insertCustomerDetails(CustomerDetailsDto customerdetails);
	public boolean updateCustomerDetails(CustomerDetailsDto customerdetails);
	public boolean deleteCustomerDetails(int customerId);
	public List<CustomerDetailsDto> findCustomerByName(String name);
	public CustomerDetailsDto findCustomerById(int  customerId);
	public List<CustomerDetailsDto> getAllCustomerDetails();
}
