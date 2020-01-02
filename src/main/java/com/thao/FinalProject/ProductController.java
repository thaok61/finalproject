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

import com.thao.FinalProject.model.Product;
import com.thao.FinalProject.service.CategoryService;
import com.thao.FinalProject.service.ProductService;

@Controller
public class ProductController {
	private ProductService productService;
	private CategoryService categoryService;

	@Autowired(required = true)
	@Qualifier(value = "productService")
	public void setProductService(ProductService p) {
		this.productService = p;
	}

	@Autowired(required = true)
	@Qualifier(value = "categoryService")
	public void setCategoryService(CategoryService c) {
		this.categoryService = c;
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String listCategories(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("categoriesList", this.categoryService.listCategories());
		model.addAttribute("listProducts", this.productService.listProducts());
		return "product";
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product p, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("org.springframework.validation.BindingResult.form", bindingResult);
			model.addAttribute("categoriesList", this.categoryService.listCategories());
			model.addAttribute("listProducts", this.productService.listProducts());
			return "product";
		}
		if (p.getIdProduct() == null) {
			// new product, add it
			this.productService.addProduct(p);
		} else {
			// existing product, call update
			this.productService.updateProduct(p);
		}

		return "redirect:/product";
	}

	@RequestMapping("/product/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.productService.removeProduct(id);
		return "redirect:/product";
	}

	@RequestMapping("/product/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("product", this.productService.getProductById(id));
		model.addAttribute("categoriesList", this.categoryService.listCategories());
		model.addAttribute("listProducts", this.productService.listProducts());
		return "product";
	}
}
