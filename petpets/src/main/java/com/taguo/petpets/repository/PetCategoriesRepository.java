package com.taguo.petpets.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taguo.petpets.entity.PetCategories;

public interface PetCategoriesRepository extends JpaRepository<PetCategories, Long>{
	
	boolean existsByCategoryName(String petCategoryName);
	
	Optional<PetCategories> findByCategoryName(String petCategoryName);

}
