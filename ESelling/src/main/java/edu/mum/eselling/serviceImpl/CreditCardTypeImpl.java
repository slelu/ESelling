package edu.mum.eselling.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.eselling.domain.CreditCardType;
import edu.mum.eselling.repository.CreditCardTypeRepository;
import edu.mum.eselling.service.CreditCardTypeService;

@Transactional
@Service
public class CreditCardTypeImpl implements CreditCardTypeService{
	
	@Autowired
	private CreditCardTypeRepository creditCardTypeRepository;

	@Override
	public List<CreditCardType> findAll() {
		return (List<CreditCardType>)creditCardTypeRepository.findAll();
	}
	
}
