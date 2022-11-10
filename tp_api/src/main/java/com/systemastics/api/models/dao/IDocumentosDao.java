/**
 * 
 */
package com.systemastics.api.models.dao;
import org.springframework.data.repository.CrudRepository;

import com.systemastics.api.models.Documento;


public interface IDocumentosDao extends CrudRepository<Documento, Long>{

}
