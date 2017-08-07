package com.fd.admin.controller;

import java.io.FileReader;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fd.admin.springdata.domain.Tareas;
import com.fd.admin.springdata.service.TareasService;


/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping(value = "/java8")
public class Java8WebController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Java8WebController.class);
	private ScriptEngineManager m;
	private ScriptEngine e;
	private Invocable invocador;

	class A { } class B extends A { } class C extends B { } class D extends C { }
	
	@Autowired
    @Qualifier("tareasServiceImpl")
    private TareasService tareasService;
	
	@RequestMapping(value = "/java8Testing",method = RequestMethod.GET)
	public String java8Testing(){
		
		LocalDateTime ldt = LocalDateTime.parse("2015-01-02T17:13:50");
		System.out.println(ldt.format(DateTimeFormatter.ISO_LOCAL_TIME));
		System.out.println(ldt.toString());

		//--------------------------
		LocalDateTime ld = LocalDateTime.of(2015, Month.OCTOBER, 31, 10, 0);  
		ZonedDateTime date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern")); 
		date = date.plus(Duration.ofDays(1)); 
		System.out.println(date);
		
		date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern")); 
		date = date.plus(Period.ofDays(1)); 
		System.out.println(date);
		//--------------------------
		
		System.out.println("--------------------->>>>");
		
//		Tareas tareas = new Tareas();
//    	tareas.setTarea("Nueva tarea desde spring-Data");
//    	tareasService.save(tareas);
    	
    	System.out.println(tareasService.findAll());
    	
    	System.out.println("--------------------->>>>");
		
		
		return "java8";
	}
	
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
	
	@RequestMapping(value = "/stream",method = RequestMethod.GET)
	public String stream(){
		probarStream();
		probarParalelo();
		return "java8";
	}
	
	private void probarStream(){
		List<Integer> numeros = new ArrayList<>();
		numeros.stream().forEach(System.out::println);
	}
	
	/**
	 * Asincrono.
	 */
	private void probarParalelo(){
		List<Integer> numeros = new ArrayList<>();
		numeros.parallelStream().forEach(System.out::println);
	}
	
	@RequestMapping(value = "/optional",method = RequestMethod.GET)
	public String optional(){
		probar();
		orElse(null);
		orElseThrow(null);
		isPresent("s");
		return "java8";
	}
	
	private void probar(){
		try{
			Optional op = Optional.empty();
			op.get();
		}catch(Exception e){
			System.out.println("No hay elemento");
		}
	}
	
	private void orElse(String valor){
		try{
			Optional<String> op = Optional.ofNullable(valor);
			System.out.println(op.orElse("Predeterminado"));
		}catch(Exception e){
			System.out.println("No hay elemento");
		}
	}
	
	private void orElseThrow(String valor){
		try{
			Optional<String> op = Optional.ofNullable(valor);
			System.out.println(op.orElseThrow(NumberFormatException::new));
		}catch(Exception e){
			System.out.println("No hay elemento");
		}
	}
	
	private void isPresent(String valor){
		try{
			Optional<String> op = Optional.ofNullable(valor);
			System.out.println(op.isPresent());
		}catch(Exception e){
			System.out.println("No hay elemento");
		}
	}
	
	
	@RequestMapping(value = "/map",method = RequestMethod.GET)
	public String map(){
		map_imprimir();
		
		Map<String,String> map = new HashMap<>();
		map.put("1","uno");
		map.put("2","dos");
		map.put("3","tres");
		
		map.putIfAbsent("3","EL TRES");
		map.computeIfPresent("4", (k,v) -> k+v);
		map.getOrDefault("5","valor por defecto");
		//recolectar
		Map<String,String> mapAux = 
				map.entrySet().stream()
				.filter(e -> e.getValue().contains("2"))
				.collect(Collectors.toMap(p-> p.getKey(),p -> p.getValue()));
				
		mapAux.entrySet().stream().forEach(System.out::println);		
		
		
		return "java8";
	}
	
	private void map_imprimir(){
		Map<String,String> map = new HashMap<>();
		map.put("1","uno");
		map.put("2","dos");
		map.put("3","tres");
		map.entrySet().stream().forEach(System.out::println);
	} 
	
	@RequestMapping(value = "/funcionesJava",method = RequestMethod.GET)
	public String funcionesJava(){
		System.out.println(this.saludo("Hola Pedro,").apply(" como estas? "));
		
		List<String> lista = new ArrayList<>();
		lista.add("Mito");
		lista.add("Code");
		lista.add("MitoCode");
		
		//filtrar(lista, System.out::println, 5, null);
		filtrar(lista, System.out::println, 0, "Code");
		
		m = new ScriptEngineManager();
		e = m.getEngineByName("nashorn");
		invocador = (Invocable)e;
		
		try {
			implementarInterfaz();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return "java8";
	}
	
	private void llamarFunciones() throws Exception {
		//e.eval("print('JS desde Java')");
		e.eval(new FileReader("src/main/java/com/mitocode/nashorn/archivo.js"));
		
		String rpta = (String) invocador.invokeFunction("calcular", "2", "3");		
		System.out.println(rpta);
		
		double rpta2 = (double) invocador.invokeFunction("calcular", 2, 3);
		System.out.println(rpta2);
	}
	
	private void implementarInterfaz() throws Exception {
		e.eval(new FileReader("src/main/java/com/mitocode/nashorn/archivo.js"));
		
		Object implementacion = e.get("hiloImpl");
		Runnable r = invocador.getInterface(implementacion, Runnable.class);				
		
		Thread th1 = new Thread(r);
		th1.start();
		
		Thread th2 = new Thread(r);
		th2.start();
	}
	
	private Function<String,String> saludo(String nombrePersona){
		return x -> nombrePersona + x;
	}
	
	
	public void filtrar(List<String> lista, Consumer<String> consumidor, int longitud, String cadena){
		//lista.stream().filter(this.establecerLogicaFiltro(longitud)).forEach(consumidor);
		lista.stream().filter(this.establecerLogicaFiltro(cadena)).forEach(consumidor);
	}
	
	public Predicate<String> establecerLogicaFiltro(int longitud){
		return texto -> texto.length() < longitud;
	}
	
	public Predicate<String> establecerLogicaFiltro(String cadena){
		return texto -> texto.contains(cadena);
	}
	
}
 