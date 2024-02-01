package com.taguo.petpets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taguo.petpets.config.JwtUtil;
import com.taguo.petpets.entity.Customers;
import com.taguo.petpets.service.CustomersService;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/public/api/customers")
public class CustomersController {

	@Autowired
	private CustomersService customersService;
	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/createCustomer")
	public ResponseEntity<?> createCutomers(@RequestBody Customers cutomer) {

		try {

			Customers createdCustomer = customersService.createCustomer(cutomer);
			return ResponseEntity.ok(createdCustomer);

		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body("錯誤" + e.getMessage());
		}

	}

	@GetMapping("/{customerId}")
	public ResponseEntity<?> findCustomerById(@PathVariable Long customerId) {

		Customers customer = customersService.findById(customerId);

		if (customer != null) {
			return ResponseEntity.ok(customer);
		} else {
			return ResponseEntity.badRequest().body("查無此用戶");
		}
	}

	@GetMapping("/findAllCustomers")
	public ResponseEntity<List<Customers>> findAllCustomers() {

		List<Customers> customers = customersService.findAllCustomers();
		return ResponseEntity.ok(customers);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Customers customer) {
		try {
			String email = customer.getEmail();
			String password = customer.getPassword();

			String token = customersService.login(email, password);

			// 控制台輸出Token的信息
			Claims claims = jwtUtil.parseToken(token);
			System.out.println("Token:" + token);
			System.out.println("Email:" + claims.get("email", String.class));
			System.out.println("Subject:" + claims.getSubject());
			System.out.println("創建日:" + claims.getIssuedAt());
			System.out.println("到期日:" + claims.getExpiration());

			return ResponseEntity.ok(token);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/login2")
	public String checkLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession httpSession) {
		Customers result = customersService.checkLogin(email, password);
		if (result != null) {
			httpSession.setAttribute("loginName", result.getCustomerName());
			httpSession.setAttribute("loginEmail", result.getEmail());
			httpSession.setAttribute("id", result.getCustomerId());
			System.out.println(result.getCustomerId() + "-" + result.getCustomerName() + "登入成功");

			return "Y";
		} else {
			System.out.println("登入失敗");
		}
		return "N";
	}

	// 登出
	@GetMapping("/logOut")
	public String logOut(HttpSession httpSession) {

		if (httpSession != null) {
			httpSession.invalidate();
			return "Y";
		}
		return "No";
	}
}
