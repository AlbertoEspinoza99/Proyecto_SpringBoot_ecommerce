package com.mastershop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mastershop.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	
	@Query("select x from Producto x where x.categoria.codigo=?1")
	public List<Producto> listaProductoxCategoria(int cod);
	
	@Query("select x from Producto x where x.codigo=?1")
	public Producto productoPorCodigo(int cod);
		
	
	
}
