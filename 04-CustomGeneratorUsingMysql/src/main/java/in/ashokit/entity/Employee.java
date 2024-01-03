package in.ashokit.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employee_CustomeGen")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(generator = "emp_id_gen")
	@GenericGenerator(name = "emp_id_gen", strategy = "in.ashokit.generator.EmployeeIdGenerator")
	private String empId;
	private String empName;
	private Double empSal;

}
