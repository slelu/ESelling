package edu.mum.eselling.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class ProductOrder implements Serializable {

	private static final long serialVersionUID = -3794885616176050983L;
	@Id
	@GeneratedValue
	private long orderId;
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Address shippingAddress;
	private BigDecimal orderPrice;
	@Transient
	private Cart cart;


	
	
	/*private Map<Product, Integer> productsInOrder;*/
	


	public ProductOrder() {
		super();
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
