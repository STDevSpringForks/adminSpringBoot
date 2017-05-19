package com.fd.admin.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping("/streams")
public class StreamsWebController {

	static List<String> listaEquipos;
	static{
		listaEquipos = new ArrayList<>();
		listaEquipos.add("America");
		listaEquipos.add("Tijuana");
		listaEquipos.add("Morelia");
		listaEquipos.add("Toluca");
		listaEquipos.add("Guadalajara");
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/exStreams")
	public String exStreams(){
		filtrar();
		ordenar();
		transformar();
		stringList();
		stringSet();
		return "streams";
	}
	
	private void filtrar(){
		listaEquipos.stream().filter((x) -> x.startsWith("T")).forEach(System.out::println);
	}
	private void ordenar(){
		//listaEquipos.stream().sorted().forEach(System.out::println);;
		listaEquipos.stream().sorted((x,y) -> y.compareTo(x)).forEach(System.out::println);;
	}
	private void transformar(){
		//Con .map indicamos una transformacion.
		listaEquipos.stream().map(String::toUpperCase).forEach(System.out::println);
	}
	private void stringList(){
		List<String> stringList = new ArrayList<>();
		stringList.add("");
		stringList.add(null);
		
		try{
			stringList.removeIf(String::isEmpty);
		}catch(Throwable t){
			t.printStackTrace();
			System.out.println("Something went wring...");
		}
		
		System.out.println("List size: " + stringList.size());
		
	}
	
	private void stringSet(){
		Set<String> stringList = new HashSet<>();
		stringList.add("");
		stringList.add(null);
		
		try{
			stringList.removeIf(String::isEmpty);
		}catch(Throwable t){
			t.printStackTrace();
			System.out.println("Something went wring...");
		}
		
		System.out.println("Set size: " + stringList.size());
		
	}
	
}
