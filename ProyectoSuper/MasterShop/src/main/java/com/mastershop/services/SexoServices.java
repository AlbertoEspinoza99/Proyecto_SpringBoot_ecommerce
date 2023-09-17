package com.mastershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastershop.dao.SexoRepository;
import com.mastershop.entity.Sexo;

@Service
public class SexoServices {

	@Autowired
	private SexoRepository repo;
	
	
	public List<Sexo> listaSexo(){
		return repo.findAll();
	}
}
