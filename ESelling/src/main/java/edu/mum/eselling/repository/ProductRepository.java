package edu.mum.eselling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import edu.mum.eselling.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	/*@Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
	public List<Product> findProductsByCategory(
			@Param(value = "categoryId") Long categoryId);
	@Query("SELECT p FROM Product p WHERE p.category.id = :categoryId and p.productCondition = :condition and p.unitPrice <= :price")
	public List<Product> findByFilter(
			@Param(value = "categoryId") Long categoryId,
			@Param(value = "condition") String condition,
			@Param(value = "price") double price);
		*/

	
	@Query("SELECT product FROM Vendor v  INNER JOIN v.products product WHERE v.id= :id")
	 public List<Product> getAllProductsByVendorId(@Param(value = "id")Long id);



}