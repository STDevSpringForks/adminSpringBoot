package com.fd.escuela.data_service.ifuncional;

import java.math.BigDecimal;

/**
 * Una interfaz funcional solo implementa un solo método.
 * @author Muguruza
 *
 */
@FunctionalInterface
public interface AreaTriangulo {
	public BigDecimal obtenerArea(BigDecimal base,BigDecimal altura);
}
