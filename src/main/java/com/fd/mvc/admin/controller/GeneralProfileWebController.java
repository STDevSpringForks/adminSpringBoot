//package com.fd.admin.controller;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.fd.admin.model.GeneralProfile;
//
///**
// * 
// * @author Muguruza
// *
// */
//@Controller
//@RequestMapping("/generalProfile")
//public class GeneralProfileWebController {
//
//	private static final String VIEW_NEW_PROFILE = "generalProfile/newProfile"; 
//	
//	/**
//	 * http://acodigo.blogspot.com/2017/05/spring-expression-language-spel.html
//	 */
//    @Value("#{countryOptionsP}")
//    private Map<String, String> countryOptionsP;
//
//    /**
//     * 
//     * @param model
//     * @return
//     */
//    @RequestMapping(value="/newProfile" ,method = RequestMethod.GET)
//    public String newProfile(Model model) {
//        GeneralProfile generalProfile = new GeneralProfile();
//        generalProfile.setFirstName("Nombre");
//        generalProfile.setLastName("Apellido");
//        model.addAttribute("theCountryOptions", countryOptionsP);
//        model.addAttribute("generalProfile", generalProfile); // modelAttribute="generalProfile"
//        return VIEW_NEW_PROFILE;
//    }
//
//    /**
//     * 
//     * @param generalProfile
//     * @return
//     */
//    @RequestMapping(value = "/newProfile", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//    public String addProfile(@ModelAttribute("generalProfile") GeneralProfile generalProfile) {
//
//        if ("test".equals(generalProfile.getLastName())) {
//            return VIEW_NEW_PROFILE;
//        }
//
//        return VIEW_NEW_PROFILE;
//    }
//
//}
