package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systemastics.api.models.Amigo;
import com.systemastics.api.models.Usuario;
import com.systemastics.api.models.dao.IAmigoDao;
import com.systemastics.api.models.dao.IUsuarioDao;

@Service
public class IAmigoServiceImpl implements IAmigoService {
	@Autowired
	private IAmigoDao amigodao;
	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Amigo> findAll() {
		// TODO Auto-generated method stub
		return (List<Amigo>) amigodao.findAll();
	}

	@Override
	public void save(Amigo amigo) {
		// TODO Auto-generated method stub
		amigodao.save(amigo);
	}


	@Override
	@Transactional(readOnly = true)
	public Amigo findOne(Long amigo) {
		// TODO Auto-generated method stub
		return amigodao.findById(amigo).orElse(null);
	}


	@Override
	public void delete(Long amigo) {
		// TODO Auto-generated method stub
		amigodao.deleteById(amigo);
	}

	@Override
	@Transactional(readOnly = true)
	public Amigo findOneAmigo(Long amigo) {
		// TODO Auto-generated method stub
		return amigodao.findOneAmigo(amigo);
	}

	@Override
	public Amigo relacion(Long amigo1, Long amigo2) {
		// TODO Auto-generated method stub
		return amigodao.relacion(amigo1, amigo2);
	}


}
