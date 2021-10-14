package com.grupo18sub10.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.grupo18sub10.springboot.app.models.entity.Cliente;



public interface IClienteService {
	
    public List<Cliente> findAll();
    
    public Page<Cliente> findAll(Pageable pageable);
	
	public void save (Cliente cliente);
	
	public Cliente findOne(Long cedula_cliente);

	public void delete(Long cedula_cliente);

	//List<Cliente> buscarPorCedula_cliente(Long cedula_cliente);
	//List<Cliente> findByCedula_cliente(Long cedula_cliente);
//public Cliente findOne(String nombre_cliente);
	
	
}
