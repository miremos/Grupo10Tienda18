package com.grupo18sub10.springboot.app.models.dao;



import org.springframework.data.repository.PagingAndSortingRepository;



import com.grupo18sub10.springboot.app.models.entity.Producto;

public interface IProductoDao extends PagingAndSortingRepository<Producto, Long>{
		
	
 }
