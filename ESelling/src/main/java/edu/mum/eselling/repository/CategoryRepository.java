package edu.mum.eselling.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.eselling.domain.Category;

public interface CategoryRepository extends CrudRepository<Category,Long>{

}
