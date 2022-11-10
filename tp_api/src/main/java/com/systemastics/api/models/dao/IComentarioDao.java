package com.systemastics.api.models.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.systemastics.api.models.Comentario;

public interface IComentarioDao extends CrudRepository<Comentario, Long>{
	
	@Query("select c from Comentario c join UserPosts u on c.userposts.id = u.id where u.id = ?1 ")
	public List<Comentario> findComentarios(Long userpost);
	
	
}
