/**
 * 
 */
package com.systemastics.api.models.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.systemastics.api.models.Amigo;
import com.systemastics.api.models.Notificacion;



public interface INotificacionDao extends CrudRepository<Notificacion, Long>{
	
	@Query("select u from Notificacion u where u.usuarios.id = ?1 and u.destinatario = ?2")
	public List<Notificacion> relacion(Long amigo1, Long amigo2);
	
	@Query("select u from Notificacion u where u.destinatario = ?1")
	public List<Notificacion> mynotifications(Long amigo1);


}
