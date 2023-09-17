package com.mastershop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mastershop.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{

	
	@Query("select x from Proveedor x where x.direccion.codigo=?1")
	public List<Proveedor> listadeProveedoresPorDireccion(int cod);
	
}
