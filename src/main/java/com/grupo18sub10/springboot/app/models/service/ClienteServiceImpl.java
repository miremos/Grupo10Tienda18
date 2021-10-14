package com.grupo18sub10.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo18sub10.springboot.app.models.dao.IClienteDao;
import com.grupo18sub10.springboot.app.models.entity.Cliente;


@Service
public class ClienteServiceImpl  implements IClienteService {
	
	@Autowired
	private IClienteDao clientedao;

	@Override
	@Transactional(readOnly = true) // Anotacion que solo permite leer el metodo.
	public List<Cliente> findAll() {
		
		return (List<Cliente>) clientedao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clientedao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long cedula_cliente) {
		
		return clientedao.findById(cedula_cliente).orElse(null);
	}

	@Override
	@Transactional()
	public void delete(Long cedula_cliente) {
		clientedao.deleteById(cedula_cliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		
		return clientedao.findAll(pageable);
	}

	

	

	

	

}