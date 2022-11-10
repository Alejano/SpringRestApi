package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systemastics.api.models.Mascota;
import com.systemastics.api.models.dao.IMascotaDao;

@Service
public class IMascotaServiceImpl implements IMascotaService {
	@Autowired
	private IMascotaDao mascotadao;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Mascota> findAll() {
		// TODO Auto-generated method stub
		return (List<Mascota>) mascotadao.findAll();
	}

	@Override
	public void save(Mascota mascota) {
		// TODO Auto-generated method stub
		mascotadao.save(mascota);
	}


	@Override
	@Transactional(readOnly = true)
	public Mascota findOne(Long mascota) {
		// TODO Auto-generated method stub
		return mascotadao.findById(mascota).orElse(null);
	}

	@Override
	public void delete(Long mascota) {
		// TODO Auto-generated method stub
		mascotadao.deleteById(mascota);
	}

	@Override
	public List<Mascota> misMascotas(Long id_usuario) {
		// TODO Auto-generated method stub
		return mascotadao.misMascotas(id_usuario);
	}
	

}
