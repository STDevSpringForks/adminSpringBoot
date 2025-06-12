package com.fd.mvc.model;


import java.io.Serializable;

public class TwilioSMSSearchCriteria implements Serializable {
    
    private static final long serialVersionUID = 5120987298576091488L;
    
    private String areaCodeCountry;
    private String phoneNumberTo;
    private String body;
    
    public String getAreaCodeCountry() {
        return areaCodeCountry;
    }

    public void setAreaCodeCountry(String areaCodeCountry) {
        this.areaCodeCountry = areaCodeCountry;
    }

    public String getPhoneNumberTo() {
        return phoneNumberTo;
    }

    public void setPhoneNumberTo(String phoneNumberTo) {
        this.phoneNumberTo = phoneNumberTo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
