package com.systemastics.api.services;


import java.util.List;

import com.systemastics.api.models.Vacuna;

public interface IVacunaService {
	
	public List<Vacuna> findAll(); 
	
	public void save(Vacuna vacuna);
	
	public Vacuna findOne(Long vacuna);
	
	public void delete(Long vacuna);

	public Vacuna findMascota(Long idmascota);

	public Vacuna findbyId(Long id_vacuna);
}
