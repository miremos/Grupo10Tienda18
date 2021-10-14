package com.grupo18sub10.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.grupo18sub10.springboot.app.models.dao.IVentaDao;

import com.grupo18sub10.springboot.app.models.entity.Venta;


@Service
public class VentaServiceImpl  implements IVentaService {
	
	@Autowired
	private IVentaDao ventadao;

	@Override
	@Transactional(readOnly = true) // Anotacion que solo permite leer el metodo.
	public List<Venta> findAll() {
		
		return (List<Venta>) ventadao.findAll();
	}

	@Override
	@Transactional
	public void save(Venta venta) {
		ventadao.save(venta);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Venta findOne(Long codigo_venta) {
		
		return ventadao.findById(codigo_venta).orElse(null);
	}

	@Override
	@Transactional()
	public void delete(Long codigo_venta) {
		ventadao.deleteById(codigo_venta);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Venta> findAll(Pageable pageable) {
		
		return ventadao.findAll(pageable);
	}

	

	

	

	

}