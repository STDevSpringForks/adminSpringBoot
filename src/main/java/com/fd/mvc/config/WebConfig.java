package com.fd.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Prefix for static resources. Use the classpath prefix so resources are
     * correctly located when the application is packaged as a jar.
     */
    private static final String RESOURCES_LOCATION = "classpath:/resources/";
    /**
     * Pattern that matches incoming requests for static resources.
     */
    private static final String RESOURCES_HANDLER = "/resources/**";

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML");
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        return engine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        resolver.setOrder(1);
        return resolver;
    }

    /**
     * Configure Thymeleaf as the single ViewResolver.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(thymeleafViewResolver());
    }


    /**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(RESOURCES_HANDLER).addResourceLocations(RESOURCES_LOCATION);
    }


    /*
     * The embedded servlet container provided by Spring Boot already serves
     * static resources without requiring the default servlet handler. Enabling
     * it explicitly causes a startup failure when the container does not
     * expose a named default servlet. Removing this configuration allows Boot
     * to handle static content correctly.
     */

}
