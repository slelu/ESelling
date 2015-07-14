package edu.mum.eselling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.eselling.domain.Cart;
import edu.mum.eselling.domain.ProductOrder;
import edu.mum.eselling.service.OrderService;

@Controller
@SessionAttributes(types = { ProductOrder.class })
@RequestMapping("/cart/checkout")
public class CheckoutController {
	@Autowired
	private Cart cart;

	@Autowired
	private OrderService orderService;

	@RequestMapping(method = RequestMethod.GET)
	public void show(Model model) {
		/*
		 * Account account = (Account)
		 * session.getAttribute(LoginController.ACCOUNT_ATTRIBUTE);
		 */
		ProductOrder order = this.orderService.createOrder(this.cart);
		model.addAttribute("order", order);
	}
}
