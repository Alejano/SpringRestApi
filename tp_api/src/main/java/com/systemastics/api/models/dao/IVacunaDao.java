/**
 * 
 */
package com.systemastics.api.models.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.systemastics.api.models.Usuario;
import com.systemastics.api.models.Vacuna;


public interface IVacunaDao extends CrudRepository<Vacuna, Long>{

	@Query("select d from Vacuna d inner join Mascota v on v.id = d.mascotas_id.id where v.id = ?1 ")
	public Vacuna findmascota(Long idmascota);
	
	@Query("select v from Vacuna v where v.id = ?1 ")
	public Vacuna findVacunaId(Long idvacuna);
}
