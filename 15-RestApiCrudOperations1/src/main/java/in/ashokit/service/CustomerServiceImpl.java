package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Customer;
import in.ashokit.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements ICustomerService {

	
	@Autowired
	private CustomerRepo customerRepo;
	
	private static Logger logger=LoggerFactory.getLogger(CustomerServiceImpl.class);

	
	public Customer getCustomer(Integer customerId) {
		Customer orElse = customerRepo.findById(customerId).orElse(new Customer());
		
		logger.info(" CustomerServiceImpl :: getCustomer :: method executed..");
		return orElse;
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> findAll = customerRepo.findAll();
		
		logger.info(" CustomerServiceImpl :: getCustomers :: method executed..");
		
		return findAll;
	}

	@Override
	public Customer insertCustomer(Customer customer) {
		Customer save = customerRepo.save(customer);
		logger.info(" CustomerServiceImpl :: insertCustomer :: method executed..");
		return save;
	}

	@Override
	public Customer updateCustomer(Integer customerId, String customerName) {
		Customer customer = getCustomer(customerId);
		customer.setCutomerName(customerName);
		Customer update = customerRepo.save(customer);
		logger.info(" CustomerServiceImpl :: updateCustomer :: method executed..");
		return update;
	}

	@Override
	public void deleteCustomer(Integer customerId) {

		customerRepo.deleteById(customerId);
		
		logger.info(" CustomerServiceImpl :: deleteCustomer :: method executed..");
		
	}
	
	
	
	
	
	
}
