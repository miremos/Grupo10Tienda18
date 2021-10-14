package com.grupo18sub10.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.grupo18sub10.springboot.app.models.entity.Proveedor;



public interface IProveedorService {
	
    public List<Proveedor> findAll();
    
    public Page<Proveedor> findAll(Pageable pageable);
	
	public void save (Proveedor proveedor);
	
	public Proveedor findOne(Long nit_proveedor);

	public void delete(Long nit_proveedor);

	//List<Cliente> buscarPorCedula_cliente(Long cedula_cliente);
	

}
