package com.taguo.petpets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taguo.petpets.entity.ShoppingCartItems;

public interface ShoppingCartItemsRepository extends JpaRepository<ShoppingCartItems, Long> {

}
