package com.systemastics.api.services;

import java.util.List;

import com.systemastics.api.models.UserPosts;

public interface IUserPostsService {
	public List<UserPosts> findAll(); 
	
	public void save(UserPosts post);
	
	public UserPosts findOne(Long post);
	
	public void delete(Long post);
	
	public List<UserPosts> finduserpost(Long id_usuario);
	
}
