package com.fd.mvc.config;

import com.fd.mvc.model.MenuItem;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class NavigationAdvice {

    @ModelAttribute("navigationMenu")
    public Map<String, List<MenuItem>> navigationMenu() {
        Map<String, List<MenuItem>> menu = new LinkedHashMap<>();

        // Utils
        List<MenuItem> utils = new ArrayList<>();
        utils.add(new MenuItem("Twilio", "/twilio/viewTiwilioSMS"));
        utils.add(new MenuItem("File Upload", "/upload"));
        menu.put("Utils", utils);

        // Exercises
        List<MenuItem> exercises = new ArrayList<>();
        exercises.add(new MenuItem("Palindromo", "/exercises/viewPalindrome"));
        exercises.add(new MenuItem("Serialize", "/exercises/viewSerializable"));
        exercises.add(new MenuItem("Google Map API", "/googleMaps/placeAutocompleteAddressForm"));
        exercises.add(new MenuItem("Jasper Reports", "/reports/viewJasperReport"));
        exercises.add(new MenuItem("JQuery3", "/exercises/viewJQuery3"));
        menu.put("Exercises", exercises);

        // Bitso
        List<MenuItem> bitso = new ArrayList<>();
        bitso.add(new MenuItem("Bitso", "/bitso/viewBitso"));
        bitso.add(new MenuItem("Bitso Order Book", "/bitso/viewBitsoOrderBook"));
        menu.put("Bitso", bitso);

        // Finance
        List<MenuItem> finance = new ArrayList<>();
        finance.add(new MenuItem("Payments", "/modules/finance/payments/viewPaymentes"));
        menu.put("Finance", finance);

        // Testing API
        List<MenuItem> api = new ArrayList<>();
        api.add(new MenuItem("View MapBox", "/api/viewMapBox"));
        menu.put("Testing API", api);

        return menu;
    }
}
