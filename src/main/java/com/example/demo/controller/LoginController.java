package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.LoginForm;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final UserService service;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("login-execute")
	public String loginExecute(@ModelAttribute LoginForm form,
			Model model, HttpSession session ) {
		
		boolean result = service.loginExecute(form);
		
		if(result) {
			return "hos-search";
		}else {			
			return "login";
		}
		
	}
}

