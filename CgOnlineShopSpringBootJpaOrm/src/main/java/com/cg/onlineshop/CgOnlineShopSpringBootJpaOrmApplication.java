package com.cg.onlineshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cg.onlineshop.beans.Product;
import com.cg.onlineshop.services.ProductService;

@SpringBootApplication

@ComponentScan(basePackages= "com.cg.onlineshop")
@EnableJpaRepositories(basePackages= "com.cg.onlineshop.daos")
public class CgOnlineShopSpringBootJpaOrmApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CgOnlineShopSpringBootJpaOrmApplication.class, args);
		ProductService productService = context.getBean(ProductService.class,"productService");
		System.out.println("Inserted Product :- "+productService.acceptProductDetails(new Product(15000, 4, "Good Product", "ThnikPad")));
		System.out.println("Inserted Product :- "+productService.acceptProductDetails(new Product(35000, 3, "Good Product", "Mobile")));
		System.out.println("Inserted Product :- "+productService.acceptProductDetails(new Product(15000, 4, "Good Product", "LapTop")));
			
		System.out.println("===============================");
		System.out.println("Product Details with 4 ratining");
		for (Product product : productService.getAllProductDetails()) {
			System.out.println("== "+product);
			
			System.out.println(productService.updateProducts(2, new Product(15000, 4, "Good Product", "LapTop")));
		}
	}
}
