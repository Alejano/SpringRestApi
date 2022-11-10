package com.systemastics.api.services;

import java.util.List;

import com.systemastics.api.models.Servicio;

public interface IServicioService {
	public List<Servicio> findAll(); 
	
	public List<Servicio> findAllUserServi(Long usuario); 
	
	public void save(Servicio servicio);
	
	public Servicio findOne(Long servicio);
	
	public int getsize(Long usuario);
	
	public void delete(Long servicio);
	
}
