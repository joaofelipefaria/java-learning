package com.ses.techcom.mvision.springpg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MapDataController {

	@GetMapping("/hi")
	public String greetings() {
		return "hi there";
	}
}
