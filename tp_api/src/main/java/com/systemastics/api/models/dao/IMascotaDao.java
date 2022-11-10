/**
 * 
 */
package com.systemastics.api.models.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.systemastics.api.models.Mascota;
import com.systemastics.api.models.Usuario;


public interface IMascotaDao extends CrudRepository<Mascota, Long>{
	
	@Query("select u from Mascota u where u.usuarios.id = ?1 ")
	public List<Mascota> misMascotas(Long id_usuario);

}
