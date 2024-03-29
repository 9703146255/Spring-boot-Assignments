package in.ashokit.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Product;
import in.ashokit.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo pRepo;

	public void insertImage() throws IOException {

		File f = new File("D:\\ASHOKIT\\20-AllAssignments\\05-InsertImageIntoTable\\src\\main\\java\\1.png");

		FileInputStream fos = new FileInputStream(f);

		Product p1 = new Product();
		p1.setProductName("laptop");
		p1.setProductPrice(5000.00);
		p1.setPhoto(fos.readAllBytes());

		pRepo.save(p1);

	}

}
