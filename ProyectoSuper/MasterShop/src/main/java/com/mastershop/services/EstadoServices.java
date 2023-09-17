package com.mastershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastershop.dao.EstadoRepository;
import com.mastershop.entity.Estado;

@Service
public class EstadoServices {

	@Autowired
	private EstadoRepository repo;
	
	public List<Estado> listaEstado(){
		return repo.findAll();
	}
	
}
