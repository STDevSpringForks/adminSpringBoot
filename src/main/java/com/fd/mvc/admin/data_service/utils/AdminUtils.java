package com.fd.mvc.admin.data_service.utils;

import java.text.Normalizer;
import java.util.List;

/**
 * modificador de la interfaz public para que se pueda acceder desde cualquier paquete.
 * @author Muguruza
 *
 */
public interface AdminUtils {
	
	static String getQuestionMarks(List<?> list){
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
	static String eliminarAcentos(String palabra,String typeDelAccents){
		String auxPalabra = palabra;
		if ("Normalizer".equalsIgnoreCase(typeDelAccents)) {
			auxPalabra = Normalizer.normalize(auxPalabra, Normalizer.Form.NFD);
			auxPalabra = auxPalabra.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        } else {
        	auxPalabra = org.apache.commons.lang3.StringUtils.stripAccents(auxPalabra);
        }
		return auxPalabra;
	}
	
	/**
	 * Eliminando acentos creando un nuevo String inmutable = final.
	 * Método por default: org.apache.commons.lang3.StringUtils.stripAccents
	 * @param palabra
	 * @return
	 */
	static String eliminarAcentos(String palabra){
		return eliminarAcentos(palabra,null);
	}
	
	/**
	 * Remplazar por Objeto de referencia.
	 * @param frase
	 * @param typeDelAccents
	 */
	static void eliminarAcentos(StringBuilder frase,String typeDelAccents){
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
	static void eliminarAcentos(StringBuilder frase){
		eliminarAcentos(frase,null);
	}
	
	
}
