package com.taguo.petpets.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taguo.petpets.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
	
	boolean existsByCategoryName(String categoryName);
	Optional<Categories> findByCategoryName(String categoryName);

}
