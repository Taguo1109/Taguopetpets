package com.taguo.petpets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taguo.petpets.entity.Categories;
import com.taguo.petpets.repository.CategoriesRepository;

@Service
public class CategoriesService {
	
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	//新增類別
	public Categories createCategories(Categories categories) {
		
		//檢查是否類別名稱重複
		if(categoriesRepository.existsByCategoryName(categories.getCategoryName())) {
			throw new RuntimeException("已有此類別");
		}
		return categoriesRepository.save(categories);
		
	}
	//修改類別
	//刪除類別
	//查詢類別
	public Categories findById(Long categoryId) {
		return categoriesRepository.findById(categoryId).orElse(null);
	}
}
