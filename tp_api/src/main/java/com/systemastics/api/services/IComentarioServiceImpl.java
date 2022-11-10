package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systemastics.api.models.Comentario;
import com.systemastics.api.models.dao.IComentarioDao;

@Service
public class IComentarioServiceImpl implements IComentarioService {
	@Autowired
	private IComentarioDao comentariodao;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Comentario> findAll() {
		// TODO Auto-generated method stub
		return (List<Comentario>) comentariodao.findAll();
	}

	@Override
	public void save(Comentario comentario) {
		// TODO Auto-generated method stub
		comentariodao.save(comentario);
	}


	@Override
	@Transactional(readOnly = true)
	public Comentario findOne(Long comentario) {
		// TODO Auto-generated method stub
		return comentariodao.findById(comentario).orElse(null);
	}

	@Override
	public void delete(Long comentario) {
		// TODO Auto-generated method stub
		comentariodao.deleteById(comentario);
	}

	@Override
	public List<Comentario> findComentarios(Long userpost) {
		// TODO Auto-generated method stub
		return comentariodao.findComentarios(userpost);
	}
	

}
