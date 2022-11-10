package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systemastics.api.models.Notificacion;
import com.systemastics.api.models.dao.INotificacionDao;

@Service
public class INotificacionServiceImpl implements INotificacionService {
	@Autowired
	private INotificacionDao notificaciondao;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Notificacion> findAll() {
		// TODO Auto-generated method stub
		return (List<Notificacion>) notificaciondao.findAll();
	}

	@Override
	public void save(Notificacion notificacion) {
		// TODO Auto-generated method stub
		notificaciondao.save(notificacion);
	}


	@Override
	@Transactional(readOnly = true)
	public Notificacion findOne(Long notificacion) {
		// TODO Auto-generated method stub
		return notificaciondao.findById(notificacion).orElse(null);
	}


	@Override
	public void delete(Long notificacion) {
		// TODO Auto-generated method stub
		notificaciondao.deleteById(notificacion);
	}

	@Override
	public List<Notificacion> relacion(Long amigo1, Long amigo2) {
		// TODO Auto-generated method stub
		return (List<Notificacion>) notificaciondao.relacion(amigo1, amigo2);
	}

	@Override
	public List<Notificacion> mynotifications(Long amigo1) {
		// TODO Auto-generated method stub
		return (List<Notificacion>) notificaciondao.mynotifications(amigo1);
	}

}
