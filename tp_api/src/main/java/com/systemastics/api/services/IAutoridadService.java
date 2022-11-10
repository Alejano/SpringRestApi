package com.systemastics.api.services;

import java.util.List;

import com.systemastics.api.models.Authority;

public interface IAutoridadService {
	public List<Authority> findAll(); 
	
	public void save(Authority autority);
	
	public Authority findOne(Long autority);
	
	public void delete(Long usuario);
	
}
