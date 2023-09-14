package com.cg.onlineshop.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.onlineshop.beans.Product;
import com.cg.onlineshop.daos.ProductDAO;
import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
@Component ("productService")
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDAO productDAO ;

	@Override
	public Product acceptProductDetails(Product product) {
		product = productDAO.save(product);
		return product;
	}

	@Override
	public List<Product> getAllProductDetails() {
		return  productDAO.getAllProductsByStarRatingBetween(2,4);
	}

	@Override
	public Product getProductDetails(int id) throws ProductDetailsNotFoundException {
		/*Product product = productDAO.getProduct(id);
		if(product ==null) 
			throw new ProductDetailsNotFoundException("Product details not found with id "+id);
		return product;*/
		
	/*
	 	Optional<Product> optional = productDAO.getProduct(id);
	 	
	 	
		Supplier<ProductDetailsNotFoundException> exceptionSupplier = () -> new ProductDetailsNotFoundException("Product Details not found for Id  :- "+id);
		
		
		return optional.orElseThrow(exceptionSupplier);
	*/
		 return productDAO.findById(id).orElseThrow(() -> new ProductDetailsNotFoundException("Product Details not found for Id  :- "+id));
		
	}

	@Override
	public void acceptBulkProductsDetails(List<Product> products) {		
		productDAO.saveAllAndFlush(products);
	}

	@Override
	public boolean removeProdcutDetails(int id) {
		 productDAO.deleteById(id);
		 return true;
	}

	@Override
	public int updateProducts(int id, Product product) {
		// TODO Auto-generated method stub
		return productDAO.updateProduct(id, product);
	}




	

}