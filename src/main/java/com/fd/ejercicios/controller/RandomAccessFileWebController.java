package com.fd.ejercicios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fd.ejercicios.data_service.service.RandomAccessFileService;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping("/files")
public class RandomAccessFileWebController {
	
	@Autowired
	private RandomAccessFileService randomAccessFileService;
	
	@GetMapping("/addTextToFile")
	public String addTextToFile(){
		randomAccessFileService.addTextToFile();
		return "";
	}
	
}
