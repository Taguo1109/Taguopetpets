package com.taguo.petpets.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Products")
@Data
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "stock_quantity")
	private int stockQuantity;

	@Column(name = "create_time")
	private LocalDateTime createTime;

	@ManyToOne
	@JoinColumn(name = "usage_category_id", nullable = false)
	private Categories usageCategoryId;

	@ManyToOne
	@JoinColumn(name = "pet_category_id")
	private PetCategories petCategoryId;

	@OneToMany(mappedBy = "product")
	private List<Orders> orders;
	
	//關聯，刪除商品時照片同時刪除
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Photos> photos;
}
