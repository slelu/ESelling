package edu.mum.eselling.service;

import edu.mum.eselling.domain.Cart;
import edu.mum.eselling.domain.ProductOrder;

public interface OrderService {
	
	public ProductOrder createOrder(Cart cart);
}
