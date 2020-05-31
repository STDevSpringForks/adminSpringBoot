package com.fd.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.fd.mvc.common.Constants.VIEW_PLACEAUTOCOMPLETE_ADDRESSFORM;

/**
 * https://developers.google.com/maps/documentation/javascript/get-api-key
 * https://developers.google.com/maps/documentation/javascript/places-autocomplete
 */
@Controller
@RequestMapping("/googleMaps")
public class AddressWebController {

    @RequestMapping("/placeAutocompleteAddressForm")
    public String placeAutocompleteAddressForm() {
        return VIEW_PLACEAUTOCOMPLETE_ADDRESSFORM;
    }

}
