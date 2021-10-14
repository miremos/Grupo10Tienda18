package com.grupo18sub10.springboot.app.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.grupo18sub10.springboot.app.models.dao.IProductoDao;

import com.grupo18sub10.springboot.app.models.entity.Producto;


@Service
public class ProductoServiceImpl  implements IProductoService {
	
	@Autowired
	private IProductoDao productodao;
	
	

	@Override
	@Transactional(readOnly = true) // Anotacion que solo permite leer el metodo.
	public List<Producto> findAll() {
		
		return (List<Producto>) productodao.findAll();
	}

	@Override
	@Transactional
	public void save(Producto producto) {
		productodao.save(producto);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findOne(Long codigo_producto) {
		
		return productodao.findById(codigo_producto).orElse(null);
	}

	@Override
	@Transactional()
	public void delete(Long codigo_producto) {
		productodao.deleteById(codigo_producto);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {
		
		return productodao.findAll(pageable);
	}

	@Override
	public Producto findProducto(Long nit_proveedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNit_proveedor(Long nit_proveedor) {
		// TODO Auto-generated method stub
		return (List<Producto>) productodao.findAll();
	}

	@Override
	public List<Producto> findAll(Long nit_proveedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findTwo(Long nit_proveedor) {
		// TODO Auto-generated method stub
		return productodao.findById(nit_proveedor);
	}

	

	

	

	
	

}