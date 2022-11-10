package com.systemastics.api.models.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.systemastics.api.models.Authority;
import com.systemastics.api.models.Mascota;
import com.systemastics.api.models.Servicio;


public interface IServicioDao extends CrudRepository<Servicio, Long>{
		
	@Query("SELECT s FROM Servicio AS s INNER JOIN s.serviciosUsuariosp AS su WHERE su.usuario.id = ?1 ")
	public List<Servicio> findAllUserServi(Long id_usuario);
	
	@Query("SELECT count(su.usuario.id) FROM Servicio AS s INNER JOIN s.serviciosUsuariosp AS su WHERE su.usuario.id = ?1 ")
	public int getsize(Long id_usuario);
}
