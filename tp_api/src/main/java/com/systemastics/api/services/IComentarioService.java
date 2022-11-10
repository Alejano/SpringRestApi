package com.systemastics.api.services;

import java.util.List;

import com.systemastics.api.models.Comentario;

public interface IComentarioService {
	public List<Comentario> findAll(); 
	
	public void save(Comentario comentario);
	
	public Comentario findOne(Long comentario);
	
	public void delete(Long comentario);
	
	public List<Comentario> findComentarios(Long userpost);
	
}
