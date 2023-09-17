package com.mastershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastershop.dao.ProveedorRepository;
import com.mastershop.entity.Proveedor;

@Service
public class ProveedorServices {

	@Autowired
	private ProveedorRepository repo;
	
	
	public List<Proveedor> listaProveedor(){
		return repo.findAll();
	}
	
	
	public List<Proveedor> listaProvedorPorCodigoDireccion(int cod){
		return repo.listadeProveedoresPorDireccion(cod);
	}
	
}
