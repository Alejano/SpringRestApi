package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.systemastics.api.models.Foto;
import com.systemastics.api.models.dao.IFotoDao;

@Service
public class IFotoServiceImpl implements IFotoService {
	@Autowired
	private IFotoDao fotodao;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Foto> findAll() {
		// TODO Auto-generated method stub
		return (List<Foto>) fotodao.findAll();
	}

	@Override
	public void save(Foto foto) {
		// TODO Auto-generated method stub
		fotodao.save(foto);
	}


	@Override
	@Transactional(readOnly = true)
	public Foto findOne(Long foto) {
		// TODO Auto-generated method stub
		return fotodao.findById(foto).orElse(null);
	}

	@Override
	public void delete(Long foto) {
		// TODO Auto-generated method stub
		fotodao.deleteById(foto);
	}
	

}
