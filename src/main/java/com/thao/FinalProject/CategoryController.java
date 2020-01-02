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

import com.thao.FinalProject.model.Category;
import com.thao.FinalProject.service.CategoryService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CategoryController {

	private CategoryService categoryService;

	@Autowired(required = true)
	@Qualifier(value = "categoryService")
	public void setCategoryService(CategoryService c) {
		this.categoryService = c;
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String listCategories(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("listCategories", this.categoryService.listCategories());
		return "category";
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("category") Category c, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("org.springframework.validation.BindingResult.form", bindingResult);
			model.addAttribute("listCategories", this.categoryService.listCategories());
			return "category";
		}
		if (c.getIdCategory() == null) {
			// new category, add it
			this.categoryService.addCategory(c);
		} else {
			// existing category, call update
			this.categoryService.updateCategory(c);
		}

		return "redirect:/product";
	}

	@RequestMapping("/category/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.categoryService.removeCategory(id);
		return "redirect:/category";
	}
	
	@RequestMapping("/category/edit/{id}")
	  public String editPerson(@PathVariable("id") int id, Model model) {
	    model.addAttribute("category", this.categoryService.getCategoryById(id));
		model.addAttribute("listCategories", this.categoryService.listCategories());
	    return "category";
	  }
}
