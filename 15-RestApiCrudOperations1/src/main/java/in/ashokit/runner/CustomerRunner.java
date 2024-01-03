package in.ashokit.runner;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.Customer;
import in.ashokit.repo.CustomerRepo;
@Component
public class CustomerRunner implements ApplicationRunner {

	@Autowired
	private CustomerRepo crepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		insertCustomers();
	}

	public void insertCustomers() {
		List<Customer> customer = new LinkedList<>();

		customer.add(new Customer("thirumalesh", "thiru@gmail.com"));
		customer.add(new Customer("charan", "charan@gmail.com"));
		customer.add(new Customer("vijay", "vijay@gmail.com"));
		customer.add(new Customer("shiva", "shiva@gmail.com"));
		customer.add(new Customer("chiru", "chiru@gmail.com"));

		List<Customer> saveAll = crepo.saveAll(customer);
		System.out.println("customers are inserted....");

		saveAll.forEach(s -> System.out.println(s));

	}

}
