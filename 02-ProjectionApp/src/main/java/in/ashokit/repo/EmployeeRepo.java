package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	@Query("insert into Employee(empName,empSal) values (:name,:sal)")
	public void insertEmp(String  name,Double sal);
	
	
	//Custom query with projection
	
	@Query("select empName, empSal From Employee")
	public List<Object[]> getEmpNameAndSal();

}
