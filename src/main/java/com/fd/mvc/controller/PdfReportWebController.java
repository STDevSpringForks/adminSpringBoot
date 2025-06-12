package com.fd.mvc.controller;

import com.fd.mvc.model.entity.Person;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fd.mvc.common.Constants.VIEW_PDF_REPORT;

@Controller
@RequestMapping("/reports")
public class PdfReportWebController {

    private static final Logger log = LoggerFactory.getLogger(PdfReportWebController.class);

    @RequestMapping("/viewPdfReport")
    public String viewPdfReport() {
        // Sample data
        Person person = new Person();
        person.setEmail("javier.hernandez@company.com");
        person.setFirstName("Javier");
        person.setGender("M");
        person.setLastName("Hernandez");

        Person person2 = new Person();
        person2.setEmail("rosa.salvaje@company.com");
        person2.setFirstName("Rosa");
        person2.setGender("F");
        person2.setLastName("Salvaje");

        List<Person> dataList = new ArrayList<>();
        dataList.add(person);
        dataList.add(person2);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("TITLE_REPORT", "Test Report");
        parameters.put("DATE_REPORT", LocalDate.now().toString());
        parameters.put("PERSON_LIST", dataList);

        try (OutputStream os = new FileOutputStream("C://tools/sample_report.pdf")) {
            String html = "<html><head><meta charset='UTF-8'></head><body>" +
                    "<h1>" + parameters.get("TITLE_REPORT") + "</h1>" +
                    "<p>Fecha: " + parameters.get("DATE_REPORT") + "</p>" +
                    "<ul>";
            for (Person p : dataList) {
                html += "<li>" + p.getFirstName() + " " + p.getLastName() + " - " + p.getEmail() + "</li>";
            }
            html += "</ul></body></html>";

            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(html, null);
            builder.toStream(os);
            builder.run();
        } catch (Exception e) {
            log.error("Error generating PDF", e);
        }

        return VIEW_PDF_REPORT;
    }
}
