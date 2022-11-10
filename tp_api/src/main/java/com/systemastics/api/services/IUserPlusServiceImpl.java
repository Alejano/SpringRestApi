package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systemastics.api.models.Servicio;
import com.systemastics.api.models.UserPlus;
import com.systemastics.api.models.dao.IUserPlusDao;

@Service
public class IUserPlusServiceImpl implements IUserPlusService {
	@Autowired
	private IUserPlusDao userplusdao;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<UserPlus> findAll() {
		// TODO Auto-generated method stub
		return (List<UserPlus>) userplusdao.findAll();
	}

	@Override
	public void save(UserPlus user) {
		// TODO Auto-generated method stub
		userplusdao.save(user);
	}


	@Override
	@Transactional(readOnly = true)
	public UserPlus findOne(Long user) {
		// TODO Auto-generated method stub
		return userplusdao.findById(user).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserPlus findUserbyId(Long user) {
		// TODO Auto-generated method stub
		return userplusdao.findById(user).orElse(null);
	}

	@Override
	public void delete(Long user) {
		// TODO Auto-generated method stub
		userplusdao.deleteById(user);
	}

}
