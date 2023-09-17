package com.mastershop.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_proveedor")
	private int codigo;
	@Column(name = "descripcion_proveedor")
	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name = "cod_proveedor_con")
	private DireccionProveedor direccion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "proveedor")
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

	public DireccionProveedor getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionProveedor direccion) {
		this.direccion = direccion;
	}

	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}
	
	
	
	
	
	
}
