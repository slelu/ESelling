package edu.mum.eselling.controller;




import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.eselling.domain.Product;
import edu.mum.eselling.service.AdminService;
import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.ProductService;

@Controller
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	@Autowired
	private AdminService adminService;
	
	
	@RequestMapping(value = "/pendingProducts", method = RequestMethod.GET)
	public String pendingProducts(Product product ,Model model){
		List<Product> p=productService.findPendingProducts();
		model.addAttribute("product",p);
		
		if(p.isEmpty()){
			model.addAttribute("noproduct","empty");
		}
	
		
	return "pendingProducts";
	}
	
	
	@RequestMapping(value = "/approveProducts")
    public String approveProduct(@ModelAttribute Product product ,@RequestParam("id") String id ,Model model,Principal principal) {
	
		
		Product newproduct=productService.find(Long.parseLong(id));
        newproduct.setApproval("approved");
	
	    productService.save(newproduct);
	
	
	
	return "pendingProducts";
}

	
	@RequestMapping(value = "/disapproveProduct", method = RequestMethod.POST)
    public String editItem(@ModelAttribute Product product ,@RequestParam("id") String id ,Model model) {
	
		Product newproduct=productService.find(Long.parseLong(id));
		newproduct.setApproval("disapproved");
			
	    productService.save(newproduct);
	
	return "pendingProducts";
	
	}
	
	
	
	
	
	
	
	
	@ModelAttribute
	public void init(Model model,Principal principal){
		model.addAttribute("products",productService.findPendingProducts());
	    model.addAttribute("categories", categoryService.findAll());
	   
	  //  String name = principal.getName();
	    model.addAttribute("admin",adminService.getAdminByUserName(principal.getName()));
	}
	
}