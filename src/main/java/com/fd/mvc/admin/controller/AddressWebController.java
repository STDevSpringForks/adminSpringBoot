package com.fd.mvc.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping("/googleMaps")
public class AddressWebController {

    private static final String VIEW_PLACEAUTOCOMPLETE_ADDRESSFORM = "googleMaps/placeAutocompleteAddressForm";

    /**
     * 
     * @return
     */
    @RequestMapping("/placeAutocompleteAddressForm")
    public String placeAutocompleteAddressForm() {
        return VIEW_PLACEAUTOCOMPLETE_ADDRESSFORM;
    }

}
