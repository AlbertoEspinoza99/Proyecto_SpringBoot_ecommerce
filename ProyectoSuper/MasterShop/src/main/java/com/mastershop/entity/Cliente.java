package com.mastershop.entity;

import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_cliente")
	private int codigo;
	@Column(name = "login_cliente")
	private String login;
	@Column(name = "password")
	private String claveCliente;
	@Column(name = "nombre_cliente")
	private String nombre;
	@Column(name = "apellido_cliente")
	private String apellido;
	
	@ManyToOne
	@JoinColumn(name = "cod_sexo")
	private Sexo sexo;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechanacimiento_cliente")
	private Date fecha;
	
	@Column(name = "rol_cliente")
	private String rol;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Boleta> ListaBoleta;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClaveCliente() {
		return claveCliente;
	}

	public void setClaveCliente(String claveCliente) {
		this.claveCliente = claveCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Boleta> getListaBoleta() {
		return ListaBoleta;
	}

	public void setListaBoleta(List<Boleta> listaBoleta) {
		ListaBoleta = listaBoleta;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public Cliente() {
		
	}
	
	public Cliente(int cod) {
		
		codigo=cod;
	}
	
	
	
	
}
