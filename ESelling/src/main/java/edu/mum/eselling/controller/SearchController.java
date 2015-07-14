package edu.mum.eselling.controller;



import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.eselling.service.AdminService;
import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.CustomerService;
import edu.mum.eselling.service.ProductService;
import edu.mum.eselling.service.VendorService;


 

@Controller
public class SearchController {
	
	
	@Autowired
	ProductService productService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	VendorService vendorService;
	
	@Autowired
	CategoryService categoryService;
	
	

	@RequestMapping(value = "/productsearch")
	public String getItemsByCategory(Model model,
			@RequestParam("categoryId") String categoryId) {
		
		model.addAttribute("products",
				productService.findProductsByCategory(Long.parseLong(categoryId)));
		
		return "searchProducts";
	}
	
	
	 @ModelAttribute
		public void init(Model model,Principal principal){
			model.addAttribute("products", productService.findApprovedProducts());
			model.addAttribute("categories", categoryService.findAll());
			
			if(principal != null){
				
			 model.addAttribute("admin",adminService.getAdminByUserName(principal.getName()));
			 model.addAttribute("vendor",vendorService.getVendorByUserName(principal.getName()));
			 model.addAttribute("Customer",customerService.getCustomerByUserName(principal.getName()));
			}	
			
		}
	}
	
 

