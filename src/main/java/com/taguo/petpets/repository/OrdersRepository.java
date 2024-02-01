package com.taguo.petpets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taguo.petpets.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
