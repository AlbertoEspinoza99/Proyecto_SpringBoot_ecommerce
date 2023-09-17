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
@Table(name = "tb_direccionproveedor")
public class DireccionProveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_proveedor")
	private int codigo;
	@Column(name = "descripcion_proveedor")
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "direccion")
	private List<Proveedor> listaProveedor;

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

	public List<Proveedor> getListaProveedor() {
		return listaProveedor;
	}

	public void setListaProveedor(List<Proveedor> listaProveedor) {
		this.listaProveedor = listaProveedor;
	}
	
	
	
	
	
}
