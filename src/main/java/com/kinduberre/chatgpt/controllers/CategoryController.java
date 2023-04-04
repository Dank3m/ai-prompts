package com.kinduberre.chatgpt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kinduberre.chatgpt.models.Category;
import com.kinduberre.chatgpt.services.CategoryService;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("categories")
	public List<Category> getAllCategories() {
		return categoryService.findAll();
	}
}
