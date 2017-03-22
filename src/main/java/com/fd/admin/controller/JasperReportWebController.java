package com.fd.admin.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fd.admin.model.entity.PersonListDetailsEntity;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * https://www.tutorialspoint.com/jasper_reports/jasper_report_parameters.htm
 * @author Muguruza
 *
 */
@Controller
@RequestMapping("/reports")
public class JasperReportWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JasperReportWebController.class);
    private static final String VIEW_JASPER_REPORTS = "reports/viewJasperReport";

    @RequestMapping("/viewJasperReport")
    public String viewJasperReport() {

        // TODO: jasperreports-5.0.1, need check api for version 6
        String sourceFileName = "C://tools/testReport.jasper";
        String printFileName = null;

        PersonListDetailsEntity person = new PersonListDetailsEntity();
        person.setEmail("javier.hernandez@company.com");
        person.setFirstName("Javier");
        person.setGender("M");
        person.setLastName("Hernandez");

        PersonListDetailsEntity person2 = new PersonListDetailsEntity();
        person2.setEmail("rosa.salvaje@company.com");
        person2.setFirstName("Rosa");
        person2.setGender("F");
        person2.setLastName("Salvaje");

        List<PersonListDetailsEntity> dataList = new ArrayList<PersonListDetailsEntity>();
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
            LOGGER.debug("Method: subReport", jre);
        }

        return VIEW_JASPER_REPORTS;

    }

}
