/**
 * 
 */
package com.systemastics.api.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.systemastics.api.models.PedidoServicio;

public interface IPedidoDao extends CrudRepository<PedidoServicio, Long>{
	
	

}
