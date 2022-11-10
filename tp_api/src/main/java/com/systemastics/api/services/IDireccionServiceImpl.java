package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systemastics.api.models.Direccion;
import com.systemastics.api.models.dao.IDireccionDao;

@Service
public class IDireccionServiceImpl implements IDireccionService {
	@Autowired
	private IDireccionDao Direcciondao;
	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Direccion> findAll() {
		// TODO Auto-generated method stub
		return (List<Direccion>) Direcciondao.findAll();
	}

	@Override
	public void save(Direccion direccion) {
		// TODO Auto-generated method stub
		Direcciondao.save(direccion);
	}


	@Override
	@Transactional(readOnly = true)
	public Direccion findOne(Long direccion) {
		// TODO Auto-generated method stub
		return Direcciondao.findById(direccion).orElse(null);
	}


	@Override
	public void delete(Long direccion) {
		// TODO Auto-generated method stub
		Direcciondao.deleteById(direccion);
	}



}
