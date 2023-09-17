package com.mastershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastershop.dao.DetalleBoletaRepository;
import com.mastershop.entity.DetalleBoleta;

@Service
public class DetalleServices {

	@Autowired
	private DetalleBoletaRepository repo;
	
	
	public List<DetalleBoleta> listaPorCodDetalle(int cod){
	 return	repo.listaDetallePorCodigoDetalle(cod);
	}
	
	
	
	
}
