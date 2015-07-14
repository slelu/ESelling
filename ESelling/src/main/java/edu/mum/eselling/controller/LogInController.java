package edu.mum.eselling.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.eselling.domain.Credentials;
import edu.mum.eselling.domain.Customer;
import edu.mum.eselling.domain.Vendor;
import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.CredentialsService;
import edu.mum.eselling.service.CustomerService;
import edu.mum.eselling.service.ProductService;
import edu.mum.eselling.service.VendorService;



@Controller
public class LogInController {
	
	@Autowired
	CustomerService CustomerService;
	
	@Autowired
	VendorService vendorService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CredentialsService credentialService;

	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
	return "login";
	}
	
	@RequestMapping(value="/loginfailed", method =RequestMethod.GET)
	public String loginerror(Model model) {
	model.addAttribute("error", "true");
	return "login";
	}
		
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		
		
	return "redirect:/welcome";
	}
	
	@RequestMapping(value="/CustomerSignUp", method=RequestMethod.GET)
	public String customerSignup(@ModelAttribute Customer customer){
			
		return "CustomerSignUp";
	}
	
	@RequestMapping(value="/CustomerSignUp", method=RequestMethod.POST)
	public String processCustomerSignUp(@Valid @ModelAttribute Customer customer,BindingResult result ,Model model,RedirectAttributes redirectAttributes){
		if(result.hasErrors())
		{
			return "CustomerSignUp";
		}
		
   List<Credentials> userName = credentialService.getAll();
		customer.getCredentials().getUsername().toLowerCase();
		for(Credentials c : userName){
			if(c.getUsername().equals(customer.getCredentials().getUsername())){
			  model.addAttribute("username","True");
			  return "CustomerSignUp";
			}
		}
		
		System.out.println(customer.getCredentials().getPassword());
		customer.getCredentials().setPassword(getHashPassword(customer.getCredentials().getPassword()));
		customer.setPassword(getHashPassword(customer.getCredentials().getPassword()));
		
		CustomerService.addNewCustomer(customer);
		redirectAttributes.addFlashAttribute("successful","true");
		
		return "redirect:/welcome";
	}
	@RequestMapping(value="/VendorSignUp", method=RequestMethod.GET)
	public String vendorSignup(@ModelAttribute Vendor vendor){
		
			
		return "VendorSignUp";
	}
	
	@RequestMapping(value="/VendorSignUp", method=RequestMethod.POST)
	public String processVendorSignUp(@Valid @ModelAttribute Vendor vendor,BindingResult result,Model model,RedirectAttributes redirectAttributes){
		if(result.hasErrors())
		{
			return "VendorSignUp";
		}
		vendor.getCredentials().getUsername().toLowerCase();
		
		List<Credentials> userName = credentialService.getAll();
		
		for(Credentials c : userName){
			if(c.getUsername().equals(vendor.getCredentials().getUsername())){
			  model.addAttribute("username","True");
			  return "VendorSignUp";
			}
		}
		
		vendor.getCredentials().setPassword(getHashPassword(vendor.getCredentials().getPassword()));
		vendor.setPassword(getHashPassword(vendor.getCredentials().getPassword()));
		
		redirectAttributes.addFlashAttribute("successful","true");
		vendorService.addNewVendor(vendor);
		
		return "redirect:/welcome";
	}
	
	
	
	@ModelAttribute
	public void init(Model model){
		
		Integer[] months = new Integer[] { 1, 2, 3,4,5,6,7,8,9,10,11,12 };
		Integer[] years = new Integer[] {2015,2016,2017,2018,2019,2020,2021};
		String[] states = new String[] {"OH","VA","OK","OR","SC","NY","IA","MD","NH","NV","LA","FL","TX","UT"};
		String[] creditType= new String[]{"Visa","MasterCard"};
		Arrays.asList(months);
		Arrays.asList(years);
		Arrays.asList(states);
		Arrays.asList(creditType);
		model.addAttribute("months",months);
		model.addAttribute("years",years);
		model.addAttribute("states",states);
		model.addAttribute("creditType",creditType);	
		model.addAttribute("categories",categoryService.findAll());
		model.addAttribute("products", productService.findApprovedProducts());
		
	}
	
		  
		 public String getHashPassword(String password) {  
		  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
		  String hashedPassword = passwordEncoder.encode(password);  
		  
		  System.out.println(hashedPassword);  
		  return hashedPassword;  
		 }  
		   
	

	
}
