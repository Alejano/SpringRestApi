package com.systemastics.api.models.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.systemastics.api.models.Documento;

public interface IUploadDao extends CrudRepository<Documento, Long> {
	/*@Modifying
    @Transactional
    @Query (value="LOAD DATA LOCAL INFILE 'C:/Users/Tester/Documents/transaction_data.txt' INTO TABLE tbl_fin FIELDS TERMINATED BY ',' IGNORE 1 LINES", nativeQuery = true)
    public void bulkLoadData();*/
	
	@Modifying
    @Transactional
	@Query (value="LOAD DATA LOCAL INFILE '/opt/import/catalogo_servicios.csv' INTO TABLE documentos FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' IGNORE 1 ROWS", nativeQuery = true)
	public void importarServicios();
}
