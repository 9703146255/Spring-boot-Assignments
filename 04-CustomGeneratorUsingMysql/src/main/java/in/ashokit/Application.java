package in.ashokit;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Employee;
import in.ashokit.repo.EmployeeRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
	
		EmployeeRepo bean = run.getBean(EmployeeRepo.class);
		
		Employee emp1=new Employee();
		emp1.setEmpName("kiran");
		emp1.setEmpSal(50000.00);
		Employee emp2=new Employee();
		emp2.setEmpName("charan");
		emp2.setEmpSal(50000.00);
		Employee emp3=new Employee();
		emp3.setEmpName("vijay");
		emp3.setEmpSal(50000.00);
		
		
		List<Employee> asList = Arrays.asList(emp1,emp2,emp3);
		bean.saveAll(asList);
		
		
		
	}

}
