package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systemastics.api.models.Documento;
import com.systemastics.api.models.dao.IDocumentosDao;

@Service
public class IDocumentosServiceImpl implements IdocumentosService {
	@Autowired
	private IDocumentosDao documentosDao;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Documento> findAll() {
		// TODO Auto-generated method stub
		return (List<Documento>) documentosDao.findAll();
	}

	@Override
	public void save(Documento Documentos) {
		// TODO Auto-generated method stub
		documentosDao.save(Documentos);
	}


	@Override
	@Transactional(readOnly = true)
	public Documento findOne(Long Documentos) {
		// TODO Auto-generated method stub
		return documentosDao.findById(Documentos).orElse(null);
	}

	@Override
	public void delete(Long Documentos) {
		// TODO Auto-generated method stub
		documentosDao.deleteById(Documentos);
	}
	

}
