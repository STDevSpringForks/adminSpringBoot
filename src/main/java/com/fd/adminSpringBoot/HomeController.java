package com.fd.adminSpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
public class HomeController {

    private static final String VIEW_HOMECONTROLLER = "HomeController";
    
    /**
     * 
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return VIEW_HOMECONTROLLER;
    }

}
