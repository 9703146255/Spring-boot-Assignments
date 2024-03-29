package in.ashokit;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.service.ProductService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		ProductService bean = run.getBean(ProductService.class);
		bean.insertImage();
	}

}
