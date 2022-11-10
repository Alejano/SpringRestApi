package com.systemastics.api.services;


import java.util.List;

import com.systemastics.api.models.Amigo;
import com.systemastics.api.models.Usuario;

public interface IAmigoService {
	
	public List<Amigo> findAll(); 
	
	public void save(Amigo amigo);
	
	public Amigo findOne(Long amigo);
	
	public void delete(Long amigo);

	public Amigo findOneAmigo(Long amigo);

	public Amigo relacion(Long amigo1,Long amigo2);
	
	
}
