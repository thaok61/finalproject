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

import com.thao.FinalProject.model.Order;
import com.thao.FinalProject.service.OrderService;
import com.thao.FinalProject.service.CustomerService;

@Controller
public class OrderController {
	private OrderService orderService;
	private CustomerService customerService;

	@Autowired(required = true)
	@Qualifier(value = "customerService")
	public void setCustomerService(CustomerService c) {
		this.customerService = c;
	}

	@Autowired(required = true)
	@Qualifier(value = "orderService")
	public void setOrderService(OrderService o) {
		this.orderService = o;
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String listCategories(Model model) {
		model.addAttribute("order", new Order());
		model.addAttribute("customersList", this.customerService.listCustomers());
		model.addAttribute("listOrders", this.orderService.listOrders());
		return "order";
	}

	@RequestMapping(value = "/order/add", method = RequestMethod.POST)
	public String addOrder(@Valid @ModelAttribute("order") Order o, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("org.springframework.validation.BindingResult.form", bindingResult);
			model.addAttribute("customersList", this.customerService.listCustomers());
			model.addAttribute("listOrders", this.orderService.listOrders());
			return "order";
		}
		if (o.getIdOrder() == null) {
			// new order, add it
			this.orderService.addOrder(o);
		} else {
			// existing order, call update
			this.orderService.updateOrder(o);
		}

		return "redirect:/order";
	}

	@RequestMapping("/order/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.orderService.removeOrder(id);
		return "redirect:/order";
	}

	@RequestMapping("/order/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("order", this.orderService.getOrderById(id));
		model.addAttribute("customersList", this.customerService.listCustomers());
		model.addAttribute("listOrders", this.orderService.listOrders());
		return "order";
	}
}
