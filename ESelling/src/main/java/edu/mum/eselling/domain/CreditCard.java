package edu.mum.eselling.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CreditCard implements Serializable {

	private static final long serialVersionUID = -3794885616176050983L;
	@Id
	@GeneratedValue
	private long creditCardId;

	private Long creditCardNo;
	private String creditCardType;
	private int expMonth;
	private int expYear;
	private int securityCode;
	private String nameOnCard;
	private BigDecimal creditLimit;

	public CreditCard() {
		creditLimit = new BigDecimal(50_000);
	}
	

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}


	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}


	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public long getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(long creditCardId) {
		this.creditCardId = creditCardId;
	}

	public Long getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(Long creditCardNo) {
		this.creditCardNo = creditCardNo;
	}
	public int getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

}
