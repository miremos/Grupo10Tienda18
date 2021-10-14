package com.grupo18sub10.springboot.app.models.entity;

import java.io.Serializable;



import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;




@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cedula_usuario;
	
	@NotEmpty
	private String nombre_usuario;
	
	@NotEmpty
	@Email
	private String email_usuario;
	
	@NotEmpty	
	private String password;	
	
	@NotEmpty
	private String usuario;
	
	private static final long serialVersionUID = 1L;


	public Long getId() {
		return cedula_usuario;
	}

	public void setId(Long id) {
		this.cedula_usuario = id;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	

	
 
	
}
