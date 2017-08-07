package com.fd.admin;

import java.util.Locale;

import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *  
 * @author Muguruza
 *
 */
@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    private static final String VIEW_HOMECONTROLLER = "home";
    
    @Autowired
    private MessageSource messageSource;
    
    /**
     * <b>Página principal</b>
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        LOGGER.debug("Getting home page");
        
        LOGGER.info("Welcome home! The client locale is {}.", locale);
        
       //-----Parameterized ------- http://memorynotfound.com/spring-mvc-internationalization-i18n-example/
        String welcome = messageSource.getMessage("welcome.message", new Object[]{"Fermín Muguruza"}, locale);
        model.addAttribute("message", welcome);
        
        // obtain locale from LocaleContextHolder
        Locale currentLocale = LocaleContextHolder.getLocale();
        model.addAttribute("locale", currentLocale);

        model.addAttribute("startMeeting", LocalTime.now());
        //-----Parameterized ---------- http://memorynotfound.com/spring-mvc-internationalization-i18n-example/
        
        return VIEW_HOMECONTROLLER;
    }

}
