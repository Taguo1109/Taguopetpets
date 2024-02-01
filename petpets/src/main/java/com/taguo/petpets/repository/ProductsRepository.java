package com.taguo.petpets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taguo.petpets.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

}
