/**
 * 
 */
package com.systemastics.api.models.dao;
import org.springframework.data.repository.CrudRepository;

import com.systemastics.api.models.Foto;
import com.systemastics.api.models.Usuario;


public interface IFotoDao extends CrudRepository<Foto, Long>{

}
