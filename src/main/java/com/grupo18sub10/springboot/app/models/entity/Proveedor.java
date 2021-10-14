package com.grupo18sub10.springboot.app.models.entity;

import java.io.Serializable;



import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;




@Entity
@Table(name = "proveedores")
public class Proveedor implements Serializable {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nit_proveedor;
	
	@NotEmpty
	private String ciudad_proveedor;
	
	@NotEmpty
	private String direccion_proveedor;
	
	@NotEmpty
	private String nombre_proveedor;	
	
	@NotEmpty
	private String telefono_proveedor;
	
	private static final long serialVersionUID = 1L;


	public Long getId() {
		return nit_proveedor;
	}

	public void setId(Long id) {
		this.nit_proveedor = id;
	}
	

	public Long getNit_proveedor() {
		return nit_proveedor;
	}

	public void setNit_proveedor(Long nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}

	public String getCiudad_proveedor() {
		return ciudad_proveedor;
	}

	public void setCiudad_proveedor(String ciudad_proveedor) {
		this.ciudad_proveedor = ciudad_proveedor;
	}

	public String getDireccion_proveedor() {
		return direccion_proveedor;
	}

	public void setDireccion_proveedor(String direccion_proveedor) {
		this.direccion_proveedor = direccion_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getTelefono_proveedor() {
		return telefono_proveedor;
	}

	public void setTelefono_proveedor(String telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
	

	

	
 
	
}
