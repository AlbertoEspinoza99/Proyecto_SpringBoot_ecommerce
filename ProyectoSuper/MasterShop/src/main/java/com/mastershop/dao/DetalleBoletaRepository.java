package com.mastershop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mastershop.entity.DetalleBoleta;

public interface DetalleBoletaRepository extends JpaRepository<DetalleBoleta, Integer>{

	@Query("select x from DetalleBoleta x where x.boleta.codigo=?1")
	public List<DetalleBoleta> listaDetallePorCodigoDetalle(int cod);
	
	
}
