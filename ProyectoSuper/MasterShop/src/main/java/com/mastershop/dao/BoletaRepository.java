package com.mastershop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mastershop.entity.Boleta;

public interface BoletaRepository extends JpaRepository<Boleta, Integer>{

	
	@Query("select x from Boleta x where x.cliente.codigo=?1")
	public List<Boleta> listaporCodigoCliente(int cod);
	
	
	
	@Query("SELECT b.fecha, COUNT(b.fecha) AS cantidad " +
            "FROM Boleta b " +
            "GROUP BY b.fecha " +
            "ORDER BY b.fecha DESC " +
            "LIMIT 5")
    List<Object[]> findTop5DatesWithCount();
	
	
    @Query("SELECT db.producto.codigo, SUM(db.cantidad) AS totalCantidad " +
            "FROM DetalleBoleta db " +
            "GROUP BY db.producto.codigo " +
            "ORDER BY totalCantidad DESC " +
            "LIMIT 4")
   List<Object[]> findTop4ProductsByTotalQuantity();
    
	
	
	
}
