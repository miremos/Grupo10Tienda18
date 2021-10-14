package com.grupo18sub10.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.grupo18sub10.springboot.app.models.dao.IProveedorDao;

import com.grupo18sub10.springboot.app.models.entity.Proveedor;


@Service
public class ProveedorServiceImpl  implements IProveedorService {
	
	@Autowired
	private IProveedorDao proveedordao;

	@Override
	@Transactional(readOnly = true) // Anotacion que solo permite leer el metodo.
	public List<Proveedor> findAll() {
		
		return (List<Proveedor>) proveedordao.findAll();
	}

	@Override
	@Transactional
	public void save(Proveedor proveedor) {
		proveedordao.save(proveedor);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Proveedor findOne(Long nit_proveedor) {
		
		return proveedordao.findById(nit_proveedor).orElse(null);
	}

	@Override
	@Transactional()
	public void delete(Long nit_proveedor) {
		proveedordao.deleteById(nit_proveedor);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Proveedor> findAll(Pageable pageable) {
		
		return proveedordao.findAll(pageable);
	}

	

	
	

}