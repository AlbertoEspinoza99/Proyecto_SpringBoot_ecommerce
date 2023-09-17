package com.mastershop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/IniciarSesion")
public class InicioSesion {

	@GetMapping("/login")
	public String inicioSesion() {
				
		return "login";
	}
	
	
	
	@RequestMapping("/denegado")
	public String accesedenegado() {
				
		return "403";
		
	}
	
	
}
