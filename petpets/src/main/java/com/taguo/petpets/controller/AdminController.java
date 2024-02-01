package com.taguo.petpets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taguo.petpets.entity.Admin;
import com.taguo.petpets.service.AdminService;

@RestController
@RequestMapping("/public/api/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;

	// 創建管理員
	@PostMapping("/createAdmin")
	public ResponseEntity<?> createAdmin(@RequestBody Admin admin) {
		try {
			Admin createdAdmin = adminService.createAdmin(admin);
			return ResponseEntity.ok(createdAdmin);

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("此帳號已使用");
		}
	}

	// 找尋管理員
	@GetMapping("/{adminId}")
	public ResponseEntity<?> getAdminById(@PathVariable Long adminId) {

		Admin admin = adminService.getAdminById(adminId);

		if (admin != null) {

			return ResponseEntity.ok(admin);
		} else {
			// 未找到返回404，並輸出查無此管理員
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("查無此管理員");
		}
	};

	// 找全部管理員
	@GetMapping("/adminAll")
	public ResponseEntity<List<Admin>> getAllAdmin() {

		List<Admin> admins = adminService.getAllAdmins();

		return ResponseEntity.ok(admins);
	}

	// 更新管理員資料
	@PutMapping("/updateAdmin")
	public ResponseEntity<?> updatedAdmin(@RequestBody Admin updatedAdmin){
		
		try {
			Admin updatedAdminResult = adminService.updateAdmin(updatedAdmin);
			
			return ResponseEntity.ok(updatedAdminResult);
		}catch(RuntimeException e){
			
			return ResponseEntity.badRequest().body("更新失敗");
		}
		
	}

}
