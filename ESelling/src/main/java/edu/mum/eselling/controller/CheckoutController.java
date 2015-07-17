package edu.mum.eselling.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.eselling.domain.Cart;
import edu.mum.eselling.domain.ProductOrder;
import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.CustomerService;
import edu.mum.eselling.service.MyFinanceService;
import edu.mum.eselling.service.OrderService;

@Controller
@SessionAttributes(types = { ProductOrder.class })
@RequestMapping("/cart/checkout")
public class CheckoutController {
	@Autowired
	private Cart cart;

	@Autowired
	private OrderService orderService;

	
	@Autowired
	private MyFinanceService myFinanceService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CategoryService categoryService;


	
	


	@RequestMapping(method = RequestMethod.GET)
	public void show(Model model, Principal principal, HttpSession session) {
		if (principal == null){
			System.out.println("Session not set");
		}else{
			
			System.out.println("Session set");
		}
		/*
		 * Account account = (Account)
		 * session.getAttribute(LoginController.ACCOUNT_ATTRIBUTE);
		 */
		ProductOrder productOrder = this.orderService.createOrder(this.cart, principal);
//		session.setAttribute("productOrder", productOrder);
		model.addAttribute("productOrder", productOrder);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, params = "update")
    public String update(@ModelAttribute ProductOrder productOrder) {
        productOrder.updateOrderDetails();
        return "cart/checkout";
    }
	
	@RequestMapping(method = RequestMethod.POST, params = "order")
    public String checkout(SessionStatus status, @Validated @ModelAttribute ProductOrder productOrder, BindingResult errors) {
        if (errors.hasErrors()) {
            return "cart/checkout";
        } else {
            this.orderService.store(productOrder);
            status.setComplete(); //remove order from session
            this.cart.clear(); // clear the cart
            return "redirect:/welcome";
        }
    }
	
	@RequestMapping(method = RequestMethod.POST, params = "cancel")
    public String cancel(SessionStatus status, @ModelAttribute ProductOrder productOrder, HttpSession session) {
		status.setComplete(); //remove order from session
        this.cart.clear(); // clear the cart
        return "redirect:/welcome";
    }
	
	
	@ModelAttribute
	public void init(Model model,Principal principal) {
//		
		model.addAttribute("customer",customerService.getCustomerByUserName(principal.getName()));
		 model.addAttribute("categories", categoryService.findAll());
	}
}
