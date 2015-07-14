package edu.mum.eselling.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.eselling.domain.Cart;
import edu.mum.eselling.domain.Category;
import edu.mum.eselling.domain.Product;
import edu.mum.eselling.service.ProductService;
import edu.mum.eselling.serviceImpl.ProductServiceImpl;

@Controller
public class CartController {
//	private Logger logger = LoggerFactory.getLogger(CartController.class);
	@Autowired
	private Cart cart;
	@Autowired
	private ProductService productService;

	@RequestMapping("/cart/add/{productId}")
	public String addToCart(@PathVariable("productId") long productId,
			@RequestHeader("referer") String referer, HttpServletRequest request) {
		Product product = this.productService.getProductById(productId);
		if(request.getParameter("productQuantity") != null){
			System.out.println("The value is not null");
		int quantity = Integer.parseInt(request.getParameter("productQuantity"));
		this.cart.addProduct(product, quantity);
		System.out.println("Product size: " + this.cart.getProducts().size());
		System.out.println(this.cart.getGrandTotal().toString());
		// this.logger.("Cart: {}", this.cart);
		}else{
			System.out.println("The value is null");
		}
		return "redirect:" + referer;
	}
	
	
	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("cart", cart);
	}
}
