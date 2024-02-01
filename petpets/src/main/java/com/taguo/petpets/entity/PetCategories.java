package com.taguo.petpets.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PetCategories")
@Data
public class PetCategories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long petCategoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "description")
	private String description;
}
