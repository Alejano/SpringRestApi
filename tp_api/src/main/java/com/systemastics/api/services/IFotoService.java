package com.systemastics.api.services;


import java.util.List;


import com.systemastics.api.models.Foto;

public interface IFotoService {
	
	public List<Foto> findAll(); 
	
	public void save(Foto foto);
	
	public Foto findOne(Long foto);
	
	public void delete(Long foto);

	
}
