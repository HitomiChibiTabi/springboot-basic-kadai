package com.example.springtutorial.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
	private final MessagePrinter messagePrinter;
	
	public ProfileController(MessagePrinter messagePrinter) {
		this.messagePrinter = messagePrinter;
	}
	
	@GetMapping("/profile")
	public String profile() {
		return messagePrinter.printMessage();
	}

}

interface MessagePrinter {
	String printMessage();
}

@Component
@Profile("dev")
class DevPrinter implements MessagePrinter {
	public String printMessage() {
		return "これは開発環境で実行されました。";
	}
}

@Component
@Profile("prod")
class ProdPrinter implements MessagePrinter {
	public String printMessage() {
		return "これは本番環境で実行されました。";
	}
}