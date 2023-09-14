package com.cg.onlineshop.daos;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.onlineshop.beans.Product;
public interface ProductDAO extends JpaRepository<Product, Integer>{
	

	//@Query(value = "FROM Product p WHERE p.starRating = :starRating")    JPQL  --->  HibernateJpaDialect  ---> HQL  -----> MySQL5Dialect  ---- SQL
	//List<Product> getAllProducts(@Param("starRating") int starRating);
	
	//List<Product>getAllProductsByStarRating(int starRating);
	
	List<Product> getAllProductsByStarRatingBetween(int starRating1 , int starRating2);
	
	Optional<Product> getProductByName(String name);
	
	@Modifying
    @Query("UPDATE Product c SET c.product = :product WHERE c.id = :product.id")
    int updateProduct(@Param("productId") int productId, @Param("product") Product product);
	
}