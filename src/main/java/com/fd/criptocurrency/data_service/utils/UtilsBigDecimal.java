package com.fd.criptocurrency.data_service.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
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
	
	
	public static String printDecimalFormatLocale(BigDecimal bigDecimal){
		DecimalFormat df = new DecimalFormat("$ #,###,##0.0000 MXN",new DecimalFormatSymbols(new Locale("es_MX")));
		return df.format(bigDecimal);
	}
	
	/**
	 * http://puntocomnoesunlenguaje.blogspot.com/2013/07/ejemplos-expresiones-regulares-java-split.html
	 * @param strDecimal
	 * @return
	 */
	public static String cleanBigDecimal(String strDecimal){
		return StringUtils.stripToEmpty(strDecimal.replaceAll("[^\\d\\. ]| \\.|\\.$",""));
	}
	
}
