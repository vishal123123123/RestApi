package com.orenda.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orenda.model.UserLogin;
import com.orenda.service.ILoginService;

@Controller
public class LoginController {
	 
	@Autowired
	ILoginService service;
	@GetMapping("/")
	public String loginUser() {
		System.out.println("log controller");
		return "login";
	}
	
	@GetMapping("/sub")
	public String Forgot() {
		System.out.println("inside of forgot");
		return "sub";
	}
	
	@GetMapping("/forgot")
	public String forg(@RequestParam("userEmail") String userEmail,Model model) {
	//	System.out.println("hiiiiiiiiiiiiiii");
		//String newUserEmail= userEmail.substring(2, userEmail.length());
		System.out.println("inside of sub");
		System.out.println(userEmail);
	//	System.out.println("token"+" "+token);
		boolean flag=service.fetchByEmail(userEmail);
		if (flag) {
			System.out.println("data is present");
          model.addAttribute("msg"," Email send sucessfully");	
		} else {
			System.out.println("data is not present");
			model.addAttribute("send"," Could not find any customer with the email");
			
		}
		return "sub";
		
	}

	@GetMapping("/for")
	public String show() {
		System.out.println("inside of forgot");
		return "save";
	}
	@GetMapping("/save")
	public String usersave(@RequestParam("password")String password,@RequestParam("userEmail") String userEmail) {
		System.out.println("inside of save method");
		System.out.println(password);
		System.out.println(userEmail);
		
		service.savePassword(password);
		return "save";
	}}
	

