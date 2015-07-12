package edu.mum.eselling.controller;



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


@Controller
public class HomeController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/")
	public String welcome(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		
		return "welcome";
	}
	

	@ModelAttribute
	public void init(Model model){
		List<Category> category = categoryService.findAll();
		model.addAttribute("categories", category);
	}

	 @RequestMapping("/welcome")
	    public String defaultAfterLogin(HttpServletRequest request) {
	        if (request.isUserInRole("ROLE_VENDOR")) {
	            return "welcome";
	        }
	        
	        return "CustomerPage";
	    }
	

}

