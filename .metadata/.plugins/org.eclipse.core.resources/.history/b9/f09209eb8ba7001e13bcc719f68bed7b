package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	
	@Query(value="call getAllProducts()",nativeQuery = true)
	 List<Product> getProcedure();

}
