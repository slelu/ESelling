package edu.mum.eselling.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.eselling.domain.Product;

import edu.mum.eselling.repository.ProductRepository;
import edu.mum.eselling.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	/*public List<Product> findByFilter(SearchDto filterElements) {
				
		return itemRepository.findByFilter(
				Long.parseLong(filterElements.getCategory()),
				filterElements.getItemCondition(),
				Double.parseDouble(filterElements.getPrice()));
	}*/

	public List<Product> findApprovedProducts() {
		return (List<Product>) productRepository.findApprovedProducts();
	}
	
	public List<Product> findPendingProducts() {
		return (List<Product>) productRepository.findPendingProducts();
	}
	
	public Product getProductById(Long productId){
		return  productRepository.findOne(productId);
	}
/*	public Product find(Long productId) {
		return ProductRepository.findOne(productId);
	}

	public List<Product> findItemsByCategory(Long categoryId) {
		return (List<Product>) itemRepository.findItemsByCategory(categoryId);
}*/

	public Product save(Product product) {
		return productRepository.save(product);

	}
	
   public List<Product> getAllProducts(Long vendorid){
		
		return productRepository.getAllProductsByVendorId(vendorid);
	}



}
