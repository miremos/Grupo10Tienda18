package com.grupo18sub10.springboot.app.controllers;
import java.util.ArrayList;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo18sub10.springboot.app.models.dao.DetalleDAO;

import com.grupo18sub10.springboot.app.models.entity.DetalleDTO;




@RestController
public class DetalleajaxController {
	
	@RequestMapping("/registrarDetalle")
	public void registrarUsuario(DetalleDTO detalle) {		
		DetalleDAO Dao = new DetalleDAO();
		Dao.registrDetalle(detalle);	
	}
	
	@RequestMapping("/consultarDetalle")
	public ArrayList <DetalleDTO> consultarUsuario (int documento){
		DetalleDAO Dao = new DetalleDAO();
		return Dao.consultarDetalle(documento);
	}
	
	@RequestMapping("/listarDetalle")
	public ArrayList <DetalleDTO> listaDeUsuarios(){
		DetalleDAO Dao = new DetalleDAO();
		return Dao.listarDetalles();
	}
	
	@RequestMapping("/eliminarDetalle")
	public void eliminarUsuario(int cedula) {
		DetalleDAO Dao = new DetalleDAO();
		Dao.eliminarDetalle(cedula);
	}
	
	@RequestMapping("/editarDetalle")
	public void editarUsuario(DetalleDTO usuario) {
		DetalleDAO Dao = new DetalleDAO();
		Dao.editarDetalle(usuario);
	}
	
	
	


}
