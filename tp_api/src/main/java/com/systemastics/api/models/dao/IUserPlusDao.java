package com.systemastics.api.models.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.systemastics.api.models.UserPlus;
import com.systemastics.api.models.UserPosts;


public interface IUserPlusDao extends CrudRepository<UserPlus, Long>{
	
	@Query("select p from UserPlus p inner join Usuario u on u.id = p.usuario.id where u.id = ?1 ")
	public List<UserPlus> findUserbyId(Long id_usuario);
}
