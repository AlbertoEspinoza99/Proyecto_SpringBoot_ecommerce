package com.mastershop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mastershop.entity.Cliente;
import com.mastershop.entity.Producto;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	
	@Query("select x from Cliente x where x.login=?1")
	public Cliente clienteporlogin(String login);
	
	
	@Query("select x from Cliente x where x.codigo=?1")
	public Cliente clientePorCodigo(int cod);
	
	
}
