package com.grupo18sub10.springboot.app.models.entity;

import java.io.Serializable;



import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;




@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
	//@NotNull
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cedula_cliente;
	
	@NotEmpty
	private String nombre_cliente;
	
	@NotEmpty
	private String direccion_cliente;
	
	@NotEmpty
	@Email
	private String email_cliente;	
	
	@NotEmpty
	private String telefono_cliente;
	
	private static final long serialVersionUID = 1L;


	public Long getId() {
		return cedula_cliente;
	}

	public void setId(Long id) {
		this.cedula_cliente = id;
	}

	

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public String getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
 
	
}
