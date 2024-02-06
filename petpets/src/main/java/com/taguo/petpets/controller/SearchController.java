package com.taguo.petpets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taguo.petpets.entity.Products;
import com.taguo.petpets.service.ProductsService;

@RestController
@RequestMapping("/public/api/search")
public class SearchController {

	@Autowired
	private ProductsService productsService;

	@GetMapping("/productName")
	public ResponseEntity<List<Products>> searchProductsByName(@RequestParam String productName) {

		List<Products> products = productsService.searchProductsByName(productName);

		if (products != null) {
			return ResponseEntity.ok(products);
		} else {
			return ResponseEntity.notFound().build();
		}
	};

}
