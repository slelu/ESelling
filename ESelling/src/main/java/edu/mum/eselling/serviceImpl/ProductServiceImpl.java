package edu.mum.eselling.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.eselling.domain.Product;
import edu.mum.eselling.domain.ProductSearchCriteria;
import edu.mum.eselling.repository.ProductRepository;
import edu.mum.eselling.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return (List<Product>)productRepository.findAll();
	}


	@Override
	public List<Product> findByFilter(ProductSearchCriteria productSearchCriteria) {
		return productRepository.findByFilter(Long.parseLong(productSearchCriteria.getProductCategory()), 
				productSearchCriteria.getProductName());
	}




	@Override
	public Product findProduct(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
