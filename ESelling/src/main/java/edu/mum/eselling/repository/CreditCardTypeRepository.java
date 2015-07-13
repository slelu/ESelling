package edu.mum.eselling.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.eselling.domain.CreditCardType;

@Repository
public interface CreditCardTypeRepository extends CrudRepository<CreditCardType, Long>{
	
}
