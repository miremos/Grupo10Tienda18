package com.grupo18sub10.springboot.app.controllers;
import java.util.ArrayList;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo18sub10.springboot.app.models.dao.UsuarioDAO;
import com.grupo18sub10.springboot.app.models.entity.UsuarioDTO;




@RestController
public class UsuarioajaxController {
	
	@RequestMapping("/registrarUsuario")
	public void registrarUsuario(UsuarioDTO usuario) {		
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.registrarUsuario(usuario);	
	}
	
	@RequestMapping("/consultarUsuario")
	public ArrayList <UsuarioDTO> consultarUsuario (int documento){
		UsuarioDAO Dao = new UsuarioDAO();
		return Dao.consultarUsuario(documento);
	}
	
	@RequestMapping("/listarUsuario")
	public ArrayList <UsuarioDTO> listaDeUsuarios(){
		UsuarioDAO Dao = new UsuarioDAO();
		return Dao.listarUsuarios();
	}
	
	@RequestMapping("/eliminarUsuario")
	public void eliminarUsuario(int cedula) {
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.eliminarUsuario(cedula);
	}
	
	@RequestMapping("/editarUsuario")
	public void editarUsuario(UsuarioDTO usuario) {
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.editarUsuario(usuario);
	}
	
	
	


}
