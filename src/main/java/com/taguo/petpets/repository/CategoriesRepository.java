package com.taguo.petpets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taguo.petpets.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

}
