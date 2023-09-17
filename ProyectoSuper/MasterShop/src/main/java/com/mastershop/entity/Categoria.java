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
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_categoria")
	private Integer codigo;
	@Column(name = "descripcion_categoria")
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoria")
	private List<Producto> listaProducto;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	
	
	
	
	
}
