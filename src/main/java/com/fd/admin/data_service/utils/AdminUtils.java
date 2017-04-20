package com.fd.admin.data_service.utils;

import java.text.Normalizer;
import java.util.List;

/**
 * modificador de la interfaz public para que se pueda acceder desde cualquier paquete.
 * @author Muguruza
 *
 */
public interface AdminUtils {
	
	public static String getQuestionMarks(List<?> list){
		StringBuilder sb = new StringBuilder();
		int limit = 100000;
		if (list.size() < limit) {
			for (int a = 1; a <= list.size(); a++) {
				if (a == list.size()) {
					sb.append("?");
				} else {
					sb.append("?,");
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * Eliminando acentos creando un nuevo String inmutable = final.
	 * @param palabra
	 * @param typeDelAccents
	 * @return
	 */
	public static String eliminarAcentos(String palabra,String typeDelAccents){
		if ("Normalizer".equalsIgnoreCase(typeDelAccents)) {
			palabra = Normalizer.normalize(palabra, Normalizer.Form.NFD);
			palabra = palabra.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        } else {
        	palabra = org.apache.commons.lang3.StringUtils.stripAccents(palabra);
        }
		return palabra;
	}
	
	/**
	 * Eliminando acentos creando un nuevo String inmutable = final.
	 * Método por default: org.apache.commons.lang3.StringUtils.stripAccents
	 * @param palabra
	 * @return
	 */
	public static String eliminarAcentos(String palabra){
		return eliminarAcentos(palabra,null);
	}
	
	/**
	 * Remplazar por Objeto de referencia.
	 * @param frase
	 * @param typeDelAccents
	 */
	public static void eliminarAcentos(StringBuilder frase,String typeDelAccents){
		if ("Normalizer".equalsIgnoreCase(typeDelAccents)) {
			frase.replace(0,frase.length(),Normalizer.normalize(frase, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", ""));
        } else {
        	frase.replace(0,frase.length(),org.apache.commons.lang3.StringUtils.stripAccents(frase.toString()));
        }
	}
	
	/**
	 * Remplazar por Objeto de referencia. 
	 * Método por default: org.apache.commons.lang3.StringUtils.stripAccents
	 * @param frase
	 */
	public static void eliminarAcentos(StringBuilder frase){
		eliminarAcentos(frase,null);
	}
	
	
}
