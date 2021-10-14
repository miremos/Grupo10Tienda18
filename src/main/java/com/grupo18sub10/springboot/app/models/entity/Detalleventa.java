package com.grupo18sub10.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.validation.constraints.NotNull;



@Entity
@Table(name = "detalle_ventas")
public class Detalleventa implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo_detalle_venta;
	
	@NotNull	
	private Long cantidad_producto;
	
	@NotNull	
	private Long codigo_producto;
	
	@NotNull	
	private Long codigo_venta;	
	
	@NotNull
	private Double valor_total;
	
	@NotNull
	private Double valor_venta;
	
	@NotNull
	private Double valor_iva;
	
	private static final long serialVersionUID = 1L;


	public Long getId() {
		return codigo_detalle_venta;
	}

	public void setId(Long id) {
		this.codigo_detalle_venta = id;
	}

	public Long getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(Long cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public Long getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public Long getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}

	public Double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public Double getValor_iva() {
		return valor_iva;
	}

	public void setValor_iva(Double valor_iva) {
		this.valor_iva = valor_iva;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

	
 
	
}
