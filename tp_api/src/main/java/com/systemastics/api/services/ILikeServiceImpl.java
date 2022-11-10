package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systemastics.api.models.Like;
import com.systemastics.api.models.dao.ILikeDao;

@Service
public class ILikeServiceImpl implements ILikeService {
	@Autowired
	private ILikeDao likedao;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Like> findAll() {
		// TODO Auto-generated method stub
		return (List<Like>) likedao.findAll();
	}

	@Override
	public void save(Like likes) {
		// TODO Auto-generated method stub
		likedao.save(likes);
	}


	@Override
	@Transactional(readOnly = true)
	public Like findOne(Long likes) {
		// TODO Auto-generated method stub
		return likedao.findById(likes).orElse(null);
	}

	@Override
	public void delete(Long likes) {
		// TODO Auto-generated method stub
		likedao.deleteById(likes);
	}
/*
	@Override
	@Transactional(readOnly = true)
	public Boolean findLike(Long id_usuario,Long id_post) {
		// TODO Auto-generated method stub
		boolean exist = false;
		exist = likedao.findLike(id_usuario,id_post);
		if(exist) {return true;}
		return false;
	}*/
	
	@Override
	@Transactional(readOnly = true)
	public Like findLike(Long id_usuario,Long id_post) {
		// TODO Auto-generated method stub
		return likedao.findLike(id_usuario,id_post);
	}
	

}
