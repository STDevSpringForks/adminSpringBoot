package com.fd.admin.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping(value = "/java8")
public class Java8WebController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TwilioWebController.class);

	@RequestMapping(value = "/javalambda1",method = RequestMethod.GET)
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
		
		IntStream it= IntStream.of(1,2,3,4,5,6);
		System.out.println(it.sum());
		
        
        IntStream ita= IntStream.range(0, 100);
        ita.forEach(System.out::println);
		
		return "java8";
	}
	
	/**
	 * A multidimensional array can be asymmetrical;
	 * @return
	 */
	@RequestMapping(value = "/javaMultiArray",method = RequestMethod.GET)
	public String javaMultiArray(){
		
		int[][] a = new int[3][];
		int[] a1[] = new int[3][];
		int[] a2[] = {{1,2},{2,4}};
		int a3[][] = {{1,2},{2,4}};
		int multiArray2[][] = new int[][]{ {0, 1}, {3, 4, 5}};
		int multiArray22[][] = new int[2][3];
				
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		System.out.println(a3[1][1]);
		LOGGER.info(Arrays.toString(multiArray2));
		LOGGER.info(Arrays.toString(multiArray22));
		System.out.println(multiArray2[1][2]);
		
//		try{
//			System.out.println(a3[1][-1]);
//		}catch(ArrayIndexOutOfBoundsException aioobe){
//			LOGGER.info("Dejarlo pasar: " + aioobe);
//		}
		
		ArrayList<String> ejg = new ArrayList<>(); // line 4
		ejg.add("One"); // line 5
		ejg.add("Two"); // line 6
		System.out.println(ejg.contains(new String("One"))); // line 7
		System.out.println(ejg.indexOf("Two")); // line 8
		ejg.clear(); // line 9
		System.out.println(ejg); // line 10
//		System.out.println(ejg.get(1)); // line 11
		
		
		LocalDate paulBday = LocalDate.parse("2002‐07‐29");
		String printDate = LocalDate.parse("2057‐08‐11")
				.format(DateTimeFormatter.ISO_DATE_TIME);
				System.out.println(printDate);
				
		String line = "ab";
		
		for (int i=0; i < line.length(); ++i, printMethod())
			System.out.println(line.charAt(i));
		
//		for(;;)
//			System.out.println(1);
		
		
//		empArrList.removeIf(e ‐> e.getName().startsWith("S"));
				
		return "java8";
	}
	
	private static void printMethod() { 
		System.out.println("Happy"); 
	}
	
	/**
	 * When confused between ‘M’, ‘m’, ‘D’ and ‘d’, remember that that upper case letter represents
		bigger duration of period. So ‘M’ is for month and ‘m’ is for minutes. Similarly, ‘D’ represents day of year; ‘d’
		represents day of month.
	 * @return
	 */
	@RequestMapping(value = "/javaLocalDate",method = RequestMethod.GET)
	public String javaLocalDate(){
		
		LocalDate date = LocalDate.of(2057,8,11);
		LocalTime time = LocalTime.of(14,30,15);
		DateTimeFormatter d1 = DateTimeFormatter.ofPattern("y");
		DateTimeFormatter d2 = DateTimeFormatter.ofPattern("YYYY");
		DateTimeFormatter d3 = DateTimeFormatter.ofPattern("Y M D");
		DateTimeFormatter d4 = DateTimeFormatter.ofPattern("e");
		DateTimeFormatter t1 = DateTimeFormatter.ofPattern("H h m s");
		DateTimeFormatter t2 = DateTimeFormatter.ofPattern("'Time now:'HH mm a");
		System.out.println(d1.format(date));
		System.out.println(d2.format(date));
		System.out.println(d3.format(date));
		System.out.println(d4.format(date));
		System.out.println(t1.format(time));
		System.out.println(t2.format(time));
		
		return "java8";
	}
	
	@RequestMapping(value = "/javaListIterator",method = RequestMethod.GET)
	public String javaListIterator(){
		List<String> lista = new ArrayList<>();
		lista.add("Alfredo");
		lista.add("Lopez");
		lista.add("Tarzo");
		
		List<String> lista2 = lista;
		
	    Iterator<String> it = lista.listIterator();
	    while(it.hasNext()){
	    	if(it.next().equals("Lopez")){
	    		it.remove();
	    	}
	    }
	    System.out.println(lista);
	    
	    lista2.removeIf((x) -> x.equals("Lopez"));
	    
	    System.out.println(lista2);
		
		return "java8";
	}
	
	
	@RequestMapping(value = "/ordenarLista",method = RequestMethod.GET)
	public String ordenarLista(){
		List<String> listaString = new ArrayList<>();
		listaString.add("Ricardo");
		listaString.add("Alfredo");
		listaString.add("Fernando");
		listaString.add("Hilda");
		
		//Collections.sort(listaString,(o1,o2) -> o1.compareTo(o2));
		Collections.sort(listaString,String::compareToIgnoreCase);
		
		System.out.println(listaString);
		
		return "java8";
	}
	
}
 