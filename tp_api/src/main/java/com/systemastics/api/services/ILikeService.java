package com.systemastics.api.services;

import java.util.List;

import com.systemastics.api.models.Like;

public interface ILikeService {
	public List<Like> findAll(); 
	
	public void save(Like likes);
	
	public Like findOne(Long likes);
	
	public void delete(Long likes);
	
	//public Boolean findLike(Long id_usuario,Long id_post);
	
	public Like findLike(Long id_usuario,Long id_post);
}
