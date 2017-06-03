package com.fd.criptocurrency.data_service.utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase de utilidad para BigDecimal
 * @author Muguruza
 *
 */
public class UtilsBigDecimal {

	private static final Logger LOGGER = LoggerFactory.getLogger(UtilsBigDecimal.class);
	
	/**
	 * Convertir un null a BigDecimal.Zero
	 * @param bigDecimal
	 * @return
	 */
	public static BigDecimal nullToZero(String bigDecimal){
		try{
			return bigDecimal == null ? BigDecimal.ZERO : new BigDecimal(bigDecimal);
		}catch(NumberFormatException nfe){
			LOGGER.error("Error al convertir String: "+bigDecimal+" a BigDecimal.",nfe);
			return BigDecimal.ZERO;
		}
	}
	
	/**
	 * Suma de BigDecimal: Varargs
	 * @param addends
	 * @return
	 */
	public static BigDecimal add(BigDecimal... addends) {
	    return Arrays.stream(addends)
	            .filter(Objects::nonNull)
	            .reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
}
