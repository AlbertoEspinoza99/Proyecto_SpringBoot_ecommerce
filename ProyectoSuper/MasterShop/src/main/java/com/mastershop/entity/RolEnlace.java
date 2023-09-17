package com.mastershop.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_rolenlace")
public class RolEnlace {

	@EmbeddedId
	private RolEnlacePK id;
	
	@ManyToOne
	@JoinColumn(name = "cod_rol",insertable = false,updatable = false,referencedColumnName = "cod_rol")
	private RolUsuario rol;
	
	
	@ManyToOne
	@JoinColumn(name = "cod_enlace",insertable = false,updatable = false,referencedColumnName = "cod_enlace")
	private Enlace enlace;


	public RolEnlacePK getId() {
		return id;
	}


	public void setId(RolEnlacePK id) {
		this.id = id;
	}


	public RolUsuario getRol() {
		return rol;
	}


	public void setRol(RolUsuario rol) {
		this.rol = rol;
	}


	public Enlace getEnlace() {
		return enlace;
	}


	public void setEnlace(Enlace enlace) {
		this.enlace = enlace;
	}
	
	
	
	
}
