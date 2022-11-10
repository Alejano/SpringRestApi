package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.systemastics.api.models.Vacuna;
import com.systemastics.api.models.dao.IVacunaDao;

@Service
public class IVacunaServiceImpl implements IVacunaService {
	@Autowired
	private IVacunaDao vacunadao;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Vacuna> findAll() {
		// TODO Auto-generated method stub
		return (List<Vacuna>) vacunadao.findAll();
	}

	@Override
	public void save(Vacuna vacuna) {
		// TODO Auto-generated method stub
		vacunadao.save(vacuna);
	}


	@Override
	@Transactional(readOnly = true)
	public Vacuna findOne(Long vacuna) {
		// TODO Auto-generated method stub
		return vacunadao.findById(vacuna).orElse(null);
	}

	@Override
	public void delete(Long vacuna) {
		// TODO Auto-generated method stub
		vacunadao.deleteById(vacuna);
	}

	@Override
	public Vacuna findMascota(Long idmascota) {
		// TODO Auto-generated method stub
		return vacunadao.findmascota(idmascota);
	}

	@Override
	public Vacuna findbyId(Long id_vacuna) {
		// TODO Auto-generated method stub
		return vacunadao.findVacunaId(id_vacuna);
	}
	

}
