package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Car;

public interface CarRepo extends JpaRepository<Car, Integer>{
	
	

}