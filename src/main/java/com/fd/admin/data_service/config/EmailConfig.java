//package com.fd.admin.data_service.config;
//
//import java.util.Properties;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
//
///**
// * 
// * @author Muguruza
// * http://stackoverflow.com/questions/12743846/unable-to-send-an-email-using-smtp-getting-javax-mail-messagingexception-could
// * https://www.google.com/settings/security/lesssecureapps
// */
//@Configuration
//@ComponentScan(basePackages = "com.fd.admin")
//public class EmailConfig {
//
//		//Put Other Application configuration here.
//
//		@Bean
//		public JavaMailSender getMailSender() {
//			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//			
////			Port for TLS/STARTTLS: 587
////			Port for SSL: 465
//			
//			// Using gmail.
//			mailSender.setHost("smtp.gmail.com");
//			mailSender.setPort(587);
////			mailSender.setUsername("Your-gmail-id");
////			mailSender.setPassword("Your-gmail-password");
//			mailSender.setUsername("aspringmvc");
//			mailSender.setPassword("e*****t123456");
//
//			Properties javaMailProperties = new Properties();
//			javaMailProperties.put("mail.smtp.starttls.enable", true);
//			javaMailProperties.put("mail.smtp.auth", true);
//			javaMailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//			javaMailProperties.put("mail.debug", "true");
//			
//
//			mailSender.setJavaMailProperties(javaMailProperties);
//			return mailSender;
//		}
//
//		/*
//		 * FreeMarker configuration.
//		 */
//		@Bean
//		public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
//			FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
//			bean.setTemplateLoaderPath("classpath:/META-INF/fmtemplates");
//			return bean;
//		}
//	
//}
