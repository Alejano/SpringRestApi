package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.systemastics.api.models.Calificacion;
import com.systemastics.api.models.dao.ICalificacionDao;

@Service
public class ICalificacionServiceImpl implements ICalificacionService {
	@Autowired
	private ICalificacionDao calificaciondao;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Calificacion> findAll() {
		// TODO Auto-generated method stub
		return (List<Calificacion>) calificaciondao.findAll();
	}

	@Override
	public void save(Calificacion calificacion) {
		// TODO Auto-generated method stub
		calificaciondao.save(calificacion);
	}


	@Override
	@Transactional(readOnly = true)
	public Calificacion findOne(Long calificacion) {
		// TODO Auto-generated method stub
		return calificaciondao.findById(calificacion).orElse(null);
	}

	@Override
	public void delete(Long calificacion) {
		// TODO Auto-generated method stub
		calificaciondao.deleteById(calificacion);
	}
	

}
