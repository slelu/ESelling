package edu.mum.eselling.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String welcome() {
		
		return "welcome";
	}
	
	 @RequestMapping("/welcome")
	    public String defaultAfterLogin(HttpServletRequest request) {
	        if (request.isUserInRole("ROLE_VENDOR")) {
	            return "welcome";
	        }
	        
	        return "CustomerPage";
	    }
	
}
