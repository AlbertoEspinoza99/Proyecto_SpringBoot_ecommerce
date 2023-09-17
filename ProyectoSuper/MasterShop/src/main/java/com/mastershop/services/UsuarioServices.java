package com.mastershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastershop.dao.UsuarioRepository;
import com.mastershop.entity.Enlace;
import com.mastershop.entity.Usuario;

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository repo;
	
	public Usuario usuarioPorlogin(String login) {
		return repo.usuarioPorlogin(login);
	}
	
	public List<Enlace> listadeenlacePorCodigoRol(int cod){
		return repo.listaDeEnlaceporcodigoRol(cod);
	}
	
	
	public List<Usuario> listaUsuario(){
		return repo.findAll();
	}
	
	
	
	public Usuario uruarioPorCodigo(int obj) {
		return repo.usuarioPorCodigo(obj);
	}
	
	
	public void Registrar(Usuario obj) {
		repo.save(obj);
	}
	
	
	public void Actualizar(Usuario obj) {
		repo.save(obj);
	}
	
	public void EliminarUsuario(int cod) {
		repo.deleteById(cod);
	}
	
}
