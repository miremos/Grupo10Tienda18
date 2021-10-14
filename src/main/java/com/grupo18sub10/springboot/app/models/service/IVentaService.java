package com.grupo18sub10.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.grupo18sub10.springboot.app.models.entity.Venta;



public interface IVentaService {
	
    public List<Venta> findAll();
    
    public Page<Venta> findAll(Pageable pageable);
	
	public void save (Venta venta);
	
	public Venta findOne(Long codigo_venta);

	public void delete(Long codigo_venta);

	//List<Cliente> buscarPorCedula_cliente(Long cedula_cliente);
	//List<Cliente> findByCedula_cliente(Long cedula_cliente);
//public Cliente findOne(String nombre_cliente);
	
	
}
