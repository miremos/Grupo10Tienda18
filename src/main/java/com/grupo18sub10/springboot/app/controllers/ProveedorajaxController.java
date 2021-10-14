package com.grupo18sub10.springboot.app.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo18sub10.springboot.app.models.dao.ProveedorDAO;
import com.grupo18sub10.springboot.app.models.entity.ProveedorDTO;



@RestController
public class ProveedorajaxController {
	
	@RequestMapping("/registrarProveedor")
	public void registrarProveedor(ProveedorDTO proveedor) {		
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.registrarProveedor(proveedor);	
	}
	
	@RequestMapping("/consultarProveedor")
	public ArrayList <ProveedorDTO> consultarProveedor (int documento){
		ProveedorDAO Dao = new ProveedorDAO();
		return Dao.consultarProveedor(documento);
	}
	
	@RequestMapping("/listarProveedor")
	public ArrayList <ProveedorDTO> listaDeProveedores(){
		ProveedorDAO Dao = new ProveedorDAO();
		return Dao.listarProveedores();
	}
	
	@RequestMapping("/eliminarProveedor")
	public void eliminarProveedor(int documento) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.eliminarProveedor(documento);
	}
	
	@RequestMapping("/editarProveedor")
	public void editarProveedor(ProveedorDTO proveedor) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.editarProveedor(proveedor);
	}


}
