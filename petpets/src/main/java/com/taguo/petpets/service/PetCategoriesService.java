package com.taguo.petpets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taguo.petpets.entity.PetCategories;
import com.taguo.petpets.repository.PetCategoriesRepository;

@Service
public class PetCategoriesService {
	
	@Autowired
	private PetCategoriesRepository petCategoriesRepository;

	
	public PetCategories createdPetCategories(PetCategories petCategories) {
		
		if(petCategoriesRepository.existsByCategoryName(petCategories.getCategoryName())) {
			throw new RuntimeException("類別已重複");
		}
		return petCategoriesRepository.save(petCategories);
	}
}
