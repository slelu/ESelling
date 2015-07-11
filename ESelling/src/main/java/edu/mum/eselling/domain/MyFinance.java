package edu.mum.eselling.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class MyFinance implements Serializable {

	private static final long serialVersionUID = -3794885616176050983L;
	
	@Id
	@GeneratedValue
	private long Id;
   
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private  CreditCard creditCard;
    private BigDecimal creditBalance;
    private BigDecimal creditAvailable;
    private BigDecimal creditUsed;
	
	public MyFinance() {
		super();
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public BigDecimal getCreditbalance() {
		return creditBalance;
	}

	public void setCreditbalance(BigDecimal creditBalance) {
		this.creditBalance = creditBalance;
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
