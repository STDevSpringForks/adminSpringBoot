package com.fd.admin.data_service.utils;

import java.math.BigDecimal;

/**
 * 
 * @author satoshi
 *
 */
public interface ConversionsUtils {
	
	public static BigDecimal LIBRA_X_KILO = new BigDecimal(0.453592);
	public static BigDecimal KILO_X_LIBRA = new BigDecimal(2.20462);
	
	default BigDecimal KilogramosALibras(BigDecimal kilogramos){
		return kilogramos.multiply(KILO_X_LIBRA);
	}
	
	default BigDecimal LibrasAKilogramos(BigDecimal libras){
		return libras.multiply(LIBRA_X_KILO);
	}
	
}
