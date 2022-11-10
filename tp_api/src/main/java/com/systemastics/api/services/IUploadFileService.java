package com.systemastics.api.services;

import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	public Model load(String filename);
	public String copy(MultipartFile file,String carpeta)throws IOException ;
	public boolean delete(String filename,String carpeta);
	public void copyImport(MultipartFile file)throws IOException ;
	public void deleteall();
	public void importarServicios();
}
