package edu.mum.eselling.controller;


import java.io.File;
import java.security.Principal;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.eselling.domain.Category;
import edu.mum.eselling.domain.OrderDetail;
import edu.mum.eselling.domain.Product;
import edu.mum.eselling.domain.Vendor;
import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.ProductService;
import edu.mum.eselling.service.VendorService;
import edu.mum.eselling.smtp.EmailSettings;
import edu.mum.eselling.smtp.EmailUtil;


@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	VendorService vendorService;

	
	
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String inputProduct(@ModelAttribute Product product, Model model ,Principal principal) {		
	model.addAttribute("vendor",vendorService.getVendorByUserName(principal.getName()));
		
		return "addProduct";
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute Product product,BindingResult result,HttpServletRequest request ,
			Model model,Principal principal ,RedirectAttributes redirectAttributes) {
	
		if(result.hasErrors()){
			model.addAttribute("categories", categoryService.findAll());
			return "addProduct";
		}
		MultipartFile productImage = product.getProductImage();
	

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		if (productImage != null && !productImage.isEmpty()) {
			System.out.println(rootDirectory);

			try {
			

product.setProductPath("E:\\resources\\images\\" + product.getProductName()+ ".png");
	//product.setProductPath(rootDirectory + "\\resources\\images\\" + product.getProductName()+ ".png");
                productImage.transferTo(new File(
                		rootDirectory + "\\resources\\images\\" +  product.getProductName()
								+ ".png"));
				
			}
         catch (Exception e) {
			throw new RuntimeException("Employee Image saving failed", e);
		}
				
		}	
		product.setApproval("pending");
		Category cat = categoryService.find(product.getCategory().getCategoryId());
		
		cat.addProducts(product);
		Vendor vendor=vendorService.getVendorByUserName(principal.getName());
		vendor.addProducts(product);
		
		vendorService.saveVendor(vendor);
		
		redirectAttributes.addFlashAttribute("addproduct" ,"true");
		redirectAttributes.addFlashAttribute("vendor",vendor);
		
		//send e-mail
		
		final String fromEmail = "pmesellingroup3@gmail.com"; //requires valid gmail id
        final String password = "lachimachidoo"; // correct password for gmail id
		final String toEmail = vendor.getEmail();

		
        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
        //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
		
		Session session = Session.getInstance(EmailSettings.getEmailProperties(), auth);
		EmailUtil.sendEmail(session, toEmail, " Notification " + vendor.getFirstName(), vendor.getFirstName()+"you have successfully added your Products to E-Selling and they are waiting for Approval. You can now sign in and purchase from our site or Check the Status of your Products. ");
		
		return "redirect:/vendor";

	}
	
	
	@RequestMapping("/products/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(Long.parseLong(productId)));
		return "product";
	}
	
	 @ModelAttribute
	 public void init(Model model,Principal principal){
		 model.addAttribute("products",productService.findApprovedProducts());
		 model.addAttribute("categories", categoryService.findAll());	
		 model.addAttribute("orderDetail", new OrderDetail());

		// model.addAttribute("vendor",vendorService.getVendorByUserName(principal.getName()));

	 }

}
