package com.mastershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mastershop.dao.CategoriaRepository;
import com.mastershop.entity.Categoria;
import com.mastershop.entity.Enlace;
import com.mastershop.entity.Estado;
import com.mastershop.entity.Producto;
import com.mastershop.entity.Proveedor;
import com.mastershop.services.CategoriaServices;
import com.mastershop.services.DireccionProveedorServices;
import com.mastershop.services.EstadoServices;
import com.mastershop.services.ProductoServices;
import com.mastershop.services.ProveedorServices;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
@RequestMapping("/CrudProducto")
public class CrudProducto {

	@Autowired
	private ProductoServices serPro;
	
	@Autowired
	private CategoriaServices serCat;
	
	@Autowired
	private ProveedorServices serProveedor;
	
	@Autowired
	private EstadoServices serEstado;
	
	@Autowired
	private DireccionProveedorServices serDireccion;
	
	@RequestMapping("/lista")
	public String listaProducto(Model model,HttpSession session) {
		
		List<Enlace> lista=(List<Enlace>) session.getAttribute("listaEnlaces");
		
		model.addAttribute("ProductoLista", serPro.listaProducto());
		model.addAttribute("listaEnlaces", lista);
		
		return "ProductoLista";
		
	}
	
	
	@RequestMapping("/editar")
	public String editarProducto(@RequestParam("codigo")int cod,Model model) {
		
		model.addAttribute("listaPorCodigo",serPro.productoXcodigo(cod) );
		model.addAttribute("listaCategoria", serCat.listaCategoria());
		model.addAttribute("listaDireccion", serDireccion.listaDeDireccion());
		model.addAttribute("listaEstado", serEstado.listaEstado());
		
				
		return "crudproductos";
		
	}
	
	
	@RequestMapping("/proveedorPorDireccion")
	@ResponseBody
	public List<Proveedor> listaProveedor(@RequestParam("cod")int cod){
				
	return	serProveedor.listaProvedorPorCodigoDireccion(cod);
		
	}
	
	
	@RequestMapping("/paraTraerElproveedor")
	@ResponseBody
	public Producto proveedor(@RequestParam("cod")int cod){
				
	return	serPro.productoXcodigo(cod);
		
	}
	
	
	@RequestMapping("/registrar")
	public String editarProducto(Model model) {
		model.addAttribute("listaPorCodigo",serPro.productoXcodigo(1) );
		model.addAttribute("listaCategoria", serCat.listaCategoria());
		model.addAttribute("listaDireccion", serDireccion.listaDeDireccion());
		model.addAttribute("listaEstado", serEstado.listaEstado());
		model.addAttribute("regla", "nulos");
				
		return "crudproductos";
		
	}
	
	@RequestMapping("/RegistrarEditar")
	public String RegistrarOEditarProducto(@RequestParam("codigo")int cod,
			                               @RequestParam("nombre")String nombre,
			                               @RequestParam("precio")double precio, 
			                               @RequestParam("descripcion")String des,
			                               @RequestParam("imagen")String imagen,
			                               @RequestParam("stock")int stock,
			                             
			                               @RequestParam("proveedor")int proveedor,
			                               @RequestParam("categoria.codigo")int cate,
			                               @RequestParam("estado.codigo")int estado,
			                               RedirectAttributes redirect) {
		
		
	try {
		
	Producto pro=new Producto();
		
		pro.setNombre(nombre);
		pro.setPrecio(precio);
		pro.setDescripcion(des);
		pro.setImagen(imagen);
		pro.setStock(stock);
		
		Proveedor pr=new Proveedor();
		
		pr.setCodigo(proveedor);
		
		pro.setProveedor(pr);
		
		Categoria ct=new Categoria();
		
		ct.setCodigo(cate);
		
		pro.setCategoria(ct);
		
		Estado es=new Estado();
		
		es.setCodigo(estado);
		
		pro.setEstado(es);
		
		
		if(cod==0) {
			
			serPro.RegistrarProducto(pro);
			redirect.addFlashAttribute("MENSAJE", "Producto Registrado");
			
		}else {
			pro.setCodigo(cod);
			serPro.ActualizarProducto(pro);
			redirect.addFlashAttribute("MENSAJE", "Producto Actualizado");
		}
			
			
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
		
	 return "redirect:/CrudProducto/lista";
		
	}
	
	
	@RequestMapping("/eliminar")
	public String EliminarProducto(@RequestParam("codigo")int cod,RedirectAttributes redirect) {
		
		serPro.EliminarProducto(cod);
		redirect.addFlashAttribute("MENSAJE", "Producto Eliminado");
		
		return "redirect:/CrudProducto/lista";
	}
	
	
	
	
	
	
}
