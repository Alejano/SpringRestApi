package com.systemastics.api.services;

import java.util.List;

import com.systemastics.api.models.Servicio;
import com.systemastics.api.models.UserPlus;

public interface IUserPlusService {
	public List<UserPlus> findAll(); 
	
	public void save(UserPlus user);
	
	public UserPlus findOne(Long user);
	
	public UserPlus findUserbyId(Long user);
	
	public void delete(Long user);
	
}
