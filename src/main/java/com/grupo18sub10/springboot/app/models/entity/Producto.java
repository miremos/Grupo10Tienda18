package com.grupo18sub10.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "productos")
public class Producto implements Serializable {
	@NotNull
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo_producto;
	
	@NotNull
	private Double iva_compra;
	
	@NotNull
	private Long nit_proveedor;
	
	@NotEmpty
	private String nombre_producto;	
	
	@NotNull
	private Double precio_compra;
	
	@NotNull
	private Double precio_venta;
	
	private static final long serialVersionUID = 1L;


	public Long getId() {
		return codigo_producto;
	}

	public void setId(Long id) {
		this.codigo_producto = id;
	}

	public Double getIva_compra() {
		return iva_compra;
	}

	public void setIva_compra(Double iva_compra) {
		this.iva_compra = iva_compra;
	}

	public Long getNit_proveedor() {
		return nit_proveedor;
	}

	public void setNit_proveedor(Long nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(Double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public Double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(Double precio_venta) {
		this.precio_venta = precio_venta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	

	

	
 
	
}
