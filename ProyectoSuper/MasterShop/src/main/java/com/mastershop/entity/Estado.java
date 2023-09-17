package com.mastershop.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estadousuario")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_estado")
	private int codigo;
	@Column(name = "descripcion_estado")
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "estado")
	private List<Usuario> listaUsuario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "estado")
	private List<Boleta> listaboleta;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "estado")
	private List<Producto> listaProducto;


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}


	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}


	public List<Boleta> getListaboleta() {
		return listaboleta;
	}


	public void setListaboleta(List<Boleta> listaboleta) {
		this.listaboleta = listaboleta;
	}


	public List<Producto> getListaProducto() {
		return listaProducto;
	}


	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}
	
	
	public Estado() {
		
	}
	
	public Estado(int cod) {
		codigo=cod;
	}
	
	
	
}
