/**
 * 
 */
package com.systemastics.api.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.systemastics.api.models.Amigo;

public interface IAmigoDao extends CrudRepository<Amigo, Long>{
	
	@Query("select u from Amigo u where u.amigot = ?1 ")
	public Amigo findOneAmigo(Long amigo);
	
	@Query("select u from Amigo u where (u.amigo.id = ?1 and u.amigot = ?2) or (u.amigo.id = ?2 and u.amigot = ?1)")
	public Amigo relacion(Long amigo1, Long amigo2);
	

}
