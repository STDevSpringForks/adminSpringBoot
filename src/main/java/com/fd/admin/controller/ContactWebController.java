package com.fd.admin.controller;

import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fd.admin.data_service.validator.ContactValidator;
import com.fd.admin.model.ContactForm;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping("/contact")
public class ContactWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactWebController.class);
    private static final String VIEW_CONTACT = "contact/viewContact";

    @Autowired
    private ContactValidator contactValidator;

    /**
     * 
     * @param zoneId
     * @param model
     * @return
     */
    @GetMapping("/viewContact")
    // @RequestMapping(value = "/viewContact", method = RequestMethod.GET)
    public String viewContact(ZoneId zoneId, Model model) {
        ContactForm contactForm = new ContactForm();
        model.addAttribute("zoneIdsList", contactForm.getZoneIdsList());
        contactForm.setZoneId(zoneId.getId());
        model.addAttribute("contactForm", contactForm);
        return VIEW_CONTACT;
    }

    /**
     * 
     * @param contactForm
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/viewContact")
    // @RequestMapping(value = "/viewContact", method = RequestMethod.POST)
    public String processContact(@ModelAttribute("contactForm") ContactForm contactForm, BindingResult result,
            Model model) {
        model.addAttribute("zoneIdsList", contactForm.getZoneIdsList());
        model.addAttribute("contactForm", contactForm);

        try {
            contactValidator.validate(contactForm, result);
            if (result.hasErrors()) {
                return VIEW_CONTACT;
            }
            model.addAttribute("msgResult", "Comment successfully sent");

        } catch (Exception e) {
            LOGGER.debug("processContact Exception ", e);
            result.addError(new ObjectError("exception", "Unexpected error"));
        }

        return VIEW_CONTACT;
    }

}
