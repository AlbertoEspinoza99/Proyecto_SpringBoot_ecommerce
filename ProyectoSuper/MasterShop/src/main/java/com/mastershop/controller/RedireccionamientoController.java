package com.mastershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mastershop.entity.Cliente;
import com.mastershop.entity.Enlace;
import com.mastershop.entity.Usuario;
import com.mastershop.services.ClienteServices;
import com.mastershop.services.UsuarioServices;

@SessionAttributes({"codUsu","login","rol","listaEnlaces"})
@Controller
@RequestMapping("/ruta")
public class RedireccionamientoController {

	@Autowired
	private ClienteServices serCli;
	
	@Autowired
	private UsuarioServices serUsu;
	
	@RequestMapping("/direccion")
	public String ruta01(Authentication auth,Model model,RedirectAttributes redirect) {
		
		String vLogin=auth.getName();
		
		
		Cliente obj=serCli.clientexlogin(vLogin);
		Usuario obj2=serUsu.usuarioPorlogin(vLogin);
		
		
		
		
		if(obj==null && obj2!=null) {
			
			List<Enlace> listaenlace=serUsu.listadeenlacePorCodigoRol(obj2.getRol().getCodigo());
			
			model.addAttribute("codUsu",obj2.getCodigo());
			model.addAttribute("login",obj2.getLogin());
			model.addAttribute("listaEnlaces",listaenlace);
			model.addAttribute("rol",obj2.getRol().getDescripcion());

			
			return "principalcoorporacion";
		}else {
			
			model.addAttribute("codUsu",obj.getCodigo());
			model.addAttribute("login",obj.getLogin());
			model.addAttribute("rol",obj.getRol());
			
			return "redirect:/servicio/MenuVenta/lista";
		}
				
	}
	
	
	@RequestMapping("/direccion2")
	public String ruta02(Authentication auth,Model model,RedirectAttributes redirect) {
		
		String vLogin=auth.getName();
				
		Cliente obj=serCli.clientexlogin(vLogin);
		Usuario obj2=serUsu.usuarioPorlogin(vLogin);


		if(obj!=null && obj2==null) {
	
			model.addAttribute("codUsu",obj.getCodigo());
			model.addAttribute("login",obj.getLogin());
			return "pago";
			
		}else {
			
				redirect.addFlashAttribute("MENSAJE2", "ERROR : intentas ingresar con usuario corporativo");			
		}
		return "redirect:/servicio/MenuVenta/lista";
	}
	
	
	@RequestMapping("/direccion03")
	public String ruta03() {
		
		return "productoLista";
	}
	
	
	
	
	
}
