package edu.mum.eselling.service;

import java.util.List;

import edu.mum.eselling.domain.Product;



public interface ProductService {
	
	public List<Product> findAll();
	/*public Product find(Long productId);
	public List<Product> findItemsByCategory(Long categoryId);*/
	public Product  save(Product product);
	
	public List<Product> getAllProducts(Long id);
	//public List<Product> findByFilter(SearchDto searchDto);
	
	public Product getProductById(Long productId);
}
