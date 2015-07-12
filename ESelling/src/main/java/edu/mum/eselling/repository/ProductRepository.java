package edu.mum.eselling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.eselling.domain.Product;

public interface ProductRepository extends CrudRepository<Product,Long>{
	@Query("SELECT p FROM Product p WHERE p.category.categoryId = :categoryId and p.productName = :productName")
	public List<Product> findByFilter(
			@Param(value = "categoryId") Long categoryId,
			@Param(value = "productName") String productName);
}
