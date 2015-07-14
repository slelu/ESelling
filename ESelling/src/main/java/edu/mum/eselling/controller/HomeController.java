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
import edu.mum.eselling.service.AdminService;
import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.CustomerService;
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
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AdminService adminService;
	


	@RequestMapping(value={"/","/welcome"})
	public String welcome(Model model) {

		return "welcome";
	}



	 @RequestMapping("/loginSuccess")
	    public String defaultAfterLogin(HttpServletRequest request,Model model ,Principal principal ) {
		if(principal == null){
			return "login";
		}
		 String name = principal.getName();
			System.out.println(name);
		
		  //  model.addAttribute("userproduct", productService.getAllItems(userService.getUserByName(name).getId()));

	        if (request.isUserInRole("ROLE_VENDOR")) {
	        	
	        model.addAttribute("vendor",vendorService.getVendorByUserName(name));
	        model.addAttribute("vendorProducts", productService.getAllProductsByVendorId(vendorService.getVendorByUserName(name).getId()));
	            return "VendorPage";
	        }
	        else if (request.isUserInRole("ROLE_ADMIN")) {
	        		
	 
	        model.addAttribute("admin",adminService.getAdminByUserName(name));
	        	
	        	
	            return "AdminPage";
	        }
	        else{
	        	
	        	model.addAttribute("customer",customerService.getCustomerByUserName(name));
	        return "CustomerPage";
	        }
	 }
	
	 @ModelAttribute
		public void init(Model model){
			model.addAttribute("products", productService.findApprovedProducts());
			model.addAttribute("categories", categoryService.findAll());
		}


}
