package com.mastershop.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class RolEnlacePK implements Serializable{

	@Column(name = "cod_rol")
	private int codigoRol;
	@Column(name = "cod_enlace")
	private int codigoEnlace;
	
	
	public int getCodigoRol() {
		return codigoRol;
	}
	public void setCodigoRol(int codigoRol) {
		this.codigoRol = codigoRol;
	}
	public int getCodigoEnlace() {
		return codigoEnlace;
	}
	public void setCodigoEnlace(int codigoEnlace) {
		this.codigoEnlace = codigoEnlace;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codigoEnlace, codigoRol);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolEnlacePK other = (RolEnlacePK) obj;
		return codigoEnlace == other.codigoEnlace && codigoRol == other.codigoRol;
	}
	
	
	
	
	
}
