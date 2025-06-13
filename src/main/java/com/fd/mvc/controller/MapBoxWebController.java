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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/api")
public class MapBoxWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapBoxWebController.class);
    private static final String VIEW_MAPBOX = "pages/api/viewMapBox";
    private static final Path EXCEL_FILE = Paths.get("Test.xls");
    private static final String SHEET_NAME = "NombreDeLaHoja";

    @GetMapping("/viewMapBox")
    public String viewMapBox(Model model) {
        try {
            Path filePath = createExcelFile();
            model.addAttribute("excelFilePath", filePath.toAbsolutePath().toString());
        } catch (IOException e) {
            LOGGER.error("Error generating Excel file", e);
            model.addAttribute("excelFilePath", "Error generando archivo Excel");
        }
        return VIEW_MAPBOX;
    }

    private Path createExcelFile() throws IOException {
        try (var workbook = new HSSFWorkbook()) {
            HSSFSheet sheet = workbook.createSheet(SHEET_NAME);

            for (int r = 0; r < 5; r++) {
                HSSFRow row = sheet.createRow(r);
                for (int c = 0; c < 5; c++) {
                    HSSFCell cell = row.createCell(c);
                    cell.setCellValue("Celda " + r + " " + c);
                }
            }

            sheet.shiftRows(0, sheet.getLastRowNum(), 5);

            HSSFRow header = sheet.createRow(0);
            for (int c = 0; c <= 5; c++) {
                header.createCell(c).setCellValue("--" + (c + 1) + "--newRowC---");
            }
            sheet.createRow(1).createCell(0).setCellValue("--2--newRow---");
            sheet.createRow(2).createCell(0).setCellValue("--3--newRow---");
            sheet.createRow(3).createCell(0).setCellValue("--4--newRow---");

            for (int c = 0; c <= 5; c++) {
                sheet.setColumnWidth(c, 30 * 256);
            }

            Path outputPath = EXCEL_FILE.toAbsolutePath();
            try (var out = Files.newOutputStream(outputPath)) {
                workbook.write(out);
            }
            LOGGER.info("Excel file generated at {}", outputPath);
            return outputPath;
        }
    }
}
