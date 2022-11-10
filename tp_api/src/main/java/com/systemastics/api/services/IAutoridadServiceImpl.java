package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systemastics.api.models.Authority;
import com.systemastics.api.models.dao.IAuthorityDao;

@Service
public class IAutoridadServiceImpl implements IAutoridadService {
	@Autowired
	private IAuthorityDao authoritydao;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return (List<Authority>) authoritydao.findAll();
	}

	@Override
	public void save(Authority authority) {
		// TODO Auto-generated method stub
		authoritydao.save(authority);
	}


	@Override
	@Transactional(readOnly = true)
	public Authority findOne(Long authority) {
		// TODO Auto-generated method stub
		return authoritydao.findById(authority).orElse(null);
	}

	@Override
	public void delete(Long authority) {
		// TODO Auto-generated method stub
		authoritydao.deleteById(authority);
	}
	

}
