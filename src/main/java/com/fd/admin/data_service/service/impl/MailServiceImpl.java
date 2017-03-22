//package com.fd.admin.data_service.service.impl;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.mail.MailException;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.mail.javamail.MimeMessagePreparator;
//import org.springframework.stereotype.Service;
//import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
//
//import com.fd.admin.data_service_api.MailService;
//import com.fd.admin.model.ProductOrder;
//
//import freemarker.template.Configuration;
//
//@Service("mailServiceImpl")
//public class MailServiceImpl implements MailService{
//
//	@Autowired
//	JavaMailSender mailSender;
//	
//	@Autowired
//	Configuration freemarkerConfiguration;
//	
//	private static final String FM_MAILTEMPLATE = "fm_mailTemplate.ftl";
//	
//	private MimeMessagePreparator getMessagePreparator(final ProductOrder order){
//		
//		MimeMessagePreparator preparator = new MimeMessagePreparator() {
//
//			public void prepare(MimeMessage mimeMessage) throws Exception {
//            	MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
// 
//               	helper.setSubject("Your order on Demoapp with Templates");
//               	helper.setFrom("aspringmvc@gmail.com");
//               	helper.setReplyTo("aspringmvc@gmail.com");
//               	helper.setTo(order.getCustomerInfo().getEmail());
//     
//               	Map<String, Object> model = new HashMap<String, Object>();
//                model.put("order", order);
//                
//            	String text = geFreeMarkerTemplateContent(model);
////                System.out.println("Template content : "+text);
//
//                // use the true flag to indicate you need a multipart message
//            	helper.setText(text, true);
////            	helper.setText("<b>hola</b>", true);
//
//            	//Additionally, let's add a resource as an attachment as well.
//            	helper.addAttachment("cutie.png", new ClassPathResource("linux-icon.png"));
//
//            }
//        };
//        return preparator;
//	}
//	
//	public String geFreeMarkerTemplateContent(Map<String, Object> model){
//		StringBuffer content = new StringBuffer();
//		try{
//         content.append(FreeMarkerTemplateUtils.processTemplateIntoString( 
//        		 freemarkerConfiguration.getTemplate(FM_MAILTEMPLATE),model));
//         return content.toString();
//		}catch(Exception e){
//			System.out.println("Exception occured while processing fmtemplate:"+e.getMessage());
//		}
//	      return "";
//	}
//
//	@Override
//	public void sendEmail(Object object) {
//		ProductOrder order = (ProductOrder)object;
//		
//		MimeMessagePreparator preparator = getMessagePreparator(order);
//		
//		try {
//            mailSender.send(preparator);
//            System.out.println("Message has been sent.............................");
//        }
//        catch (MailException ex) {
//        	ex.printStackTrace();
//            System.err.println(ex.getMessage());
//        }
//	}
//
//
//}