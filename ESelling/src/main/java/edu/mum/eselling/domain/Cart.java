package edu.mum.eselling.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = -6212595579666071819L;
	@Id
	@GeneratedValue
	private Long cartId;
	@ElementCollection
	private Map<String, CartItem> cartItems;
	private BigDecimal grandTotal;

	public Cart() {
		super();
	}

	public Long getCartId() {
		return cartId;
	}
	
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

}
