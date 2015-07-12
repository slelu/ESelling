package edu.mum.eselling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.eselling.domain.CreditCard;
import edu.mum.eselling.service.CreditCardTypeService;


public class CreditCardController {

	@Autowired
	private CreditCardTypeService creditCardTypeService;

	@RequestMapping("/filmon")
	public String creditCard() {
		/*CreditCard creditCard = new CreditCard();
		model.addAttribute("creditCard", creditCard);*/
		return "creditCard";
	}

/*	@RequestMapping(value = "/creditCard", method = RequestMethod.POST)
	public String creditCard(@Valid @ModelAttribute CreditCard creditCard,
			BindingResult result, HttpServletRequest request,
			@RequestParam("id") String id, Model model) {
		return "creditCard";
	}*/

	/*@ModelAttribute
	public void init(Model model) {
		List<CreditCardType> creditCardType = creditCardTypeService.findAll();
		model.addAttribute("creditCardType", creditCardType);
		List<String> months = new LinkedList<String>();
			months.add("01");
			months.add("02");
			months.add("03");
			months.add("03");
			months.add("04");
			months.add("05");
			months.add("06");
			months.add("07");
			months.add("08");
			months.add("09");
			months.add("10");
			months.add("11");
			months.add("12");
		model.addAttribute("months", months);
	}*/
}
