package com.grupo18sub10.springboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.grupo18sub10.springboot.app.models.entity.Usuario;

public interface IUsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

}
