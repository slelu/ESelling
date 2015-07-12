package edu.mum.eselling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.eselling.domain.Category;
import edu.mum.eselling.domain.ProductSearchCriteria;
import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/product/search", method = RequestMethod.POST)
	public String productList(
			@ModelAttribute("productSearchCriteria") ProductSearchCriteria productSearchCriteria,
			BindingResult result, Model model) {
		model.addAttribute("products",
				productService.findByFilter(productSearchCriteria));

		return "welcome";
	}

	@ModelAttribute
	public void init(Model model) {
		List<Category> category = categoryService.findAll();
		model.addAttribute("categories", category);

		ProductSearchCriteria productSearchCriteria = new ProductSearchCriteria();
		model.addAttribute("productSearchCriteria", productSearchCriteria);
	}
}
