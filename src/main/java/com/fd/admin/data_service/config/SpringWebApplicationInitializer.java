///*
// * SpringWebApplicationInitializer.java
// * 
// * Creada el 22-dic-2015, 14:36:01
// * 
// * Clase Java desarrollada por Alex para el blog Java Tutoriales (javatutoriales.com) el día 22-dic-2015
// * 
// * Para informacion sobre el uso de esta clase, asi como bugs, actualizaciones, o mejoras enviar un mail a
// * programadorjavablog@gmail.com
// */
//package com.fd.admin.data_service.config;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
///**
// * 
// * @author Muguruza
// *
// */
//public class SpringWebApplicationInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(SpringWebConfig.class);
//        context.setServletContext(servletContext);
//
//        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("spring-web", new DispatcherServlet(context));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//    }
//}
