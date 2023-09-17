package com.mastershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastershop.dao.MenuVentaRepository;
import com.mastershop.entity.MenuVenta;

@Service
public class MenuVentaServices {

	@Autowired
	private MenuVentaRepository repo;
	
	public List<MenuVenta> listaMenuVenta(){
		return repo.findAll();
	}
	
	
	
	
	
}
