package com.systemastics.api.services;


import java.util.List;

import com.systemastics.api.models.Notificacion;

public interface INotificacionService {
	
	public List<Notificacion> findAll(); 
	
	public void save(Notificacion notificacion);
	
	public Notificacion findOne(Long notificacion);
	
	public void delete(Long notificacion);

	public List<Notificacion> relacion(Long amigo1,Long amigo2);
	
	public List<Notificacion> mynotifications(Long amigo1); 
	
}
