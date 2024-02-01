package com.taguo.petpets.service;

import java.util.List;

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
	public String deleteById(Long categoryId) {
		//先查詢是否有此類別
		Categories categoryToDelete = categoriesRepository.findById(categoryId)
						.orElseThrow(()->new RuntimeException("未找到紀錄"));
		
		//刪除
		categoriesRepository.delete(categoryToDelete);
		return "成功刪除"+categoryId;
	}
	//查詢類別
	public Categories findById(Long categoryId) {
		return categoriesRepository.findById(categoryId).orElse(null);
	}
	public List<Categories> findAllCategories(){
		return categoriesRepository.findAll();
	}
}
