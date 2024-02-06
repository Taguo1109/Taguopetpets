package com.taguo.petpets.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taguo.petpets.entity.Products;
import com.taguo.petpets.repository.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	
	public List<Products> searchProductsByName(String productName){
		return productsRepository.findByProductNameContaining(productName);
	}
	public List<Products> searchProductsByName2(String productName){
		return productsRepository.searchProductByName(productName);
	}
	
	//新增商品
	public Products createdProduct(Products products) {
		
		products.setCreateTime(LocalDateTime.now());
		return productsRepository.save(products);
	}
	
}
