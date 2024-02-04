package com.taguo.petpets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.taguo.petpets.service.ProductsService;

@RestController
public class SearchController {
	
	@Autowired
	private ProductsService productsService;
	
	

}
