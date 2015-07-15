package edu.mum.eselling.controller;


import java.io.File;
import java.security.Principal;

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

import edu.mum.eselling.domain.Category;
import edu.mum.eselling.domain.OrderDetail;
import edu.mum.eselling.domain.Product;
import edu.mum.eselling.domain.Vendor;
import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.ProductService;
import edu.mum.eselling.service.VendorService;


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
	public String saveProduct(@Valid @ModelAttribute Product product,BindingResult result,HttpServletRequest request ,Model model,Principal principal) {
	
		if(result.hasErrors()){
			model.addAttribute("categories", categoryService.findAll());
			return "addProduct";
		}
		MultipartFile itemImage = product.getProductImage();
	

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		if (itemImage != null && !itemImage.isEmpty()) {
			System.out.println(rootDirectory);

			try {
			

product.setProductPath("E:\\resources\\images\\" + product.getProductName()+ ".png");
	//product.setProductPath(rootDirectory + "\\resources\\images\\" + product.getProductName()+ ".png");
				itemImage.transferTo(new File(
								 "E:\\resources\\images\\" + product.getProductName()
								+ ".png"));
				
			}
         catch (Exception e) {
			throw new RuntimeException("Employee Image saving failed", e);
		}
				
		}	
		product.setApproval("pending");
		//Category cat = categoryService.find(product.getCategory().getCategoryId());
		
		//cat.addProducts(product);
		Vendor vendor=vendorService.getVendorByUserName(principal.getName());
		//Vendor vendor=vendorService.getVendor(Long.parseLong(id));
		vendor.addProducts(product);
		
		vendorService.saveVendor(vendor);
		
        model.addAttribute("addproduct" ,"true");
		model.addAttribute("vendor",vendor);
		//model.addAttribute("VendorProducts", productService.getAllProductsByVendorId(Long.parseLong(id)));
       
		
		//model.addAttribute("vendor",vendorService.getVendorByUserName(principal.getName()));
		return "VendorPage";

	}
	
	
	@RequestMapping("/products/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(Long.parseLong(productId)));
		return "product";
	}
	
	 @ModelAttribute
	 public void init(Model model){
		 model.addAttribute("products",productService.findApprovedProducts());
		 model.addAttribute("categories", categoryService.findAll());	
		 model.addAttribute("orderDetail", new OrderDetail());
	 }

}
