package com.taguo.petpets.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ShippingMethods")
@Data
public class ShippingMethods {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shipping_method_id")
	private Long shippingMethodId;
	
	@Column(name = "ship_name")
	private String shipName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "cost")
	private BigDecimal cost;

}
