package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Customer;

public interface ICustomerService {
	
	public Customer getCustomer(Integer customerId);
	public List<Customer> getCustomers();
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Integer customerId,String customerName);
	public void deleteCustomer(Integer customerId);

}
