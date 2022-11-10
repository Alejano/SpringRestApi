package com.systemastics.api.services;


import java.util.List;


import com.systemastics.api.models.Calificacion;

public interface ICalificacionService {
	
	public List<Calificacion> findAll(); 
	
	public void save(Calificacion calificacion);
	
	public Calificacion findOne(Long calificacion);
	
	public void delete(Long calificacion);

	
}
