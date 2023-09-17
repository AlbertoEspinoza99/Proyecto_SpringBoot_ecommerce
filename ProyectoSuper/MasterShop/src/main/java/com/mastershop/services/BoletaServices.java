package com.mastershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastershop.dao.BoletaRepository;
import com.mastershop.dao.DetalleBoletaRepository;
import com.mastershop.entity.Boleta;
import com.mastershop.entity.DetalleBoleta;
import com.mastershop.entity.DetalleBoletaPK;

import jakarta.transaction.Transactional;

@Service
public class BoletaServices {
	
	@Autowired
	private BoletaRepository repoBol;
	
	@Autowired
	private DetalleBoletaRepository repoDet;
	
	@Transactional
	public void RegistrarBoleta(Boleta obj) {
		
		try {
			
			//grabar boleta
			repoBol.save(obj);
			//grabar el detalle
			
			for(DetalleBoleta db:obj.getListaDetalleBoleta()) {
				
				DetalleBoletaPK pk=new DetalleBoletaPK();
				
				pk.setCodigoBoleta(obj.getCodigo());
				pk.setCodigoProducto(db.getProducto().getCodigo());
				
				db.setId(pk);
				
				repoDet.save(db);
				
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	 public List<Boleta> listaPorCodigoCliente(int cod){
		 
		return repoBol.listaporCodigoCliente(cod);
	 }
	
	
	
	public List<Object[]> listaparaCNventa(){
		
		return repoBol.findTop5DatesWithCount();
	}
	
	
	
	public List<Object[]> listaparaCNProducto(){
		
		return repoBol.findTop4ProductsByTotalQuantity();
	}

}
