package com.cg.onlineshop.services;
import java.util.List;

import com.cg.onlineshop.beans.Product;
import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
public interface ProductService {
	public Product acceptProductDetails(Product product);
	public List<Product> getAllProductDetails();
	public Product getProductDetails(int id)throws ProductDetailsNotFoundException;
	public void acceptBulkProductsDetails(List<Product> products);
	public boolean removeProdcutDetails(int id);
	public int updateProducts(int id,Product product);
}