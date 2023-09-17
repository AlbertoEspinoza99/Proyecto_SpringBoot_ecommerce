package com.mastershop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_detallebotela")
public class DetalleBoleta {

	@EmbeddedId
	private DetalleBoletaPK id;
	
	@ManyToOne
	@JoinColumn(name = "cod_boleta",insertable = false,updatable = false,referencedColumnName = "cod_boleta")
	private Boleta boleta;
	
	
	@ManyToOne
	@JoinColumn(name = "cod_producto",insertable = false,updatable = false,referencedColumnName = "cod_producto")
	private Producto producto;
	
	
	@Column(name = "precio_detalle")
	private double precio;
	
	private int cantidad;

	public DetalleBoletaPK getId() {
		return id;
	}

	public void setId(DetalleBoletaPK id) {
		this.id = id;
	}

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
	
	
	
	
}
