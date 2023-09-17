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
@Table(name = "tb_enlace")
public class Enlace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_enlace")
	private int codigo;
	private String descripcion;
	private String ruta;
	
	@JsonIgnore
	@OneToMany(mappedBy = "enlace")
	private List<RolEnlace> listaRol;

	
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

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public List<RolEnlace> getListaRol() {
		return listaRol;
	}

	public void setListaRol(List<RolEnlace> listaRol) {
		this.listaRol = listaRol;
	}
	
	
	
	
	
}
