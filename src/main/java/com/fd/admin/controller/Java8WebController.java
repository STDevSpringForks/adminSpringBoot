package com.fd.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping(value = "/java8")
public class Java8WebController {

	public String javalambda1(){
		
		Map<String,String> map = new HashMap<>();
		map.put("1","uno");
		map.put("2","dos");
		map.put("3","tres");
		map.put("4","cuatro");
		
		map.forEach((k,v)->{
			if("1".equals(k)){
				System.out.println(v);
			}
		});
		
		
		
		return "java8";
	}
	
}
