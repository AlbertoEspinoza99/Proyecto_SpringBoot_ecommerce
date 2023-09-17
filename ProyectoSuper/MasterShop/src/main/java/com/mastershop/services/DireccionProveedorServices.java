package com.mastershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastershop.dao.DireccionProveedorRepository;
import com.mastershop.entity.DireccionProveedor;

@Service
public class DireccionProveedorServices {

	@Autowired
	DireccionProveedorRepository repo;
	
	
	public List<DireccionProveedor> listaDeDireccion(){
	return	repo.findAll();
	}
	
	
	
}
