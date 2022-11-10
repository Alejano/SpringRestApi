package com.systemastics.api.services;

import java.util.List;


import com.systemastics.api.models.Documento;

public interface IdocumentosService {
	public List<Documento> findAll(); 
	
	public void save(Documento documento);
	
	public Documento findOne(Long documento);
	
	public void delete(Long documento);
	
}
