package com.taguo.petpets.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "Orders")
@Data
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customers customer;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Products product;

	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "total_amount")
	private BigDecimal totalAmount;

	@Column(name = "order_date")
	private LocalDateTime orderDate;

	@ManyToOne
	@JoinColumn(name = "shipping_method_id",nullable = false)
	private ShippingMethods shippingMethods;

	@Column(name = "order_status")
	private String orderStatus;
}
