package com.taguo.petpets.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Customers")
@Data
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "create_time")
	private LocalDateTime createTime;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "birthday")
	private LocalDate birthday;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	//使Customer可以查到訂單
	@OneToMany(mappedBy = "customer")
	private List<Orders> orders;
}
