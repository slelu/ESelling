package edu.mum.eselling.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.eselling.domain.Customer;
import edu.mum.eselling.domain.Vendor;
import edu.mum.eselling.service.CustomerService;
import edu.mum.eselling.service.VendorService;



@Controller
public class LogInController {
	
	@Autowired
	CustomerService CustomerService;
	
	@Autowired
	VendorService vendorService;

	
	
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
		
	@RequestMapping(value="/customerSignUp", method=RequestMethod.GET)
	public String customerSignup(@ModelAttribute Customer customer){
			
		return "CustomerSignUp";
	}
	
	@RequestMapping(value="/customerSignUp", method=RequestMethod.POST)
	public String processCustomerSignUp(@Valid @ModelAttribute Customer customer,BindingResult result){
		if(result.hasErrors())
		{
			return "CustomerSignUp";
		}
		
		
		CustomerService.addNewCustomer(customer);
		
		return "redirect:/welcome";
	}
	@RequestMapping(value="/vendorSignUp", method=RequestMethod.GET)
	public String vendorSignup(@ModelAttribute Vendor vendor){
			
		return "VendorSignUp";
	}
	
	@RequestMapping(value="/vendorSignUp", method=RequestMethod.POST)
	public String processVendorSignUp(@Valid @ModelAttribute Vendor vendor,BindingResult result){
		if(result.hasErrors())
		{
			return "VendorSignUp";
		}
		
		vendorService.addNewVendor(vendor);
		
		return "redirect:/welcome";
	}
	
	@ModelAttribute
	public void init(Model model){
		
		Integer[] months = new Integer[] { 1, 2, 3,4,5,6,7,8,9,10,11,12 };
		Integer[] years = new Integer[] { 2010, 2011, 2012,2013,2014,2015,2016,2017,2018,2019,2020};
		String[] states = new String[] {"OH","VA","OK","OR","SC","NY","IA","MD","NH","NV","LA","FL","TX","UT"};
		Arrays.asList(months);
		Arrays.asList(years);
		Arrays.asList(states);
		model.addAttribute("months",months);
		model.addAttribute("years",years);
		model.addAttribute("states",states);
	}
	
}
