package com.systemastics.api.services;


import java.util.List;

import com.systemastics.api.models.Mascota;

public interface IMascotaService {
	
	public List<Mascota> findAll(); 
	
	public void save(Mascota mascota);
	
	public Mascota findOne(Long mascota);
	
	public void delete(Long mascota);
	
	public List<Mascota> misMascotas(Long id_usuario); 

	
}
