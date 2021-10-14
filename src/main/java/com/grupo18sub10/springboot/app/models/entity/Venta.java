package com.grupo18sub10.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;



@Entity
@Table(name = "ventas")
public class Venta implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo_venta;
	
	@NotNull	
	private Long cedula_cliente;
	
	@NotNull	
	private Long cedula_usuario;
	
	@NotNull	
	private Double iva_venta;	
	
	@NotNull	
	private Double total_venta;	
	
	@NotNull
	private Double valor_venta;
	
	private static final long serialVersionUID = 1L;


	public Long getId() {
		return codigo_venta;
	}

	public void setId(Long id) {
		this.codigo_venta = id;
	}

	public Long getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(Long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public Long getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(Long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public Double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(Double total_venta) {
		this.total_venta = total_venta;
	}

	public Double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}
	
	

	public Double getIva_venta() {
		return iva_venta;
	}

	public void setIva_venta(Double iva_venta) {
		this.iva_venta = iva_venta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	

	

	

	
 
	
}
