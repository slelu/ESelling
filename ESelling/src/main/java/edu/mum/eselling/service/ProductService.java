package edu.mum.eselling.service;

import java.util.List;

import edu.mum.eselling.domain.Product;
import edu.mum.eselling.domain.ProductSearchCriteria;

public interface ProductService {
	List<Product> findAll();
	public List<Product> findByFilter(ProductSearchCriteria productSearchCriteria);
	
	Product findProduct(long id);
	
}
