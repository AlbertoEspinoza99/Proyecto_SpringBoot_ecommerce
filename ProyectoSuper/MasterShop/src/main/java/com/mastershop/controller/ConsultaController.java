package com.mastershop.controller;

import java.beans.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mastershop.entity.CNTProducto;
import com.mastershop.entity.CNTventa;
import com.mastershop.entity.Enlace;
import com.mastershop.entity.Producto;
import com.mastershop.services.BoletaServices;
import com.mastershop.services.ProductoServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/CONSULTA")
public class ConsultaController {

	@Autowired
	private BoletaServices serBol;
	
	@Autowired
	private ProductoServices serPro;
	
	@RequestMapping("/lista")
	public String vistaConsulta(Model model,HttpSession session) {
		
		List<Enlace> lista=(List<Enlace>) session.getAttribute("listaEnlaces");
		model.addAttribute("listaEnlaces", lista);
		
		return "Consultainteractivo2";
	}
	
	
	//listaparaCNProducto
	
	
	
	@RequestMapping("/cnventa")
	@ResponseBody
	public List<CNTventa> listaventa(){
		
		List<CNTventa> VE=new ArrayList<>();
		
		List<Object[]> lista=serBol.listaparaCNventa();
		
		 for (Object[] row : lista) {
	            Date fecha = (Date) row[0];
	            int cantidad = ((Number) row[1]).intValue();

	            
	            CNTventa venta = new CNTventa();
	            venta.setFecha(String.valueOf(fecha));
	            venta.setCantidad(cantidad);

	            VE.add(venta);
		
		
		
	   }
		 return VE;
		
	}
	//serPro
	
	@RequestMapping("/cnProducto")
	@ResponseBody
	public List<CNTProducto> listaProducto(){
		
		List<CNTProducto> VE=new ArrayList<>();
		
		List<Object[]> lista=serBol.listaparaCNProducto();
		
		 for (Object[] row : lista) {
	            int producto = ((Number) row[0]).intValue();
	           String producto2=serPro.productoXcodigo(producto).getNombre();	            
	           int totalCantidad = ((Number) row[1]).intValue();

	            
	            CNTProducto venta = new CNTProducto();
	            venta.setCantidad(totalCantidad);
	            venta.setProducto(producto2);
	           

	            VE.add(venta);
		
		
		
	   }
		 return VE;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
