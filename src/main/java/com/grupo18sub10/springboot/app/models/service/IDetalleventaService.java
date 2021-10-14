package com.grupo18sub10.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.grupo18sub10.springboot.app.models.entity.Detalleventa;



public interface IDetalleventaService {
	
    public List<Detalleventa> findAll();
    
    public Page<Detalleventa> findAll(Pageable pageable);
	
	public void save (Detalleventa deatalleventa);
	
	public Detalleventa findOne(Long codigo_detalle_venta);

	public void delete(Long codigo_detalle_venta);

	//List<Cliente> buscarPorCedula_cliente(Long cedula_cliente);
	//List<Cliente> findByCedula_cliente(Long cedula_cliente);
//public Cliente findOne(String nombre_cliente);
	
	
}
