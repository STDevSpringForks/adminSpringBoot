package com.fd.mvc.admin.data_service.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * 
 * @author Muguruza
 *
 */
public class BigDecimalConverter implements Converter<String, BigDecimal> {

	private static final Logger LOGGER = LoggerFactory.getLogger(BigDecimalConverter.class);

	@Override
	public BigDecimal convert(String source) {
		LOGGER.debug("BigDecimal convert ");
		if (StringUtils.hasText(source)) {
			try{
				return new BigDecimal(source);
			}catch(NumberFormatException nfe){
				return null;
			}
        }
		return null;
	}



}
