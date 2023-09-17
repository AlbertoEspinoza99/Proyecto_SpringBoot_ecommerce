package com.mastershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastershop.dao.ClienteRepository;
import com.mastershop.entity.Cliente;

@Service
public class ClienteServices {

	@Autowired
	private ClienteRepository repo;
	
	
	public Cliente clientexlogin(String login) {
		return repo.clienteporlogin(login);
	}
	
	public List<Cliente> listaCLiente(){
		return repo.findAll();
	}
	
	public Cliente clienteporCodigo(int cod) {
	 return	repo.clientePorCodigo(cod);
	}
	
	
	public void RegistrarCliente(Cliente obbj) {
		
		repo.save(obbj);
	}
	
	public void EliminarCliente(int cod) {
		repo.deleteById(cod);
	}
	
}