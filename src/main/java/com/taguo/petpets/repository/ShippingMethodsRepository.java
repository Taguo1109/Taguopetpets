package com.taguo.petpets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taguo.petpets.entity.ShippingMethods;

public interface ShippingMethodsRepository extends JpaRepository<ShippingMethods, Long> {

}
