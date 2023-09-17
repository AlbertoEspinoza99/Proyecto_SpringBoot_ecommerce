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
@Table(name = "tb_boleta")
public class Boleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_boleta")
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name = "cod_cliente")
	private Cliente cliente;
	
	
	@ManyToOne
	@JoinColumn(name = "cod_estado")
	private Estado estado;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_boleta")
	private Date fecha;
	
	@Column(name = "monto_boleta")
	private double monto;
	
	@JsonIgnore
	@OneToMany(mappedBy = "boleta")
	private List<DetalleBoleta> listaDetalleBoleta;

	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public List<DetalleBoleta> getListaDetalleBoleta() {
		return listaDetalleBoleta;
	}

	public void setListaDetalleBoleta(List<DetalleBoleta> listaDetalleBoleta) {
		this.listaDetalleBoleta = listaDetalleBoleta;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
