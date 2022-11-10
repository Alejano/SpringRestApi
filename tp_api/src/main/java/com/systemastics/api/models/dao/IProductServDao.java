package com.systemastics.api.models.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.systemastics.api.models.ProductService;


public interface IProductServDao extends CrudRepository<ProductService, Long>{
	@Query("select u from ProductService u where u.usuariosp.id = ?1 ")
	public List<ProductService> findAlluserproducts(Long user);
	

}
