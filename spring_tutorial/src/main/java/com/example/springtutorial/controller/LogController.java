package com.example.springtutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LogController {
	@GetMapping("/log")
	public String logMessage() {
		log.error("これはERRORレベルのログです。");
		log.warn("これはWARNレベルのログです。");
		log.info("これはINFOレベルのログです。");
		log.debug("これはDEBUGレベルのログです。");
		log.trace("これはTRACEレベルのログです。");
		
		return "ログを出力しました。";
	}

}
