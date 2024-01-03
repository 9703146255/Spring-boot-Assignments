package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Employee;
import in.ashokit.repo.EmployeeRepo;
import jakarta.persistence.Id;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;
	
	public void insertData()
	{
		Employee emp1=new Employee();
		emp1.setEmpName("thirumala");
		emp1.setEmpSal(4000.00);
		
		empRepo.save(emp1);
		
	}

}
