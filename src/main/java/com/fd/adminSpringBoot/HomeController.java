package com.fd.adminSpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    
    private static final String VIEW_HOMECONTROLLER = "home";
    
    /**
     * <b>Página principal</b>
     * @return
     */
    @RequestMapping("/")
    public String getHomePage() {
        LOGGER.debug("Getting home page");
        return VIEW_HOMECONTROLLER;
    }

}
