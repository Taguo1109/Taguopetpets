package com.taguo.petpets.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.taguo.petpets.entity.Admin;
import com.taguo.petpets.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	// 查詢所有管理者
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	// 查詢用戶ById
	public Admin getAdminById(Long adminId) {
		return adminRepository.findById(adminId).orElse(null);
	}

	// 創建管理員
	public Admin createAdmin(Admin admin) {

		if (adminRepository.existsByEmail(admin.getEmail())) {
			throw new RuntimeException("此帳號已使用");
		}
		// 加密
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		// 設立創立時間
		admin.setCreateTime(LocalDateTime.now());
		return adminRepository.save(admin);
	}

	// 更改資料
	public Admin updateAdmin(Admin updatedAdmin) {
		Long adminId = updatedAdmin.getId();

		// 檢查管理員是否存在
		Admin existingAdmin = adminRepository.findById(adminId)
				.orElseThrow(() -> new RuntimeException("找不到ID為" + adminId + "的管理員"));

		// 更新管理員訊息，若更新資料為空則用原先值
//		existingAdmin.setAdminName(
//				updatedAdmin.getAdminName() != null ? updatedAdmin.getAdminName() : existingAdmin.getAdminName());
//
//		existingAdmin.setPhone(updatedAdmin.getPhone() != null ? updatedAdmin.getPhone() : existingAdmin.getPhone());
		
		
		//更新管理員訊息，符合條件更改，不符合則不動
		if (updatedAdmin.getAdminName() != null && !updatedAdmin.getAdminName().isEmpty()) {
		    existingAdmin.setAdminName(updatedAdmin.getAdminName());
		}

		if (updatedAdmin.getPhone() != null && !updatedAdmin.getPhone().isEmpty()) {
		    existingAdmin.setPhone(updatedAdmin.getPhone());
		}
		// 加密並更新密碼(如果新密碼)
		String newPassword = updatedAdmin.getPassword();
		if (newPassword != null && !newPassword.isEmpty()) {
			existingAdmin.setPassword(passwordEncoder.encode(newPassword));
		}

		// 保存更新後的管理員信息
		return adminRepository.save(existingAdmin);
	}
}
