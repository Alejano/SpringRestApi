/**
 * 
 */
package com.systemastics.api.models.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.systemastics.api.models.Usuario;


public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	
	@Query("select u from Usuario u where u.username = ?1 ")
	public Usuario findUser(String usuario);
	
	public Usuario findByUsername(String usuario);
	
	@Query("select u.info from Usuario u where u.username = ?1 ")
	public String findinfo(String usuario);
	
	@Query("select u from Usuario u where u.apodo = ?1 ")
	public Usuario findApodo(String apodo);
	
	@Query("select u from UserPlus p inner join Usuario u on u.id = p.usuario.id where u.authority.id = 2 ")
	public List<Usuario> findUserPlus();
	
	@Query("select u from Usuario u where (u.apodo like %?1% or u.username like %?1% or u.nombre like %?1%) and u.username != ?2 ")
	public List<Usuario> findelse(String frase,String yo);
	
	@Query("select u from Usuario u join Amigo a on u.id = a.amigot where a.amigo.id = ?1 and a.relacion='amistad'")
	public List<Usuario> myfriends(Long id);
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Usuario c WHERE c.username= ?1")
	public boolean existsByUsername(String username);
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Usuario c WHERE c.correo = ?1")
	public boolean existsByEmail(String email);
	
	
	

}
