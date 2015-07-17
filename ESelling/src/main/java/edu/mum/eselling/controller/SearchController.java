package edu.mum.eselling.controller;



import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.eselling.domain.Product;
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
			@RequestParam("categoryId") String categoryId ,Principal principal, HttpSession session) {
		
		List<Product> p= productService.findProductsByCategory(Long.parseLong(categoryId));
		if(p.isEmpty()){
			model.addAttribute("noproduct","true");
		}
		
		if (session.equals(null)){
	 		return "login";
	 	}

     
    	 return "randomSearch" ;
			 
	
		
		/*model.addAttribute("products",p);	
		
		return "searchProducts";
		*/
		
	}
	
	
	
	
	 @ModelAttribute
		public void init(Model model,Principal principal,HttpSession session){
			model.addAttribute("products", productService.findApprovedProducts());
			model.addAttribute("categories", categoryService.findAll());
			
		if(principal != null){			
			 //model.addAttribute("vendorProducts", productService.getAllProductsByVendorId(vendorService.getVendorByUserName(principal.getName()).getId()));	
			 session.setAttribute("admin",adminService.getAdminByUserName(principal.getName()));
			 session.setAttribute("vendor",vendorService.getVendorByUserName(principal.getName()));
			 session.setAttribute("customer",customerService.getCustomerByUserName(principal.getName()));
			}	
			
		}
	}
	
 

