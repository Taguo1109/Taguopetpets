package com.taguo.petpets.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Admin")
@Data
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "create_time")
	private LocalDateTime createTime;

	@Column(name = "email")
	private String email;

	@Column(name = "admin_name")
	private String adminName;

	@Column(name = "password")
	private String password;

	@Column(name = "phone")
	private String phone;

}
