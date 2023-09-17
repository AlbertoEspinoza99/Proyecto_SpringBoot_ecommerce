package com.mastershop.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DetalleBoletaPK implements Serializable{

	@Column(name = "cod_boleta")
	private int codigoBoleta;
	@Column(name = "cod_producto")
	private int codigoProducto;
	
	
	public int getCodigoBoleta() {
		return codigoBoleta;
	}
	public void setCodigoBoleta(int codigoBoleta) {
		this.codigoBoleta = codigoBoleta;
	}
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codigoBoleta, codigoProducto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleBoletaPK other = (DetalleBoletaPK) obj;
		return codigoBoleta == other.codigoBoleta && codigoProducto == other.codigoProducto;
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
