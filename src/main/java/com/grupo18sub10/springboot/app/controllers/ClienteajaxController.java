package com.grupo18sub10.springboot.app.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo18sub10.springboot.app.models.dao.ClienteDAO;
import com.grupo18sub10.springboot.app.models.entity.ClienteDTO;





@RestController
public class ClienteajaxController {
	
	@RequestMapping("/registrarCliente")
	public void registrarCliente(ClienteDTO cliente) {		
		ClienteDAO Dao = new ClienteDAO();
		Dao.registrarCliente(cliente);	
	}
	
	@RequestMapping("/consultarCliente")
	public ArrayList <ClienteDTO> consultarCliente (int documento){
		ClienteDAO Dao = new ClienteDAO();
		return Dao.consultarCliente(documento);
	}
	
	@RequestMapping("/listarCliente")
	public ArrayList <ClienteDTO> listaDeClientes(){
		ClienteDAO Dao = new ClienteDAO();
		return Dao.listarClientes();
	}
	
	@RequestMapping("/eliminarCliente")
	public void eliminarCliente(int cedula) {
		ClienteDAO Dao = new ClienteDAO();
		Dao.eliminarCliente(cedula);
	}
	
	@RequestMapping("/editarCliente")
	public void editarCliente(ClienteDTO cliente) {
		ClienteDAO Dao = new ClienteDAO();
		Dao.editarCliente(cliente);
	}


}
