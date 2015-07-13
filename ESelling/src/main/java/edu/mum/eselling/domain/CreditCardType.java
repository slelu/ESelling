package edu.mum.eselling.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class CreditCardType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8890850582362260490L;
	@Id
	@GeneratedValue
	private Long creditCardTypeId;
	@NotEmpty
	private String creditCardTypeName;
	
	public Long getCreditCardTypeId() {
		return creditCardTypeId;
	}
	public void setCreditCardTypeId(Long creditCardTypeId) {
		this.creditCardTypeId = creditCardTypeId;
	}
	public String getCreditCardTypeName() {
		return creditCardTypeName;
	}
	public void setCreditCardTypeName(String creditCardTypeName) {
		this.creditCardTypeName = creditCardTypeName;
	}
	
	
}
