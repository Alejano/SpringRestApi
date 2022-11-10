package com.systemastics.api.utilities;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class util {

	public static String obtenMes(int mes) {		
		String name="";
	      switch (mes){
	       case 1: name="Enero";
	               break;
	       case 2: name="Febrero";
	               break;
	       case 3: name="Marzo";
	               break;
	       case 4: name="Abril";
	               break;
	       case 5: name="Mayo";
	               break;
	       case 6: name="Junio";
	               break;
	       case 7: name="Julio";
	               break;
	       case 8: name="Agosto";
	               break;
	       case 9: name="Septiembre";
	               break;
	       case 10: name="Octubre";
	               break;
	       case 11: name="Noviembre";
	               break;
	       case 12: name="Diciembre";
	               break;
	       default: name = "Mes inválido";
	       break;
	       
	   }
	   	     
	     return name;
	   }
	
	public static boolean validarFecha(String fecha) {
	    boolean correcto = false;

	    try {
	        //Formato de fecha (día/mes/año)
	        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
	        formatoFecha.setLenient(false);
	        //Comprobación de la fecha
	        formatoFecha.parse(fecha);
	        correcto = true;
	    } catch (ParseException e) {
	        //Si la fecha no es correcta, pasará por aquí
	        correcto = false;
	    }

	    return correcto;
	}
	
	public static List<String> extractUrls(String text) { 
		List<String> containedUrls = new ArrayList<String>(); 
		String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)"; 
		Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE); 
		Matcher urlMatcher = pattern.matcher(text); while (urlMatcher.find()) { 
			containedUrls.add(text.substring(urlMatcher.start(0), urlMatcher.end(0))); 
			} 
		
		return containedUrls; 
	}


}
