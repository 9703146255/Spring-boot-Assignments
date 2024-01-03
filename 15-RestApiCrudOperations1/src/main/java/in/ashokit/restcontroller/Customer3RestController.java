package in.ashokit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Customer;
import in.ashokit.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer3")
public class Customer3RestController {
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@DeleteMapping(value = "/customer/{customerId}")
	public Customer getCustomer(@PathVariable Integer customerId) {
		
		Customer customer = customerService.getCustomer(customerId);
		return customer;
	}

	
	@DeleteMapping(value = "/customer/all")
	public List<Customer> getCustomers() {
		List<Customer> customers = customerService.getCustomers();
		
		return customers;
	}

	@DeleteMapping(value = "/customer/insert")
	public Customer insertCustomer(@RequestBody Customer customer) {
		
		Customer insertCustomer = customerService.insertCustomer(customer);
	
		return insertCustomer;
	}

	@DeleteMapping(value = "/customer/{customerId}/{customerName}")
	public Customer updateCustomer(@PathVariable Integer customerId,@PathVariable String customerName) {
	
		Customer updateCustomer = customerService.updateCustomer(customerId, customerName);
		return updateCustomer;
	}

	@DeleteMapping(value = "/customerd/{customerId}")
	public void deleteCustomer(@PathVariable  Integer customerId) {

		customerService.deleteCustomer(customerId);
		
	}
	
	

}
