package com.mastershop.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mastershop.entity.Carrito;
import com.mastershop.entity.Producto;
import com.mastershop.services.ProductoServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/servicio/producto")
public class ProductoController {

	@Autowired
	private ProductoServices serPro;
	
	
	private String res(Integer cod,HttpSession session) {
		
		List<Carrito> carrito=(List<Carrito>) session.getAttribute("carrito");
		
		if (carrito==null) {
			return "no se encuentra en el carrito";
		}else {
			
			for(int i=0;i<carrito.size();i++) {
				
				if(carrito.get(i).getCodigoproducto()==cod) {
					return "   "+carrito.get(i).getCantidad()+"  en el carrito";
				}
				
			}
			return "no se encuentra en el carrito";
		}
		
	}
	
	
	@GetMapping("/busqueda/{id}")
	public String productoPorCodigo(@PathVariable Integer id,Model model,HttpSession session) 
	{
		
		String respuesta=res(id, session);
		
		model.addAttribute("respuesta", respuesta);
		model.addAttribute("producto", serPro.productoXcodigo(id));
		
		
		return "compra";
	}
	
	
	@GetMapping("/actualizaCarrito")
	@ResponseBody
	public String respuesta(@RequestParam("codigo")Integer cod,HttpSession session) {
		
		return res(cod, session);
	}
	
	
	
	
	private int indice(int cod,HttpSession session) {
		
		List<Carrito> carrito=(List<Carrito>) session.getAttribute("carrito");
		
		for(int i=0;i<carrito.size();i++) {
			
			if(carrito.get(i).getCodigoproducto()==cod) {
				
				return i;
			}
			
		}
		return -1;
	}
	
	
	
	@RequestMapping("/carrito")
	@ResponseBody
   public List<Carrito> listaCarrito(@RequestParam("codigo")int cod,
		                             @RequestParam("cantidad")int can,
		                             @RequestParam("precio")double pre,
		                             HttpSession session){
		
		List<Carrito> carrito=null;
		int sessionCatidad=0;
		
	try {
		
	if(session.getAttribute("carrito")==null) {
			
			carrito=new ArrayList<Carrito>();
			
			Carrito c=new Carrito();
			
			c.setCodigoproducto(cod);
			c.setCantidad(can);
			c.setPrecio(pre);
			
			carrito.add(c);
			
			session.setAttribute("carrito", carrito);
			return carrito;
		}else {
			
			  carrito=(List<Carrito>) session.getAttribute("carrito");
			  int posicion=indice(cod, session);
			
			  if(posicion==-1) {
				  
				  Carrito c=new Carrito();
					
					c.setCodigoproducto(cod);
					c.setCantidad(can);
					c.setPrecio(pre);
					carrito.add(c);
				  
					session.setAttribute("carrito", carrito);
				  
			  }else {
				  
				  sessionCatidad=carrito.get(posicion).getCantidad();
				  sessionCatidad +=can;
				  carrito.get(posicion).setCantidad(sessionCatidad);
				  session.setAttribute("carrito", carrito);
				  
			  }
			
					
		}
		
						
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		return carrito;
		
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
