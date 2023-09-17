package com.mastershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.mastershop.entity.Boleta;
import com.mastershop.entity.DetalleBoleta;
import com.mastershop.entity.Producto;
import com.mastershop.services.BoletaServices;
import com.mastershop.services.DetalleServices;
import com.mastershop.services.ProductoServices;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/compra")
public class CompraContoller {

	@Autowired
	private BoletaServices serBol;
	
	@Autowired
	private DetalleServices serDet;
	
	@Autowired
	private ProductoServices serPro;
	
	@RequestMapping("/detalle")
	public String direccionenlace(Model model,HttpSession session) {
		
		
		if(session.getAttribute("codUsu")==null) {
		
			return "compraLista";
			
		}else {
			
			int cod=(int) session.getAttribute("codUsu");
			
			if(cod>0) {
				
				List<Boleta> lista=serBol.listaPorCodigoCliente(cod);
				model.addAttribute("boletalista", lista);
				return "compraLista";
			}else
							
			return "compraLista";	
			
		}
	}

	
	
	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable Integer id,Model model) {
		
		if(id==null) {
			
			return "compraDetalle";
			
		}
		else {
			
		   List<DetalleBoleta> lista=serDet.listaPorCodDetalle(id);
		   List<Producto> listProd=serPro.listaProducto();
		   
			model.addAttribute("listaDetalle", lista);
			model.addAttribute("listaProducto", listProd);
			return "compraDetalle";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
