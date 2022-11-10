package com.systemastics.api.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.core.io.Resource;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.systemastics.api.models.dao.IUploadDao;


@Service
public class UploadFileServiceImplement implements IUploadFileService {
	@Autowired 
	private IUploadDao uploadService;
		
	private final static String ruta= "c://opt//upload";
	private final static String rutaImportar= "c://opt//import";
	
	@Override
	public Model load(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String copy(MultipartFile file,String carpeta) throws IOException {
		String nombreUnico= UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		String dispacher ="";
		switch (carpeta) {
		case "IO":
				dispacher = ruta + "//IO";
			break;
		case "M":
				dispacher = ruta + "//mascotas";					
			break;
		case "U":
				dispacher = ruta + "//usuarios";			
			break;
		case "V":
				dispacher = ruta + "//vacunas";			
			break;	
		case "P":
			dispacher = ruta + "//productos";		
		break;	
		case "T":
			dispacher = ruta + "//timeline";			
		break;	
		
		}
				
		Path rutacompleta = Paths.get(dispacher + "//" + nombreUnico);
		
			Files.copy(file.getInputStream(), rutacompleta);
		
				return nombreUnico;
	}
	
	@Override
	public void copyImport(MultipartFile file) throws IOException {
		
		
		
		Path rutacompleta = Paths.get(rutaImportar + "//catalogo_servicios.csv");
		Files.copy(file.getInputStream(), rutacompleta);
		
	}

	@Override
	public boolean delete(String filename,String carpeta) {
		Path rutacompleta = getPath(filename,carpeta);
		File archivo = rutacompleta.toFile();
		
		if (archivo.exists()&& archivo.canRead()) {
			if (archivo.delete()) {
				return true;
			}
		}

		
		return false;
	}
	
	public Path getPath(String nombreunico,String carpeta) {
		
		String dispacher ="";
		switch (carpeta) {
		case "IO":
				dispacher = ruta + "//IO";
			break;
		case "M":
				dispacher = ruta + "//mascotas";					
			break;
		case "U":
				dispacher = ruta + "//usuarios";			
			break;
		case "V":
				dispacher = ruta + "//vacunas";			
			break;	
		case "P":
			dispacher = ruta + "//productos";			
		break;
		case "T":
			dispacher = ruta + "//timeline";			
		break;	
		
		}
		
		return Paths.get(dispacher + "//" + nombreunico);
	}

	@Override
	public void deleteall() {
		// TODO Auto-generated method stub
		uploadService.deleteAll();
	}

	@Override
	public void importarServicios() {
		// TODO Auto-generated method stub
		uploadService.importarServicios();
	}

}