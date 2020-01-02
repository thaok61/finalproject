package com.thao.FinalProject;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thao.FinalProject.model.Customer;
import com.thao.FinalProject.service.CustomerService;

@Controller
public class CustomerController {
	private CustomerService customerService;

	@Autowired(required = true)
	@Qualifier(value = "customerService")
	public void setCustomerService(CustomerService c) {
		this.customerService = c;
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String listCategories(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("listCustomers", this.customerService.listCustomers());
		return "customer";
	}

	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public String addCustomer(@Valid @ModelAttribute("customer") Customer c, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("org.springframework.validation.BindingResult.form", bindingResult);
			model.addAttribute("listCategories", this.customerService.listCustomers());
			return "customer";
		}
		if (c.getIdCustomer() == null) {
			// new customer, add it
			this.customerService.addCustomer(c);
		} else {
			// existing customer, call update
			this.customerService.updateCustomer(c);
		}

		return "redirect:/customer";
	}

	@RequestMapping("/customer/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.customerService.removeCustomer(id);
		return "redirect:/customer";
	}
	
	@RequestMapping("/customer/edit/{id}")
	  public String editPerson(@PathVariable("id") int id, Model model) {
	    model.addAttribute("customer", this.customerService.getCustomerById(id));
		model.addAttribute("listCategories", this.customerService.listCustomers());
	    return "customer";
	  }
}
