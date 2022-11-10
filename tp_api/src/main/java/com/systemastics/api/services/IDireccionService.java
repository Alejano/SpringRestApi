package com.systemastics.api.services;


import java.util.List;


import com.systemastics.api.models.Direccion;

public interface IDireccionService {
	
	public List<Direccion> findAll(); 
	
	public void save(Direccion direccion);
	
	public Direccion findOne(Long direccion);
	
	public void delete(Long direccion);

	
	
}
