package com.systemastics.api.models.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.systemastics.api.models.Like;


public interface ILikeDao extends CrudRepository<Like, Long>{
	//SELECT CASE WHEN EXISTS (SELECT * FROM [User] WHERE UserID = 20070022)THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END
	//@Query("select u from Like u join UserPosts p on p = u.userposts where u.id_usuario = ?1 and p.id = ?2 ")
	//@Query("SELECT CASE WHEN (u.id_usuario = ?1 and p.id = ?2) THEN true ELSE false END from Like u join UserPosts p on p = u.userposts ")
	//public Boolean findLike(Long id_usuario,Long id_post);
	
	@Query("SELECT l from Like l join UserPosts p on p = l.userposts where p.id = ?2 and l.id_usuario = ?1")
	public Like findLike(Long id_usuario,Long id_post);
	
}
