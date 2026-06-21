package com.example.springtutorial.controller;

import java.util.List;

import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springtutorial.entity.User;
import com.example.springtutorial.form.UserRegisterForm;
import com.example.springtutorial.service.UserService;

@Controller
public class AdminUserController {
	private final UserService userService;
	
	public AdminUserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/adminuser")
	public String adminUser(Model model) {
		
		List<User> users = userService.getAllUsers();
		
		model.addAttribute("users", users);
		
		if (!model.containsAttribute("userRegisterForm")) {
			
			model.addAttribute("userRegisterForm", new UserRegisterForm());
		}
		
		return "adminUserView";
		
	}
	
	@PostMapping("/register")
	public String registerUser(RedirectAttributes redirectAttributes,
			@Validated UserRegisterForm form, BindingResult result) {
		
		if (result.hasErrors()) {
			
			redirectAttributes.addFlashAttribute("userRegisterForm", form);
			
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX
					+ Conventions.getVariableName(form), result);
			
			return "redirect:/adminuser";
			
		}
		
		try {
			
			userService.createUser(form.getUserName(), form.getPassword(), form.getRoleId());
			
			redirectAttributes.addFlashAttribute("successMessage", "ユーザー登録が完了しました。");
			
		} catch (IllegalArgumentException e) {
			
			redirectAttributes.addFlashAttribute("failureMessage", e.getMessage());
			
			redirectAttributes.addFlashAttribute("userRegisterForm", form);
			
		}
		
		return "redirect:/adminuser";
		
	}
	
}
