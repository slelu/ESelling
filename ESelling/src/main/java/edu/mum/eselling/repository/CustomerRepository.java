package edu.mum.eselling.repository;


import org.springframework.data.repository.CrudRepository;


import edu.mum.eselling.domain.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	
/*	@Query("SELECT u FROM User u WHERE u.fname = :name")
	public Customer findCustomerByName(
			@Param(value = "name") String name);*/

}
