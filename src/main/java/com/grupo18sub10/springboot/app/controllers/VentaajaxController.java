package com.grupo18sub10.springboot.app.controllers;
import java.util.ArrayList;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.grupo18sub10.springboot.app.models.dao.VentaDAO;

import com.grupo18sub10.springboot.app.models.entity.VentaDTO;




@RestController
public class VentaajaxController {
	
	@RequestMapping("/registrarVenta")
	public void registrarVenta(VentaDTO venta) {		
		VentaDAO Dao = new VentaDAO();
		Dao.registrarVenta(venta);	
	}
	
	
	
	@RequestMapping("/consultarVenta")
	public ArrayList <VentaDTO> consultarUsuario (int documento){
		VentaDAO Dao = new VentaDAO();
		return Dao.consultarVenta(documento);
	}
	
	@RequestMapping("/listarVenta")
	public ArrayList <VentaDTO> listaDeUsuarios(){
		VentaDAO Dao = new VentaDAO();
		return Dao.listarVentas();
	}
	
	@RequestMapping("/eliminarVenta")
	public void eliminarUsuario(int cedula) {
		VentaDAO Dao = new VentaDAO();
		Dao.eliminarVenta(cedula);
	}
	
	@RequestMapping("/editarVenta")
	public void editarUsuario(VentaDTO usuario) {
		VentaDAO Dao = new VentaDAO();
		Dao.editarVenta(usuario);
	}
	
	
	


}
