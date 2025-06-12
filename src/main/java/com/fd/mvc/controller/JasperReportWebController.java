package com.fd.mvc.controller;

import com.fd.mvc.model.entity.Person;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fd.mvc.common.Constants.VIEW_JASPER_REPORTS;

/**
 * https://www.tutorialspoint.com/jasper_reports/jasper_report_parameters.htm
 *
 */
@Controller
@RequestMapping("/reports")
public class JasperReportWebController {

    private static final Logger log = LoggerFactory.getLogger(JasperReportWebController.class);

    @RequestMapping("/viewJasperReport")
    public String viewJasperReport() {

        // TODO: jasperreports-5.0.1, need check api for version 6
        String sourceFileName = "C://tools/testReport.jasper";
        String printFileName = null;

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

        List<Person> dataList = new ArrayList<Person>();
        dataList.add(person);
        dataList.add(person2);

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("TITLE_REPORT", "Test Report");
        parameters.put("DATE_REPORT", LocalDate.now().toString());

        try {
            printFileName = JasperFillManager.fillReportToFile(sourceFileName, parameters, beanColDataSource);
            if (printFileName != null) {
                /**
                 * 1- export to PDF
                 */
                JasperExportManager.exportReportToPdfFile(printFileName, "C://tools/sample_report.pdf");

                /**
                 * 2- export to HTML
                 */
                JasperExportManager.exportReportToHtmlFile(printFileName, "C://tools/sample_report.html");

                // XLSX
                // PNG
                // DOCX
                // PPTX
                // RTF
                // ODT

            }
        } catch (JRException jre) {
            log.debug("Method: subReport", jre);
        }

        return VIEW_JASPER_REPORTS;

    }

}
