package com.grupo18sub10.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.grupo18sub10.springboot.app.models.dao.IDetalleventaDao;

import com.grupo18sub10.springboot.app.models.entity.Detalleventa;


@Service
public class DetalleventaServiceImpl  implements IDetalleventaService {
	
	@Autowired
	private IDetalleventaDao detalleventadao;

	@Override
	@Transactional(readOnly = true) // Anotacion que solo permite leer el metodo.
	public List<Detalleventa> findAll() {
		
		return (List<Detalleventa>) detalleventadao.findAll();
	}

	@Override
	@Transactional
	public void save(Detalleventa detalleventa) {
		detalleventadao.save(detalleventa);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Detalleventa findOne(Long codigo_detalle_venta) {
		
		return detalleventadao.findById(codigo_detalle_venta).orElse(null);
	}

	@Override
	@Transactional()
	public void delete(Long codigo_detalle_venta) {
		detalleventadao.deleteById(codigo_detalle_venta);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Detalleventa> findAll(Pageable pageable) {
		
		return detalleventadao.findAll(pageable);
	}

	

	

	

	

}