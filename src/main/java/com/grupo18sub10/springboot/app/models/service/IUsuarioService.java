package com.grupo18sub10.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.grupo18sub10.springboot.app.models.entity.Usuario;



public interface IUsuarioService {
	
    public List<Usuario> findAll();
    
    public Page<Usuario> findAll(Pageable pageable);
	
	public void save (Usuario usuario);
	
	public Usuario findOne(Long cedula_usuario);

	public void delete(Long cedula_usuario);

	

}
