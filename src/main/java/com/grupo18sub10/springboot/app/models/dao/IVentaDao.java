package com.grupo18sub10.springboot.app.models.dao;



import org.springframework.data.repository.PagingAndSortingRepository;



import com.grupo18sub10.springboot.app.models.entity.Venta;

public interface IVentaDao extends PagingAndSortingRepository<Venta, Long>{
		
	
 }
