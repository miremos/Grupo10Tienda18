package com.grupo18sub10.springboot.app.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.grupo18sub10.springboot.app.models.entity.Producto;



public interface IProductoService {
	
    public List<Producto> findAll();
    public List<Producto> findAll(Long nit_proveedor);
    
    public Page<Producto> findAll(Pageable pageable);
	
	public void save (Producto producto);
	
	public Producto findOne(Long codigo_producto);
	public Optional<Producto> findTwo(Long nit_proveedor);
	
	public Producto findProducto(Long nit_proveedor);
	

	public void delete(Long codigo_producto);

	//List<Cliente> buscarPorCedula_cliente(Long cedula_cliente);
	List<Producto> findByNit_proveedor(Long nit_proveedor);
	

}
