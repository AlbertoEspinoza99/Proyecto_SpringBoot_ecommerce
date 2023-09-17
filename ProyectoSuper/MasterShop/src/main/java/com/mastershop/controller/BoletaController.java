package com.mastershop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mastershop.entity.Boleta;
import com.mastershop.entity.Carrito;
import com.mastershop.entity.Cliente;
import com.mastershop.entity.DetalleBoleta;
import com.mastershop.entity.Estado;
import com.mastershop.entity.Producto;
import com.mastershop.services.BoletaServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/boleta")
public class BoletaController {

	@Autowired
	private BoletaServices serBol;
	
	@RequestMapping("/grabar")
	public String grabarboleta(@SessionAttribute("codUsu")int cod,@SessionAttribute("sumatotal")double total,HttpSession session,RedirectAttributes redirect) {
		
		try {
			
			 Boleta bol=new Boleta();
			 Date fecha=new Date();
			 
			 Cliente cli=new Cliente(cod);
			 bol.setCliente(cli);
			 Estado es=new Estado(1);
			 bol.setEstado(es);
			 bol.setFecha(fecha);
			 bol.setMonto(total);
			
			 
			 
			List<DetalleBoleta> detalle=new ArrayList<DetalleBoleta>();
			
			List<Carrito> carrito=(List<Carrito>) session.getAttribute("carrito");
			
			for(Carrito d:carrito) {
				
				
				DetalleBoleta det=new DetalleBoleta();
				
				Producto p=new Producto(d.getCodigoproducto());
				
				det.setProducto(p);
				det.setCantidad(d.getCantidad());
				det.setPrecio(d.getPrecio());
				
				detalle.add(det);
			}
			
			bol.setListaDetalleBoleta(detalle);
			serBol.RegistrarBoleta(bol);
			
			carrito.clear();
			
			session.setAttribute("carrito", carrito);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/boleta/mensajes";
	}
	
	
	@RequestMapping("/mensajes")
	public String mensajedeCompra() {
		
		return "mensaje";
	}
	
	
	
	
}
