package edu.mum.eselling.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class CreditCard implements Serializable {

	private static final long serialVersionUID = -3794885616176050983L;
	@Id
	@GeneratedValue
	private long creditCardId;
	@NotEmpty(message="{NotEmpty.CreditCard.number.validation}")
	@Pattern(regexp="[2-9][0-9]{15}", message="{Pattern.CreditCard.number.validation}")
	private Long creditCardNo;
	private CreditCardType creditCardType;
	@NotEmpty(message="{NotEmpty.CreditCard.expireMonth.validation}")
	private Integer expMonth;
	@NotEmpty(message="{NotEmpty.CreditCard.expireYear.validation}")
	private Integer expYear;
	@NotEmpty(message="{NotEmpty.CreditCard.cvv.validation}")
	@NotNull @Range(min=3, max=3, message="{Pattern.CreditCard.cvv.validation}")
	private Integer securityCode;
	@NotEmpty(message="{NotEmpty.CreditCard.name.validation}")
	@Pattern(regexp="[a-zA-z]+ [a-zA-Z]*[.]? [a-zA-Z]+", message="{Pattern.CreditCard.name.validation}")
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

	public CreditCardType getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(CreditCardType creditCardType) {
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
