package com.fd.mvc.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TwilioSMSSearchCriteria implements Serializable {
    
    private static final long serialVersionUID = 5120987298576091488L;
    
    private String areaCodeCountry;
    private String phoneNumberTo;
    private String body;
    
}
