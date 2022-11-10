/**
 * 
 */
package com.systemastics.api.models.dao;
import org.springframework.data.repository.CrudRepository;

import com.systemastics.api.models.Calificacion;
import com.systemastics.api.models.Usuario;


public interface ICalificacionDao extends CrudRepository<Calificacion, Long>{

}
