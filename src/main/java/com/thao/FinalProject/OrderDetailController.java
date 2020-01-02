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

import com.thao.FinalProject.model.OrderDetail;
import com.thao.FinalProject.service.OrderDetailService;
import com.thao.FinalProject.service.OrderService;
import com.thao.FinalProject.service.ProductService;

@Controller
public class OrderDetailController {
	private OrderDetailService orderDetailService;
	private OrderService orderService;
	private ProductService productService;

	@Autowired(required = true)
	@Qualifier(value = "productService")
	public void setProductService(ProductService p) {
		this.productService = p;
	}

	@Autowired(required = true)
	@Qualifier(value = "orderService")
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Autowired(required = true)
	@Qualifier(value = "orderDetailService")
	public void setOrderDetailService(OrderDetailService o) {
		this.orderDetailService = o;
	}

	@RequestMapping(value = "/orderDetail", method = RequestMethod.GET)
	public String listCategories(Model model) {
		model.addAttribute("orderDetail", new OrderDetail());
		model.addAttribute("productsList", this.productService.listProducts());
		model.addAttribute("ordersList", this.orderService.listOrders());
		model.addAttribute("listOrderDetails", this.orderDetailService.listOrderDetails());
		return "orderDetail";
	}

	@RequestMapping(value = "/orderDetail/add", method = RequestMethod.POST)
	public String addOrderDetail(@Valid @ModelAttribute("orderDetail") OrderDetail o, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("org.springframework.validation.BindingResult.form", bindingResult);
			model.addAttribute("productsList", this.productService.listProducts());
			model.addAttribute("ordersList", this.orderService.listOrders());
			model.addAttribute("listOrderDetails", this.orderDetailService.listOrderDetails());
			return "orderDetail";
		}
		if (o.getIdOrderDetail() == null) {
			// new orderDetail, add it
			this.orderDetailService.addOrderDetail(o);
		} else {
			// existing orderDetail, call update
			this.orderDetailService.updateOrderDetail(o);
		}

		return "redirect:/orderDetail";
	}

	@RequestMapping("/orderDetail/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.orderDetailService.removeOrderDetail(id);
		return "redirect:/orderDetail";
	}

	@RequestMapping("/orderDetail/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("orderDetail", this.orderDetailService.getOrderDetailById(id));
		model.addAttribute("productsList", this.productService.listProducts());
		model.addAttribute("ordersList", this.orderService.listOrders());
		model.addAttribute("listOrderDetails", this.orderDetailService.listOrderDetails());
		return "orderDetail";
	}
}
