package com.mastershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastershop.dao.CategoriaRepository;
import com.mastershop.entity.Categoria;

@Service
public class CategoriaServices {

	@Autowired
	private CategoriaRepository repo;
	
	
	public List<Categoria> listaCategoria(){
		return repo.findAll();
	}
	
	
	
}
