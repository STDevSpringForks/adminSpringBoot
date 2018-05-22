//package com.fd.admin.data_service.service.impl;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.apache.pdfbox.cos.COSArray;
//import org.apache.pdfbox.cos.COSDictionary;
//import org.apache.pdfbox.cos.COSInteger;
//import org.apache.pdfbox.cos.COSName;
//import org.apache.pdfbox.cos.COSStream;
//import org.apache.pdfbox.cos.COSString;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDResources;
//import org.apache.pdfbox.pdmodel.common.PDRectangle;
//import org.apache.pdfbox.pdmodel.font.PDFont;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;
//import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
//import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
//import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
//import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary;
//import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
//import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
//import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
//import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
//import org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton;
//import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
//import org.apache.pdfbox.util.Matrix;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Service;
//
//import com.element.remarketing.common.RemarketingServiceErrorCode;
//import com.element.remarketing.dto.EmployeeVehiclePurchaseProgramRequest;
//import com.element.remarketing.dto.EmployeeVehiclePurchaseProgramResponse;
//import com.element.remarketing.dto.ErrorPair;
//import com.element.remarketing.service.GenerateDocumentService;
//
///**
// * 
// * @author AguilarF
// *
// */
//@Service("generateRemarketingReportServiceImpl")
//public class GenerateDocumentServiceImpl implements GenerateDocumentService {
//
//    private static final Logger LOGGER = LogManager.getLogger();
//
//    @Autowired
//    private Environment env;
//
//    @Override
//    public EmployeeVehiclePurchaseProgramResponse generatePDFEmployeeVehiclePurchaseProgram(EmployeeVehiclePurchaseProgramRequest request) {
//
//        COSStream offNStream = null;
//        COSStream onNStream = null;
//        PDDocument document = null;
//        
//        try {
//            // Reading the pdf file
//            document = PDDocument.load(new ClassPathResource(getInputFile(request)).getFile());
//
//            // ###################### PAGE 2 ######################
//
//            page02Section01Table(request, document);
//            page02Section02Buyer(document);
//            page02Section03Payer(document);
//
//            offNStream = new COSStream();
//            onNStream = new COSStream();
//            page02Section04SendTitle(offNStream, onNStream, document);
//
//            page02Section05Signature(document);
//
//            // ###################### PAGE 3 ######################
//            page03Section01ClientUnit(document);
//
//            page03Section02Declaration(document);
//
//            offNStream = new COSStream();
//            onNStream = new COSStream();
//            page03Section03CheckAndSignature(offNStream, onNStream, document);
//
//            document.save(getOutputFile(request));
//
//        } catch (IOException ie) {
//            LOGGER.error(ie);
//            return new EmployeeVehiclePurchaseProgramResponse(request.getQuoteID(), new ErrorPair(RemarketingServiceErrorCode.ERROR_IN_TRYING_TO_CREATE_NEW_DOCUMENT.getCode(), RemarketingServiceErrorCode.ERROR_IN_TRYING_TO_CREATE_NEW_DOCUMENT.getMessage()));
//        }finally {
//            if(offNStream != null) {
//                try {
//                    offNStream.close();
//                } catch (IOException e) {
//                    LOGGER.error(e);
//                }
//            }
//            if(onNStream != null) {
//                try {
//                    onNStream.close();
//                } catch (IOException e) {
//                    LOGGER.error(e);
//                }
//            }
//            if(document != null) {
//                try {
//                    document.close();
//                } catch (IOException e) {
//                    LOGGER.error(e);
//                }
//            }
//            
//        }
//
//        return new EmployeeVehiclePurchaseProgramResponse(request.getQuoteID());
//
//    }
//
//    private static void page03Section03CheckAndSignature(COSStream offNStream, COSStream onNStream, PDDocument document) throws IOException {
//        addEditableCheckboxToPDF(document, document.getPage(2),offNStream,onNStream, P3_EDIT_CHECK_HEREBY, COSName.Off.getName(), new PDRectangle(71, 335, 10, 10 ));
//        addEditableCheckboxToPDF(document, document.getPage(2),offNStream,onNStream, P3_EDIT_CHECK_MECHANICAL, COSName.Off.getName(), new PDRectangle(71, 307, 10, 10 ));
//        addEditableCheckboxToPDF(document, document.getPage(2),offNStream,onNStream, P3_EDIT_CHECK_NOT_ACTUAL_MILES, COSName.Off.getName(), new PDRectangle(71, 270, 10, 10 ));
//
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_OWNER_SIGNATURE, EMPTY_VALUE, new PDRectangle(192, 236, 130, 10 ));
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_OWNER_EMAIL, EMPTY_VALUE, new PDRectangle(356, 236, 99, 10 ));
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_OWNER_DATE, EMPTY_VALUE, new PDRectangle(485, 236, 57, 10 ));
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_SIGNATURE_ELEMENT_USER, EMPTY_VALUE, new PDRectangle(220, 211, 148, 10 ));
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_DATE_RECEIVED_ELEMENT, EMPTY_VALUE, new PDRectangle(486, 211, 53, 10 ));
//    }
//
//    private static void page03Section02Declaration(PDDocument document) throws IOException {
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_PRINT_PERSON_MAKING, EMPTY_VALUE, new PDRectangle(80, 408, 183, 10 ));
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_MILES, EMPTY_VALUE, new PDRectangle(154, 384, 98, 10 ));
//    }
//
//    private static void page03Section01ClientUnit(PDDocument document) throws IOException {
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_CLIENT, EMPTY_VALUE, new PDRectangle(128, 645, 180, 10 ));
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_UNIT, EMPTY_VALUE, new PDRectangle(348, 645, 193, 10 ));
//
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_YEAR, EMPTY_VALUE, new PDRectangle(101, 622, 40, 10 ));
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_MAKE, EMPTY_VALUE, new PDRectangle(175, 622, 60, 10 ));
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_MODEL, EMPTY_VALUE, new PDRectangle(266, 622, 66, 10 ));
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_BODY_TYPE, EMPTY_VALUE, new PDRectangle(388, 622, 63, 10 ));
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_VIN, EMPTY_VALUE, new PDRectangle(480, 622, 63, 10 ));
//
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_OWNERS_NAME, EMPTY_VALUE, new PDRectangle(188, 588, 351, 10 ));
//        addEditableFieldToPDF(document, document.getPage(2), P3_EDIT_OWNERS_ADDRESS, EMPTY_VALUE, new PDRectangle(199, 564, 341, 10 ));
//    }
//
//    private static void page02Section05Signature(PDDocument document) throws IOException {
//        // ----
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_PURCHASERS_SIGNATURE, EMPTY_VALUE, new PDRectangle(141, 99, 231, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_PURCHASERS_SIGNATURE_DATE, EMPTY_VALUE, new PDRectangle(390, 99, 85, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_SELLER_ACCEPTANCE, EMPTY_VALUE, new PDRectangle(190, 81, 181, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_SELLER_ACCEPTANCE_DATE, EMPTY_VALUE, new PDRectangle(390, 81, 85, 10 ));
//    }
//
//    private static void page02Section04SendTitle(COSStream offNStream, COSStream onNStream, PDDocument document) throws IOException {
//        addEditableRadioButtonToPDF(document, document.getPage(1),offNStream,onNStream,P2_EDIT_RADIO_BOTH, new int[] { 205, 265, 9, 9 }, new int[] { 207, 330, 435 });
//
//        // Send Title To ------------------------------
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_SEND_TO_FIRST, EMPTY_VALUE, new PDRectangle(72, 243, 81, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_SEND_TO_MIDDLE, EMPTY_VALUE, new PDRectangle(154, 243, 84, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_SEND_TO_LAST, EMPTY_VALUE, new PDRectangle(240, 243, 86, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_SEND_TO_STREET_ADDRESS, EMPTY_VALUE, new PDRectangle(377, 243, 150, 10 ));
//
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_SEND_TO_CITY, EMPTY_VALUE, new PDRectangle(72, 215, 80, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_SEND_TO_STATE, EMPTY_VALUE, new PDRectangle(152, 215, 68, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_SEND_TO_ZIP_CODE, EMPTY_VALUE, new PDRectangle(220, 215, 76, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_SEND_TO_TELEPHONE, EMPTY_VALUE, new PDRectangle(378, 215, 150, 10 ));
//    }
//
//    private static void page02Section03Payer(PDDocument document) throws IOException {
//        // Payer ------------------------------
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_PAYER_FIRST, EMPTY_VALUE, new PDRectangle(250, 394, 95, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_PAYER_MIDDLE, EMPTY_VALUE, new PDRectangle(346, 394, 86, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_PAYER_LAST, EMPTY_VALUE, new PDRectangle(434, 394, 95, 10 ));
//
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_PAYER_STREET_ADDRESS, EMPTY_VALUE, new PDRectangle(76, 367, 295, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_PAYER_DATE_OF_BIRTH, EMPTY_VALUE, new PDRectangle(378, 367, 152, 10 ));
//
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_PAYER_CITY, EMPTY_VALUE, new PDRectangle(72, 335, 77, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_PAYER_STATE, EMPTY_VALUE, new PDRectangle(150, 335, 74, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_PAYER_ZIP_CODE, EMPTY_VALUE, new PDRectangle(225, 335, 72, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_PAYER_COUNTY, EMPTY_VALUE,new PDRectangle(299, 335, 69, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_PAYER_TAXPAYER_NUMBER, EMPTY_VALUE, new PDRectangle(378, 335, 152, 10 ));
//
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_PAYER_HOME_PHONE_WORK_PHONE, EMPTY_VALUE, new PDRectangle(72, 307, 220, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_LABEL_PAYER_HOME_PHONE_WORK_PHONE, "Home Phone          Work Phone", new PDRectangle(72, 292, 220, 10 )); // Possible change by User: "Daytime Phone"
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_PAYER_RELATIONSHIP, EMPTY_VALUE, new PDRectangle(378, 307, 150, 10 ));
//    }
//
//    private static void page02Section02Buyer(PDDocument document) throws IOException {
//        // Buyer ------------------------------
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_BUYER_FIRST, EMPTY_VALUE, new PDRectangle(144, 499, 75, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_BUYER_MIDDLE, EMPTY_VALUE, new PDRectangle(220, 499, 75, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_BUYER_LAST, EMPTY_VALUE, new PDRectangle(296, 499, 75, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_BUYER_DATE_OF_BIRTH, EMPTY_VALUE, new PDRectangle(397, 499, 140, 10 ));
//
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_BUYER_STREET_ADDRESS, EMPTY_VALUE, new PDRectangle(76, 470, 297, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_BUYER_HOME_PHONE_WORK_PHONE, EMPTY_VALUE, new PDRectangle(380, 470, 151, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_LABEL_BUYER_HOME_PHONE_WORK_PHONE, "Home Phone          Work Phone", new PDRectangle(380, 458, 151, 10 )); // Possible change by User: "Daytime Phone"
//
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_BUYER_CITY, EMPTY_VALUE, new PDRectangle(76, 442, 73, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_BUYER_STATE, EMPTY_VALUE, new PDRectangle(150, 442, 70, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_BUYER_ZIP_CODE, EMPTY_VALUE, new PDRectangle(221, 442, 68, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_BUYER_COUNTY, EMPTY_VALUE, new PDRectangle(289, 442, 80, 10 ));
//        addEditableFieldToPDF(document, document.getPage(1), P2_EDIT_BUYER_EMAIL_ADDRESS, EMPTY_VALUE, new PDRectangle(380, 442, 152, 10 ));
//    }
//
//    private static void page02Section01Table(EmployeeVehiclePurchaseProgramRequest request, PDDocument document) throws IOException {
//        addFieldToPDF(document, document.getPage(1), P2_EMPLOYEE_NAME, request.getEmployeeName(), new PDRectangle(69, 661, 155, 50),true);
//        
//        addFieldToPDF(document, document.getPage(1), P2_CLIENT, request.getClient(), new PDRectangle(420, 676, 200, 50 ));
//        addFieldToPDF(document, document.getPage(1), P2_UNIT, request.getUnit(), new PDRectangle(480, 676, 200, 50 ));
//
//        String p2YearP2MakeP2Model = request.getYear() + " / " + request.getMake() + " / " + request.getModel();
//        addFieldToPDF(document, document.getPage(1), P2_YEAR_P2_MAKE_P2_MODEL, p2YearP2MakeP2Model, new PDRectangle(420, 665, 400, 50 ));
//
//        addFieldToPDF(document, document.getPage(1), P2_VIN, request.getVin(), new PDRectangle(420, 654, 400, 50 ));
//        addFieldToPDF(document, document.getPage(1), P2_BASE_PRICE, request.getBasePrice(), new PDRectangle(420, 642, 400, 50 ));
//        addFieldToPDF(document, document.getPage(1), P2_SALES_TAX, request.getSalesTax(), new PDRectangle(420, 631, 400, 50 ));
//        addFieldToPDF(document, document.getPage(1), P2_ADMINISTRATION_FEE, request.getAdministrationFEE(), new PDRectangle(420, 620, 400, 50 ));
//        addFieldToPDF(document, document.getPage(1), P2_EXPRESS_MAIL_FEE, request.getExpressMailFEE(), new PDRectangle(420, 609, 400, 50 ));
//        addFieldToPDF(document, document.getPage(1), P2_OFFER_PRICE, request.getOfferPrice(), new PDRectangle(420, 598, 400, 50 ));
//
//        StringBuilder sbP2CityP2StateP2ZipCode = new StringBuilder(IF_THE_VEHICLE_WILL_NOT_BE_REGISTERED_IN)
//        .append(request.getCity()).append(", ")
//        .append(request.getState()).append(", ")
//        .append(request.getZipCode()).append(PLEASE_CALL_ELEMENT_AT_800_328_0244);
//        addFieldMultiLineToPDF(document, document.getPage(1),P2_CITY_P2_STATE_P2_ZIP_CODE, sbP2CityP2StateP2ZipCode.toString(),new PDRectangle(69, 550, 470, 60 ));
//    }
//
//    private String getOutputFile(EmployeeVehiclePurchaseProgramRequest request) {
//        return env.getProperty(REMARKETING_DOCUMENTS) + "/" + request.getQuoteID() + "_" + env.getProperty(EXPORT_EVPP_7_1);
//    }
//
//    private String getInputFile(EmployeeVehiclePurchaseProgramRequest request) {
//        return "Y".equalsIgnoreCase(request.getClientPolicy()) ? env.getProperty(EVPP_7_1FLAYER) : env.getProperty(EVPP_7_1);
//    }
//    
//    private static void addFieldToPDF(PDDocument document, PDPage page, String paramName, String paramValue,PDRectangle rect) throws IOException {
//        addFieldToPDF(document, page, paramName, paramValue, rect, false);
//    }
//    
//    private static void addFieldToPDF(PDDocument document, PDPage page, String paramName, String paramValue,PDRectangle rect,boolean multiLine) throws IOException {
//        PDAcroForm form = new PDAcroForm(document);
//
//        PDFont font = PDType1Font.HELVETICA_BOLD;
//        PDResources resources = new PDResources();
//        resources.put(COSName.getPDFName("Helv"), font);
//        form.setDefaultResources(resources);
//
//        PDTextField textField = new PDTextField(form);
//        textField.setDefaultAppearance(HELV_TF_0_0_0_RG); // 0 0 0 [RGB color]
//        textField.setPartialName(paramName);
//        textField.setMultiline(multiLine);
//        textField.setReadOnly(true);
//
//        form.getFields().add(textField);
//
//        PDAnnotationWidget widget = textField.getWidgets().get(0);
//
//        widget.setRectangle(rect);
//
//        // set after adding PDRectangle
//        textField.setValue(paramValue);
//
//        widget.setPage(page);
//        widget.setPrinted(true);
//
//        page.getAnnotations().add(widget);
//    }
//
//    private static void addFieldMultiLineToPDF(PDDocument document, PDPage page, String paramName, String paramValue, PDRectangle rect) throws IOException {
//        PDAcroForm form = new PDAcroForm(document);
//
//        PDFont font = PDType1Font.TIMES_ROMAN;
//        PDResources resources = new PDResources();
//        resources.put(COSName.getPDFName("Helv"), font);
//        form.setDefaultResources(resources);
//
//        PDTextField textField = new PDTextField(form);
//        textField.setDefaultAppearance(HELV_TF_0_0_0_RG); // 0 0 0 [RGB color]
//        textField.setPartialName(paramName);
//        textField.setMultiline(true);
//        textField.setReadOnly(true);
//
//        form.getFields().add(textField);
//
//        PDAnnotationWidget widget = textField.getWidgets().get(0);
//
//        widget.setRectangle(rect);
//
//        // set after adding PDRectangle
//        textField.setValue(paramValue);
//
//        widget.setPage(page);
//        widget.setPrinted(true);
//
//        page.getAnnotations().add(widget);
//    }
//
//    private static void addEditableFieldToPDF(PDDocument document, PDPage page, String paramName, String paramValue,PDRectangle rect) throws IOException {
//        PDAcroForm form = new PDAcroForm(document);
//
//        PDFont font = PDType1Font.TIMES_BOLD;
//        PDResources resources = new PDResources();
//        resources.put(COSName.getPDFName("Helv"), font);
//        form.setDefaultResources(resources);
//
//        PDTextField textField = new PDTextField(form);
//        textField.setDefaultAppearance(HELV_TF_0_0_0_RG); // 0 0 0 [RGB color]
//        textField.setPartialName(paramName);
//
//        form.getFields().add(textField);
//
//        PDAnnotationWidget widget = textField.getWidgets().get(0);
//
//        widget.setRectangle(rect);
//
//        // set after adding PDRectangle
//        textField.setValue(paramValue);
//
//        widget.setPage(page);
//
//        PDAppearanceCharacteristicsDictionary fieldAppearance = new PDAppearanceCharacteristicsDictionary(new COSDictionary());
//        fieldAppearance.setBackground(new PDColor(new float[] { 1, 1, 1 }, PDDeviceRGB.INSTANCE));
//        
//        widget.setAppearanceCharacteristics(fieldAppearance);
//        widget.setPrinted(true);
//
//        page.getAnnotations().add(widget);
//    }
//
//    private static void addEditableCheckboxToPDF(PDDocument document, PDPage page,COSStream offNStream,COSStream onNStream, String paramName, String paramValue, PDRectangle rect) throws IOException {
//        PDAcroForm form = new PDAcroForm(document);
//
//        PDCheckBox checkBox = new PDCheckBox(form);
//        checkBox.setPartialName(paramName);
//        form.getFields().add(checkBox);
//
//        PDAnnotationWidget widget = checkBox.getWidgets().get(0);
//        widget.setRectangle(rect);
//        widget.setAnnotationFlags(4);
//        widget.setPage(page);
//
//        String offNString = "1 g\n" + "0 0 9.5 9.5 re\n" + "f\n" + "0.5 0.5 9.5 9.5 re\n" + "s";
//
//        String yesNString = "1 g\n" + "0 0 9 9.5 re\n" + "f\n" + "0.5 0.5 9.5 9.5 re\n" + "s\n" + "q\n" + "  1 1 9 9 re\n" + "  W\n" + "  n\n" + "  2 8 m\n" + "  8 2 l\n" + "  8 8 m\n" + "  2 2 l\n  s\n" + "Q";
//
//        COSDictionary apNDict = new COSDictionary();
//        
//        offNStream.setItem(COSName.BBOX, new PDRectangle(10, 10));
//        offNStream.setItem(COSName.FORMTYPE, COSInteger.ONE);
//        offNStream.setItem(COSName.TYPE, COSName.XOBJECT);
//        offNStream.setItem(COSName.SUBTYPE, COSName.FORM);
//        offNStream.setItem(COSName.MATRIX, new Matrix().toCOSArray());
//        offNStream.setItem(COSName.RESOURCES, new COSDictionary());
//        OutputStream os = offNStream.createOutputStream();
//        os.write(offNString.getBytes());
//        os.close();
//        apNDict.setItem(COSName.Off, offNStream);
//
//        onNStream.setItem(COSName.BBOX, new PDRectangle(10,10));
//        onNStream.setItem(COSName.FORMTYPE, COSInteger.ONE);
//        onNStream.setItem(COSName.TYPE, COSName.XOBJECT);
//        onNStream.setItem(COSName.SUBTYPE, COSName.FORM);
//        onNStream.setItem(COSName.MATRIX, new Matrix().toCOSArray());
//        onNStream.setItem(COSName.RESOURCES, new COSDictionary());
//        os = onNStream.createOutputStream();
//        os.write(yesNString.getBytes());
//        os.close();
//        apNDict.setItem(COSName.getPDFName("Yes"), onNStream);
//
//        PDAppearanceDictionary appearance = new PDAppearanceDictionary();
//        PDAppearanceEntry appearanceNEntry = new PDAppearanceEntry(apNDict);
//        appearance.setNormalAppearance(appearanceNEntry);
//
//        widget.setAppearance(appearance);
//
//        COSDictionary acdDict = new COSDictionary();
//        acdDict.setItem(COSName.CA, new COSString("8")); // 8 is X, 4 is checkmark
//        COSArray bcArray = new COSArray();
//        bcArray.add(COSInteger.ZERO);
//        acdDict.setItem(COSName.BC, bcArray);
//        COSArray bgArray = new COSArray();
//        bgArray.add(COSInteger.ONE);
//        acdDict.setItem(COSName.BG, bgArray);
//        PDAppearanceCharacteristicsDictionary acd = new PDAppearanceCharacteristicsDictionary(acdDict);
//        widget.setAppearanceCharacteristics(acd);
//
//        page.getAnnotations().add(widget);
//
//        checkBox.setValue(paramValue);
//
//    }
//
//    private static void addEditableRadioButtonToPDF(PDDocument document, PDPage page,COSStream offNStream,COSStream onNStream, String paramName, int[] paramPDRectangle, int[] paramPDRectangleDynamic) throws IOException {
//
//        PDAcroForm acroForm = new PDAcroForm(document);
//        PDFont font = PDType1Font.HELVETICA;
//
//        PDResources res = new PDResources();
//        COSName fontName = res.add(font);
//        acroForm.setDefaultResources(res);
//        acroForm.setDefaultAppearance('/' + fontName.getName() + " 6 Tf 0 g");
//
//        List<String> options = Arrays.asList("Add as lien holder and mail to", "Add as lien holder only", "Mail to Only");
//        
//        PDRadioButton radioButton = new PDRadioButton(acroForm);
//        radioButton.setPartialName(paramName);
//        radioButton.getCOSObject().setName(COSName.DV, options.get(1));
//        radioButton.setFieldFlags(49152);
//        int on = 0;
//
//        List<PDAnnotationWidget> widgets = new ArrayList<>();
//        for (int i = 0; i < options.size(); i++) {
//            PDAppearanceCharacteristicsDictionary fieldAppearance = new PDAppearanceCharacteristicsDictionary(new COSDictionary());
//            fieldAppearance.setBorderColour(new PDColor(new float[] { 0, 0, 0 }, PDDeviceRGB.INSTANCE));
//            PDAnnotationWidget widget = new PDAnnotationWidget();
//
//            widget.setRectangle(new PDRectangle(paramPDRectangleDynamic[i], paramPDRectangle[1], paramPDRectangle[2], paramPDRectangle[3]));
//
//            widget.setAppearanceCharacteristics(fieldAppearance);
//            widget.setAnnotationFlags(4);
//            widget.setPage(page);
//            widget.setParent(radioButton);
//
//            String offNString = "0 G\n" + "q\n  1 0 0 1 4 4 cm\n" + "  4.5 0 m\n" + "  4.5 2.1423 2.1423 4.5 0 4.5 c\n" + "  -2.1423 4.5 -4.5 2.1423 -4.5 0 c\n" + "  -4.5 -2.1423 -2.1423 -4.5 0 -4.5 c\n" + "  2.1423 -4.5 4.5 -2.1423 4.5 0 c\n" + "  s\n" + "Q";
//            String onNString = "0 G\n q\n" + "  1 0 0 1 4 4 cm\n" + "  4.5 0 m\n" + "  4.5 2.1423 2.1423 4.5 0 4.5 c\n" + "  -2.1423 4.5 -4.5 2.1423 -4.5 0 c\n" + "  -4.5 -2.1423 -2.1423 -4.5 0 -4.5 c\n" + "  2.1423 -4.5 4.5 -2.1423 4.5 0 c\n" + "  s\n" + "Q\n" + "q\n" + "  1 0 0 1 4 4 cm\n" + "  1.75 0 m\n" + "  1.75 1.9331 1.9331 1.75 0 1.75 c\n" + "  -1.9331 1.75 -1.75 1.9331 -1.75 0 c\n"
//                    + "  -1.75 -1.9331 -1.9331 -1.75 0 -1.75 c\n" + "  1.9331 -1.75 1.75 -1.9331 1.75 0 c\n" + "  f\n" + "Q";
//
//            COSDictionary apNDict = new COSDictionary();
//            offNStream.setItem(COSName.BBOX, new PDRectangle(paramPDRectangle[2], paramPDRectangle[3]));
//            offNStream.setItem(COSName.FORMTYPE, COSInteger.ONE);
//            offNStream.setItem(COSName.TYPE, COSName.XOBJECT);
//            offNStream.setItem(COSName.SUBTYPE, COSName.FORM);
//            OutputStream os = offNStream.createOutputStream(COSName.FLATE_DECODE);
//            os.write(offNString.getBytes());
//            os.close();
//            apNDict.setItem(COSName.Off, offNStream);
//
//            onNStream.setItem(COSName.BBOX, new PDRectangle(paramPDRectangle[2], paramPDRectangle[3]));
//            onNStream.setItem(COSName.FORMTYPE, COSInteger.ONE);
//            onNStream.setItem(COSName.TYPE, COSName.XOBJECT);
//            onNStream.setItem(COSName.SUBTYPE, COSName.FORM);
//            os = onNStream.createOutputStream(COSName.FLATE_DECODE);
//            os.write(onNString.getBytes());
//            os.close();
//            apNDict.setItem(options.get(i), onNStream);
//
//            PDAppearanceDictionary appearance = new PDAppearanceDictionary();
//            PDAppearanceEntry appearanceNEntry = new PDAppearanceEntry(apNDict);
//            appearance.setNormalAppearance(appearanceNEntry);
//
//            widget.setAppearance(appearance);
//
//            widget.setAppearanceState(i == on ? options.get(i) : "Off");
//
//            widgets.add(widget);
//            page.getAnnotations().add(widget);
//
//        }
//        radioButton.setWidgets(widgets);
//        acroForm.getFields().add(radioButton);
//
//    }
//
//}
