package com.taguo.petpets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taguo.petpets.entity.Categories;
import com.taguo.petpets.service.CategoriesService;import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/public/api/categories")
public class CategoriesController {

	@Autowired
	private CategoriesService categoriesService;
	
	
	//新增類別
	@PostMapping("/createCategory")
	public ResponseEntity<?> createdCategory(@RequestBody Categories categories){
		
		try {
			Categories createdCategories = categoriesService.createCategories(categories) ;
			
			return ResponseEntity.ok(createdCategories);
			
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body("錯誤："+e.getMessage());
		}
	}
	
	//查詢類別
	@GetMapping("/{categoryId}")
	public ResponseEntity<?> findById(@PathVariable Long categoryId){
		
		Categories categories = categoriesService.findById(categoryId);
		
		if(categories!=null) {
			return ResponseEntity.ok(categories);
		}else {
			return ResponseEntity.badRequest().body("查無此類別");
		}
	}
	
}
