package com.taguo.petpets.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ShoppingCartItems")
@Data
public class ShoppingCartItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_item_id")
	private Long cartItemId;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customers customer;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Products product;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "total_price")
	private BigDecimal totalPrice;
}
