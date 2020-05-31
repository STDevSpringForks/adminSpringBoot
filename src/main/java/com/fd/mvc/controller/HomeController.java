package com.fd.mvc.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalTime;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

import static com.fd.mvc.common.Constants.VIEW_HOME_CONTROLLER;

@Slf4j
@Controller
@AllArgsConstructor
public class HomeController {

    private final MessageSource messageSource;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {

        log.debug("Getting home page");
        log.info("Welcome home! The client locale is {}.", locale);

        //-----Parameterized ------- http://memorynotfound.com/spring-mvc-internationalization-i18n-example/
        String welcome = messageSource.getMessage("welcome.message", new Object[]{"Buenos días"}, locale);
        model.addAttribute("message", welcome);

        // obtain locale from LocaleContextHolder
        Locale currentLocale = LocaleContextHolder.getLocale();
        model.addAttribute("locale", currentLocale);

        model.addAttribute("startMeeting", LocalTime.now());
        //-----Parameterized ---------- http://memorynotfound.com/spring-mvc-internationalization-i18n-example/

        return VIEW_HOME_CONTROLLER;
    }


}
