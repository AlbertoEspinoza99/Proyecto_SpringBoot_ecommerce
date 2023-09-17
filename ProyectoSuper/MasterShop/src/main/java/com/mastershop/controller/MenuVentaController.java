package com.mastershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mastershop.entity.Producto;
import com.mastershop.services.CategoriaServices;
import com.mastershop.services.MenuVentaServices;
import com.mastershop.services.ProductoServices;


@Controller
@RequestMapping("/servicio/MenuVenta")
public class MenuVentaController {

	@Autowired
	private MenuVentaServices serMenu;
	
	@Autowired
	private CategoriaServices serCat;
	
	@Autowired
	private ProductoServices serPro;
	
	@GetMapping("/lista")
	public String index(Model model) {
		
	model.addAttribute("listaMenu", serMenu.listaMenuVenta());
	model.addAttribute("listaCategoria",serCat.listaCategoria());
	model.addAttribute("listaProducto", serPro.listaProducto());
		
		return "principal";
	}
	
	
	@GetMapping("/buscarPorCategoria")
	@ResponseBody
	public List<Producto> listaPorCategoria(@RequestParam("codigo")Integer cod){
		
		return serPro.listaProductoXCategoria(cod);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
