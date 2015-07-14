package edu.mum.eselling.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.transaction.annotation.Transactional;
@Entity
public class MyFinance implements Serializable {

	private static final long serialVersionUID = -3794885616176050983L;
	
	@Id
	@GeneratedValue
	private long Id;
   
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private  CreditCard creditCard;
    private BigDecimal creditLimit;
    private BigDecimal creditAvailable;
    private BigDecimal creditUsed;
	
	public MyFinance() {
		super();
	}
	
	public MyFinance(CreditCard creditCard){
		this.creditCard = creditCard;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public BigDecimal getCreditAvailable() {
		return creditAvailable;
	}

	public void setCreditAvailable(BigDecimal creditAvailable) {
		this.creditAvailable = creditAvailable;
	}

	public BigDecimal getCreditUsed() {
		return creditUsed;
	}

	public void setCreditUsed(BigDecimal creditUsed) {
		this.creditUsed = creditUsed;
	}
	

}
