/**
 * 
 */
package com.systemastics.api.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.systemastics.api.models.UserPosts;




public interface IUserPostsDao extends CrudRepository<UserPosts, Long>{
	
	@Query("select p from UserPosts p inner join Usuario u on u.id = p.usuarios.id where u.id = ?1 order by p.fecha desc")
	public List<UserPosts> finduserpost(Long id_usuario);
	
}
