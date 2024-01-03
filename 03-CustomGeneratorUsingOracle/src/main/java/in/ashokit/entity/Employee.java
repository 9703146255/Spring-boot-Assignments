package in.ashokit.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "emp_tbl")
public class Employee {
    @Id
    
    @GeneratedValue(generator = "emp_id_gen")
    @GenericGenerator(name = "emp_id_gen", strategy = "in.ashokit.generator.EmployeeIdGenerator")
	private String empId;
	private String empName;
	private Double empSal;

}
