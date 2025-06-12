package com.fd.mvc.controller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping(value = "/api")
public class MapBoxWebController {

    private static final String VIEW_MAPBOX = "pages/api/viewMapBox";
    private static final Logger LOGGER = LoggerFactory.getLogger(MapBoxWebController.class);
    
    @GetMapping("/viewMapBox")
    public String viewMapBox(Model model) {
    
    	/*
    	 String accessToken = "";
    	
    	 try {
             MapboxGeocoding.Builder builder = new MapboxGeocoding.Builder()
             .setAccessToken(accessToken)
             .setMode(GeocodingCriteria.MODE_PLACES)
             .setCountry("US") // US CA MX 
             .setLimit(1)
             .setLocation("1600 Pennsylvania Ave NW, Washington, DC 20500"); //White house

             Response<GeocodingResponse> response = builder.build().executeCall();
             double[] coordinates = response.body().getFeatures().get(0).getCenter();
             
             LOGGER.info(String.format("Found at '%f,%f'.", coordinates[0], coordinates[1]));
             
             //38.8976554,-77.1065698 Google
             
         } catch (Exception e) {
        	 LOGGER.error("Geocoding failed.", e);
         }
    	
         */
    	
    	try {
			writeXLSFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
        return VIEW_MAPBOX;
    }
    
    private void writeXLSFile() throws IOException {
		
		String excelFileName = "C://tools/Test.xls"; 	//Nombre del nuevo archivo a crear.
		String sheetName = "NombreDeLaHoja"; 			//Nombre de la hoja.

		HSSFWorkbook wb = new HSSFWorkbook();			//Creando el libro.
		HSSFSheet sheet = wb.createSheet(sheetName);	//Creando la hoja.

		//Iterando las filas=rows
		for (int numeroDeRow = 0; numeroDeRow<5 ; numeroDeRow++) {
			HSSFRow row = sheet.createRow(numeroDeRow);
	
			//Iterando las columnas=columns
			for (int numeroDeColumna=0;numeroDeColumna < 5; numeroDeColumna++ ) {
				HSSFCell cell = row.createCell(numeroDeColumna);
				cell.setCellValue("Celda " + numeroDeRow + " " + numeroDeColumna);
			}
			
		}
		
		
		//Start --- Creando una fila para añadirla al inicio.
		sheet.shiftRows(0, sheet.getLastRowNum(), 5);		//Insertamos 5 nuevas lineas desde la linea 0.
		
		HSSFRow row; 
		
		row = sheet.createRow(0);
		row.createCell(0).setCellValue("--1--newRowC---");
		row.createCell(1).setCellValue("--2--newRowC---");
		row.createCell(2).setCellValue("--3--newRowC---");
		row.createCell(3).setCellValue("--4--newRowC---");
		row.createCell(4).setCellValue("--5--newRowC---");
		row.createCell(5).setCellValue("--6--newRowC---");
		
		row = sheet.createRow(1);
		row.createCell(0).setCellValue("--2--newRow---");
		
		row = sheet.createRow(2);
		row.createCell(0).setCellValue("--3--newRow---");
		
		row = sheet.createRow(3);
		row.createCell(0).setCellValue("--4--newRow---");
		
		for(int a = 0;a<6;a++){
			//sheet.autoSizeColumn(a);
			sheet.setColumnWidth(a,30*256);
		}
		
		//End --- Creando una fila para añadirla al inicio.
		
		
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		
		//Write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
    
    
}
