package com.mastershop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/CONOCE")
public class ConocenosController {

	@RequestMapping("/cono")
	public String driecc() {
		
		return "conocenos";
	}
	
}
