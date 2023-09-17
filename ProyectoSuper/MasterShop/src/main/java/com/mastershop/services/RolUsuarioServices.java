package com.mastershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastershop.dao.RolUsuarioRepository;
import com.mastershop.entity.RolUsuario;

@Service
public class RolUsuarioServices {

	@Autowired
	private RolUsuarioRepository repo;
	
	public List<RolUsuario> listaRol(){
		return repo.findAll();
	}
	
}
