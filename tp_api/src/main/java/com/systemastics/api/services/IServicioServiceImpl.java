package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systemastics.api.models.Servicio;
import com.systemastics.api.models.dao.IServicioDao;

@Service
public class IServicioServiceImpl implements IServicioService {
	@Autowired
	private IServicioDao serviciodao;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Servicio> findAll() {
		// TODO Auto-generated method stub
		return (List<Servicio>) serviciodao.findAll();
	}

	@Override
	public void save(Servicio servicio) {
		// TODO Auto-generated method stub
		serviciodao.save(servicio);
	}


	@Override
	@Transactional(readOnly = true)
	public Servicio findOne(Long servicio) {
		// TODO Auto-generated method stub
		return serviciodao.findById(servicio).orElse(null);
	}

	@Override
	public void delete(Long servicio) {
		// TODO Auto-generated method stub
		serviciodao.deleteById(servicio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Servicio> findAllUserServi(Long usuario) {
		// TODO Auto-generated method stub
		return (List<Servicio>) serviciodao.findAllUserServi(usuario);
	}
	
	@Override
	@Transactional(readOnly = true)
	public int getsize(Long usuario) {
		// TODO Auto-generated method stub
		return  serviciodao.getsize(usuario);
	}
	

}
