package edu.mum.eselling.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.eselling.domain.MyFinance;

@Repository
public interface MyFinanceRepository extends CrudRepository<MyFinance, Long> {

}

