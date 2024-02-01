package com.taguo.petpets.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taguo.petpets.entity.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
	
	boolean existsByEmail(String email);
	
	Optional<Customers> findByEmail(String email);

}
