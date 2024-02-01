package com.taguo.petpets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome ! Spring Security";
	}
//	在沒有PasswordEncoder的情況下可以正常登入security

}
