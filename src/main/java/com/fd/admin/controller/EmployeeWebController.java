package com.fd.admin.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fd.admin.data_service.exception.DefaultCheckedException;
import com.fd.admin.data_service.exception.EmployeeNotFoundException;
import com.fd.admin.model.Employee;

@Controller
public class EmployeeWebController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeWebController.class);
	
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	public String getEmployee(@PathVariable("id") int id, Model model) throws DefaultCheckedException {
		
		try{
			//deliberately throwing different types of exception
			if(id==1){
				throw new EmployeeNotFoundException(id);
			}else if(id==2){
				throw new SQLException("SQLException, id="+id);
			}else if(id==3){
				throw new IOException("IOException, id="+id);
			}else if(id==10){
				Employee emp = new Employee();
				emp.setName("Pankaj");
				emp.setId(id);
				model.addAttribute("employee", emp);
				return "home";
			}else {
				throw new DefaultCheckedException("Generic Exception, id="+id);
			}
		}catch(Exception e){
			logger.error("getEmployee",e);
			throw new DefaultCheckedException(e.getMessage());
		}
		
		
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
		logger.error("Requested URL="+request.getRequestURL(),ex);
		logger.error("Exception Raised=",ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}
	
//	@ExceptionHandler(EmployeeNotFoundException.class)
//	@ResponseBody 
//	public ExceptionJSONInfo handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
//		
//		ExceptionJSONInfo response = new ExceptionJSONInfo();
//		response.setUrl(request.getRequestURL().toString());
//		response.setMessage(ex.getMessage());
//		
//		return response;
//	}
	
}