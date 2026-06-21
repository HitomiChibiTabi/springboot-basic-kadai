package com.example.springtutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
	@GetMapping("/exception")
	public String dummyException(@RequestParam int num) {
		return "100を" + num + "で割った値は" + (100 / num);
	}

}
