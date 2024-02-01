package com.taguo.petpets.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.taguo.petpets.config.JwtUtil;
import com.taguo.petpets.entity.Customers;
import com.taguo.petpets.repository.CustomersRepository;

@Service
public class CustomersService {

	@Autowired
	private CustomersRepository customersRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtUtil jwtUtil;

	// 找全部會員
	public List<Customers> findAllCustomers() {
		return customersRepository.findAll();
	}

	// 找會員ID
	public Customers findById(Long customersId) {
		return customersRepository.findById(customersId).orElse(null);
	}

	// 創立會員
	public Customers createCustomer(Customers customers) {

		// 檢查email是否已註冊
		if (customersRepository.existsByEmail(customers.getEmail())) {
			throw new RuntimeException("此帳號已使用");
		}

		// 密碼加密
		customers.setPassword(passwordEncoder.encode(customers.getPassword()));
		// 建立時間
		customers.setCreateTime(LocalDateTime.now());

		return customersRepository.save(customers);
	}

	// 登入
	public String login(String email, String inputPwd) {
		// 根據email 查找使用者

		Customers customer = customersRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("尚未註冊"));
		
		
		//驗證密碼
		if (!passwordEncoder.matches(inputPwd,customer.getPassword())) {
			throw new RuntimeException("email或密碼錯誤");
		}
		//驗證成功
		return jwtUtil.generateToken(customer.getCustomerId(),email);
	}
	
	public Customers checkLogin(String email,String intputPwd) {
		Customers customer = customersRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("尚未註冊"));
		
		if(customer != null) {
			if(passwordEncoder.matches(intputPwd,customer.getPassword())) {
				return customer;
			}
		}
		return null;
	}

}
