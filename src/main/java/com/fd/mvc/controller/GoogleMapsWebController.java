package com.fd.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.fd.mvc.common.Constants.VIEW_PLACEAUTOCOMPLETE_ADDRESSFORM;

@Controller
@RequestMapping("/googleMaps")
public class GoogleMapsWebController {

    @RequestMapping("/placeAutocompleteAddressForm")
    public String placeAutocompleteAddressForm() {
        return VIEW_PLACEAUTOCOMPLETE_ADDRESSFORM;
    }

}
