package com.fd.ejercicios.data_service.service.impl;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.springframework.stereotype.Service;

import com.fd.ejercicios.data_service.service.RandomAccessFileService;

/**
 * 
 * @author Muguruza
 *
 */
@Service("randomAccessFileServiceImpl")
public class RandomAccessFileServiceImpl implements RandomAccessFileService {

	static RandomAccessFile fichero = null;
	
	/**
	 * http://www.w3api.com/wiki/Java:RandomAccessFile
	 */
	@Override
	public void addTextToFile() {
//        try {
//            //se abre el fichero para lectura y escritura
//            fichero = new RandomAccessFile("c:/adminSpringBoot/files/test.txt", "rw");
//            mostrarFichero(); //muestra el contenido original del fichero
//            System.out.print("Introducir cadena ");
//            fichero.seek(fichero.length()); //nos situamos al final del fichero
//            fichero.writeChars("Adios");       //se escribe el entero
//            mostrarFichero();//muestra el contenido del fichero después de añadir el número
//
//        } catch (FileNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        } finally {
//            try {
//                if (fichero != null) {
//                    fichero.close();
//                }
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//        }
		
		BufferedWriter out = null;   
		try {   
		    out = new BufferedWriter(new FileWriter("c:/adminSpringBoot/files/test.txt", true));   
		    out.write("Hola");   
		} catch (IOException e) {   
		    // error processing code   
		} finally {   
		    if (out != null) {   
		        try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
		    }   
		} 
		
	}
	
	private void mostrarFichero() {
        try {
            fichero.seek(0); //nos situamos al principio
            while (true) {
                System.out.println(fichero.readChar());
            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
	
}
