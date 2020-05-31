//package com.fd.admin.data_service.config;
//
//import java.util.Locale;
//
//import org.springframework.beans.factory.config.PropertiesFactoryBean;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.Validator;
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.i18n.CookieLocaleResolver;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
//import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
//
///**
// * 
// * @author Muguruza
// *
// */
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "com.fd.admin")
////public class SpringWebConfig extends WebMvcConfigurationSupport {
//public class SpringWebConfig extends WebMvcConfigurerAdapter {
//
//    private static final String MESSAGE_SOURCE = "/WEB-INF/i18n/messages";
////    private static final String VIEWS = "/WEB-INF/views/";
//
//    private static final String RESOURCES_LOCATION = "/resources/";
//    private static final String RESOURCES_HANDLER = RESOURCES_LOCATION + "**";
//
////    @Bean
////    public ViewResolver viewResolver() {
////        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
////        viewResolver.setPrefix(VIEWS);
////        viewResolver.setSuffix(".jsp");
////        return viewResolver;
////    }
//    
////    @Bean
////    public ViewResolver viewResolver() {
////        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
////        thymeleafViewResolver.setTemplateEngine(templateEngine());
////        thymeleafViewResolver.setCharacterEncoding("UTF-8");
////        return thymeleafViewResolver;
////    }
//    
////    @Bean
////    public ITemplateResolver templateResolver() {
////        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
////        resolver.setPrefix(VIEWS);
////        resolver.setSuffix(".html");
////        resolver.setTemplateMode(TemplateMode.HTML);
////        resolver.setCharacterEncoding("UTF-8");
////        resolver.setCacheable(false);
////        return resolver;
////    }
//
////    @Bean
////    public SpringTemplateEngine templateEngine() {
////        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
////        templateEngine.setTemplateResolver(templateResolver());
////        templateEngine.addDialect(new SpringSecurityDialect());
////        templateEngine.addDialect(new Java8TimeDialect());
////        return templateEngine;
////    }
//
//	/**
//     * Configure TilesConfigurer.
//     */
//	@Bean
//	public TilesConfigurer tilesConfigurer(){
//	    TilesConfigurer tilesConfigurer = new TilesConfigurer();
//	    tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/views/**/tiles.xml"});
//	    tilesConfigurer.setCheckRefresh(true);
//	    return tilesConfigurer;
//	}
//
//	/**
//     * Configure ViewResolvers to deliver preferred views.
//     */
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		TilesViewResolver viewResolver = new TilesViewResolver();
//		registry.viewResolver(viewResolver);
//	}
//	
////    @Override
////    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
////        RequestMappingHandlerMapping requestMappingHandlerMapping = super.requestMappingHandlerMapping();
////        requestMappingHandlerMapping.setUseSuffixPatternMatch(false);
////        requestMappingHandlerMapping.setUseTrailingSlashMatch(false);
////        return requestMappingHandlerMapping;
////    }
//
//    @Bean(name = "messageSource")
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename(MESSAGE_SOURCE);
//        messageSource.setCacheSeconds(5);
////        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }
//    
//    @Bean
//    public CookieLocaleResolver localeResolver(){
//        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
//        localeResolver.setDefaultLocale(Locale.ENGLISH);
//        localeResolver.setCookieName("my-locale-cookie");
//        localeResolver.setCookieMaxAge(3600);
//        return localeResolver;
//    }
//
//    @Bean
//    public LocaleChangeInterceptor localeInterceptor(){
//        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
//        interceptor.setParamName("lang");
//        return interceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeInterceptor());
//    }
//    
//    @Override
//    public Validator getValidator() {
//        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
//        validator.setValidationMessageSource(messageSource());
//        return validator;
//    }
//
//    /**
//     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(RESOURCES_HANDLER).addResourceLocations(RESOURCES_LOCATION);
//    }
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//
//    /**
//     * Handles favicon.ico requests assuring no <code>404 Not Found</code> error is returned.
//     */
//    @Controller
//    static class FaviconController {
//        @RequestMapping("favicon.ico")
//        String favicon() {
//            return "forward:/resources/images/favicon.ico";
//        }
//    }
//    
//    /**
//     * <util:properties id="countryOptionsP" location="classpath:../countries.properties" />
//     * @return
//     */
//    @Bean(name = "countryOptionsP")
//    public PropertiesFactoryBean mapper() {
//        PropertiesFactoryBean bean = new PropertiesFactoryBean();
//        bean.setLocation(new ClassPathResource("properties/countries.properties"));
//        return bean;
//    }
//    
//}