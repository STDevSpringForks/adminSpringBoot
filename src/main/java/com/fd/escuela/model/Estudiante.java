package com.fd.escuela.model;

import java.util.ArrayList;

/**
 * Ejemplo de una clase Estudiante para conocer el promedio de una lista de calificaciones.
 * @author Muguruza
 *
 */
public class Estudiante {
	private ArrayList<Integer> scores;
	private double average;
	public static String ATRIBUTO_ESTATICO = "ESTATICO1";
	
//	public ArrayList<Integer> getScores() {
//		return this.scores;
//	}
	
	public ArrayList<Integer> getScores(){
		return new ArrayList<Integer>(scores);
	}
	
	public void setScores(ArrayList<Integer> scores) {
		this.scores = scores;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	
	private void computeAverage(){
        if(!this.scores.isEmpty()){
        	//valid code to compute average
            average = this.scores.stream().mapToInt(Integer::intValue).average().getAsDouble();
        }
    }

    public Estudiante(){
    	this.scores = new ArrayList<>();
        computeAverage();
    }
	
}
