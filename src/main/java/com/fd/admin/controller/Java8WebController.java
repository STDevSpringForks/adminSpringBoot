package com.fd.admin.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
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
		System.out.println(multiArray2[1][10]);
		
		try{
			System.out.println(a3[1][-1]);
		}catch(ArrayIndexOutOfBoundsException aioobe){
			LOGGER.info("Dejarlo pasar: " + aioobe);
		}
		
		
		return "java8";
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
		
		//ListIterator remove
		
		return "java8";
	}
	
	
	
}
