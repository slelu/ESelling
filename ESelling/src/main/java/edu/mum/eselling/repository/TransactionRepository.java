package edu.mum.eselling.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.eselling.domain.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction,Long>{

}
