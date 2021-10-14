package com.grupo18sub10.springboot.app.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo18sub10.springboot.app.models.dao.ProductoDAO;
import com.grupo18sub10.springboot.app.models.entity.ProductoDTO;



@RestController
public class ProductoajaxController {
	
	@RequestMapping("/registrarProducto")
	public void registrarProducto(ProductoDTO producto) {		
		ProductoDAO Dao = new ProductoDAO();
		Dao.registrarProducto(producto);	
	}
	
	@RequestMapping("/consultarProducto")
	public ArrayList <ProductoDTO> consultarProducto (int codigo){
		ProductoDAO Dao = new ProductoDAO();
		return Dao.consultarProducto(codigo);
	}
	
	@RequestMapping("/listarProducto")
	public ArrayList <ProductoDTO> listaDeProductos(){
		ProductoDAO Dao = new ProductoDAO();
		return Dao.listarProductos();
	}
	
	@RequestMapping("/eliminarProducto")
	public void eliminarProducto(int codigo) {
		ProductoDAO Dao = new ProductoDAO();
		Dao.eliminarProducto(codigo);
	}
	
	@RequestMapping("/editarProducto")
	public void editarProducto(ProductoDTO producto) {
		ProductoDAO Dao = new ProductoDAO();
		Dao.editarProducto(producto);
	}

}
