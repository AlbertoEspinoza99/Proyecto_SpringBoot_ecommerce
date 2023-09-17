package com.mastershop.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mastershop.entity.Carrito;
import com.mastershop.entity.Producto;
import com.mastershop.services.ProductoServices;

import jakarta.servlet.http.HttpSession;

@SessionAttributes({"sumatotal"})
@Controller
@RequestMapping("/carrito")
public class CarritoController {

	@Autowired
	private ProductoServices serPro;
	
	private int indice(int cod,HttpSession session) {
		
		List<Carrito> carrito= (List<Carrito>)  session.getAttribute("carrito");
		
		for(int i=0;i<carrito.size();i++) {
			
			if(carrito.get(i).getCodigoproducto()==cod) {
				return i;
			}
			
		}
		
		return -1;
	}
	
	
	@RequestMapping("/agregar")
	@ResponseBody
	public List<Carrito> lista(@RequestParam("codigo")int cod,
	                           @RequestParam("precio")double pre,
	                           HttpSession session)
	{
		List<Carrito> carrito=null;
		int cantidad=1;
		int sesioncantidad=0;
		
		try {
			//validar si existe el atributo de tipo sesión "data"
			if(session.getAttribute("carrito")==null) {
				//crear el arrego lista
				carrito=new ArrayList<Carrito>();
				
				   Carrito c=new Carrito(); 
				   c.setCodigoproducto(cod);
				   c.setCantidad(cantidad);
				   c.setPrecio(pre);
				   carrito.add(c);
			 session.setAttribute("carrito", carrito);
			 return carrito;
				
			}//si exite recuperar el carrito
			else 
				carrito= (List<Carrito>) session.getAttribute("carrito");
                int posicion=indice(cod,session);
				
				if(posicion==-1) {
										
					   Carrito c=new Carrito(); 
					   c.setCodigoproducto(cod);
					   c.setCantidad(cantidad);
					   c.setPrecio(pre);
					   carrito.add(c);
					   session.setAttribute("carrito", carrito);
					   
				}else 
					
				 sesioncantidad= carrito.get(posicion).getCantidad();
				 sesioncantidad +=cantidad;
				 carrito.get(posicion).setCantidad(sesioncantidad);	
				 session.setAttribute("carrito", carrito);
				
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return carrito;
		
	}


	@RequestMapping("/bucarCantidad")
	@ResponseBody
	public String busqueda(@RequestParam("codigo")int cod,HttpSession session) {
		
		List<Carrito> carrito=(List<Carrito>) session.getAttribute("carrito");
		
		if(carrito==null) {
			return "aun no esta en tu carrito";
		}
		
		for(int i=0;i<carrito.size();i++) {
			
		 if(carrito.get(i).getCodigoproducto()==cod) {
			 return "         "+carrito.get(i).getCantidad()+"  en el carrito";
		 }
			
		}
		
		return "aun no esta en tu carrito";

	}
	
	
	
	@GetMapping("/total/carrito")
	public String listaCarrito(Model model,HttpSession session) {
		
		List<Carrito> carrito=(List<Carrito>) session.getAttribute("carrito");
		
		//stream(): Este método convierte la lista en un Stream. Un Stream en Java es una secuencia de elementos que pueden ser procesados en paralelo o secuencialmente. 
		//mapToDouble(Producto::getPrecio): Este método transforma cada elemento del Stream original en un nuevo Stream de doubles. En este caso, está transformando cada Producto en su precio. Producto::getPrecio es una referencia a un método que obtiene el precio de un producto.
		//usar una función lambda  para multiplicar

          if(carrito==null) {
			return "carrito";
		 }else {
		     double sumaPrecios = carrito.stream().mapToDouble(item->item.getPrecio()*item.getCantidad()).sum();
			 model.addAttribute("listaTotal", carrito);
			 model.addAttribute("totalProductos", serPro.listaProducto());
			 model.addAttribute("suma", sumaPrecios); 	
			 model.addAttribute("sumatotal", sumaPrecios);
		 }
				
		return "carrito";
	}
	
	
	
	
	
	
	
}
