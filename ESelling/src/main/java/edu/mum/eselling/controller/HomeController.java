package edu.mum.eselling.controller;




import java.security.Principal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.eselling.domain.Category;
import edu.mum.eselling.domain.Product;
import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.ProductService;
import edu.mum.eselling.service.VendorService;


@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	
	@Autowired
	private VendorService vendorService;
	
	



	@RequestMapping("/")

	public String welcome(Model model) {

		return "welcome";
	}


	 @RequestMapping("/welcome")
	    public String defaultAfterLogin(HttpServletRequest request,Model model ,Principal principal ) {
		 String name = principal.getName();
		 System.out.println(name);
			
		   //model.addAttribute("user",userService.getUserByUserName(name));
		  //  model.addAttribute("userproduct", productService.getAllItems(userService.getUserByName(name).getId()));

	        if (request.isUserInRole("ROLE_VENDOR")) {
	        	
	        	//model.addAttribute("user",vendorService.getUserByUserName(name));
	            return "VendorPage";
	        }
	        else if (request.isUserInRole("ROLE_ADMIN")) {
	        		
	            return "welcome";
	        }
	        else{
	        return "CustomerPage";
	        }
	 }
	
	 @ModelAttribute
		public void init(Model model){
		 List<Product> products = productService.findApprovedProducts();
			model.addAttribute("products", products);
			List<Category> category = categoryService.findAll();
			model.addAttribute("categories", category);
		}

}
