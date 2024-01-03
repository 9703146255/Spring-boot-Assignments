package in.ashokit.service;

import org.springframework.stereotype.Service;

import in.ashokit.repo.CarRepo;
import jakarta.persistence.Id;

@Service
public class CarService {
	
	@Id
	private CarRepo carRepo;
	
	

}
