package com.fd.admin.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

/**
 * http://docs.spring.io/spring/docs/4.0.4.RELEASE/spring-framework-reference/htmlsingle/#mvc-exceptionhandlers
 * @author Muguruza
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	private static final String VIEW_ERROR = "errors/error";
	
	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex){
		logger.info("SQLException Occured:: URL="+request.getRequestURL());
		System.out.println("GlobalExceptionHandler : SQLException Occured:: URL="+request.getRequestURL());
		return VIEW_ERROR;
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured.")
	@ExceptionHandler(IOException.class)
	public String handleIOException(HttpServletRequest request, Exception ex){
		logger.error("GlobalExceptionHandler: IOException handler executed:: URL="+request.getRequestURL(),ex);
		return VIEW_ERROR;
	}
	
//	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="El tamaño del archivo excede el limite del tamaño configurado.")
	@ExceptionHandler(MultipartException.class)
	public String handleMultipartException(HttpServletRequest request, Exception ex,Model model){
		logger.error("GlobalExceptionHandler: MultipartException handler executed:: URL="+request.getRequestURL(),ex);
		model.addAttribute("url",request.getRequestURL());
		model.addAttribute("exception",ex);
		return VIEW_ERROR;
	}
}
