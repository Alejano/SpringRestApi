package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systemastics.api.models.UserPosts;
import com.systemastics.api.models.dao.IUserPostsDao;

@Service
public class IUserPostsServiceImpl implements IUserPostsService {
	@Autowired
	private IUserPostsDao UserPostsdao;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<UserPosts> findAll() {
		// TODO Auto-generated method stub
		return (List<UserPosts>) UserPostsdao.findAll();
	}

	@Override
	public void save(UserPosts post) {
		// TODO Auto-generated method stub
		UserPostsdao.save(post);
	}


	@Override
	@Transactional(readOnly = true)
	public UserPosts findOne(Long post) {
		// TODO Auto-generated method stub
		return UserPostsdao.findById(post).orElse(null);
	}

	@Override
	public void delete(Long post) {
		// TODO Auto-generated method stub
		UserPostsdao.deleteById(post);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserPosts> finduserpost(Long id_usuario) {
		// TODO Auto-generated method stub
		return (List<UserPosts>) UserPostsdao.finduserpost(id_usuario);
	}
	

}
