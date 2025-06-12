package com.fd.mvc.common;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

/**
 * http://docs.spring.io/spring/docs/4.0.4.RELEASE/spring-framework-reference/htmlsingle/#mvc-exceptionhandlers
 * Spring’s @ControllerAdvice annotation is a specialized form of @Component 
 * The most common use case is to provide exception handlers,
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
        private static final String VIEW_ERROR = "error";
	
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
		
		/* C:\Users\satoshi\AppData\Local\Temp\   logging.file=   */
		System.out.println(System.getProperty("java.io.tmpdir")); 
		
		logger.error("GlobalExceptionHandler: MultipartException handler executed:: URL="+request.getRequestURL(),ex);
		model.addAttribute("url",request.getRequestURL());
		model.addAttribute("exception",ex);
		return VIEW_ERROR;
	}
	
	@ExceptionHandler(ServiceException.class)
	public String handleServiceException(HttpServletRequest request, Exception ex,Model model){
		logger.error("ServiceExceptionHandler: ServiceException handler executed:: URL="+request.getRequestURL(),ex);
		model.addAttribute("url",request.getRequestURL());
		model.addAttribute("exception",ex);
		return VIEW_ERROR;
	}
	
	//commons-fileupload
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleError2(MaxUploadSizeExceededException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        return "redirect:/uploadStatus";

    }
    
    @ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request, Exception ex,Model model){
		logger.error("ExceptionnHandler: Exception handler executed:: URL="+request.getRequestURL(),ex);
		model.addAttribute("url",request.getRequestURL());
		model.addAttribute("exception",ex);
		return VIEW_ERROR;
	}
	
}
