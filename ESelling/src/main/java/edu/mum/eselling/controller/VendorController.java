package edu.mum.eselling.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.ProductService;
import edu.mum.eselling.service.VendorService;

@Controller
public class VendorController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	VendorService vendorService;
	
	@Autowired
	CategoryService categoryService;
	
	

	@RequestMapping(value="/myProducts", method = RequestMethod.GET)
	public String getItemById(Model model ,Principal principal) {
		String name = principal.getName();
		
		model.addAttribute("vendorProducts", productService.getAllProductsByVendorId(vendorService.getVendorByUserName(name).getId()));
	    
		return "myProducts";
	}
	
	@ModelAttribute
	public void init(Model model,Principal principal){
	    model.addAttribute("categories", categoryService.findAll());
	    model.addAttribute("vendor",vendorService.getVendorByUserName(principal.getName()));
}
}
