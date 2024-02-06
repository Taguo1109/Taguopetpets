package com.taguo.petpets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taguo.petpets.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {
	
	List<Products> findByProductNameContaining(String productName);//自動生成的sql
	
	@Query("SELECT p FROM Products p WHERE p.productName LIKE %:productName%")
	List<Products> searchProductByName(@Param("productName")String productName);//自己寫的sql

}
