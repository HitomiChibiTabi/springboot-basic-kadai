package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	
	@GetMapping("/form")
	public String showForm(Model model) {
		
		model.addAttribute("contactForm", new ContactForm());
		
		return "contactFormView";
	}
	
	@PostMapping("/form")
	public String viewConfirm(@Validated ContactForm form,
			BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			
			model.addAttribute("contactForm", form);
			return "contactFormView";
		}
		
	    redirectAttributes.addFlashAttribute("contactForm", form);
	    return "redirect:/confirm";
	}
	
	@GetMapping("/confirm")
	public String showConfirm() {
		return "confirmView";
	}

}
