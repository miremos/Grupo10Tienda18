package com.grupo18sub10.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo18sub10.springboot.app.models.dao.IUsuarioDao;
import com.grupo18sub10.springboot.app.models.entity.Usuario;


@Service
public class UsuarioServiceImpl  implements IUsuarioService {
	
	@Autowired
	private IUsuarioDao usuariodao;

	@Override
	@Transactional(readOnly = true) // Anotacion que solo permite leer el metodo.
	public List<Usuario> findAll() {
		
		return (List<Usuario>) usuariodao.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		usuariodao.save(usuario);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(Long cedula_usuario) {
		
		return usuariodao.findById(cedula_usuario).orElse(null);
	}

	@Override
	@Transactional()
	public void delete(Long cedula_usuario) {
		usuariodao.deleteById(cedula_usuario);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		
		return usuariodao.findAll(pageable);
	}
	

}