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
@Table(name = "tb_producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_producto")
	private int codigo;
	@Column(name = "nombre_producto")
	private String nombre;
	@Column(name = "descripcion_producto")
	private String descripcion;
	@Column(name = "precio_producto")
	private double precio;
	@Column(name = "imagen_producto")
	private String imagen;
	@Column(name = "stock_producto")
	private int stock;
	
	@ManyToOne
	@JoinColumn(name = "cod_categoria")
	private Categoria categoria;
	
	
	@ManyToOne
	@JoinColumn(name = "cod_proveedor")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "cod_estado")
	private Estado estado;
	
	@JsonIgnore
	@OneToMany(mappedBy = "producto")
	private List<DetalleBoleta> listaDetalleBoleta;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<DetalleBoleta> getListaDetalleBoleta() {
		return listaDetalleBoleta;
	}

	public void setListaDetalleBoleta(List<DetalleBoleta> listaDetalleBoleta) {
		this.listaDetalleBoleta = listaDetalleBoleta;
	}
	
	
	public Producto() {
		
	}
	
	public Producto(int cod) {
		codigo=cod;
	}
	
	
}
