package edu.mum.eselling.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.eselling.domain.Admin;


 

@Controller
public class UserController {
	
	

	@RequestMapping(value = "/add", method = RequestMethod.GET)
  	@PreAuthorize("hasRole('ROLE_ADMIN')")    // If global-method-security enabled in Dispatcher config
	public String getAddNewMemberForm(@ModelAttribute("newAdmin") Admin newAdmin) {
	   return "addAdmin";
	}
	   
	}
	
 

