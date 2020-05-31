package com.fd.mvc.admin.model.criteria;

import java.io.Serializable;

/**
 * 
 * @author Muguruza
 *
 */
public class TwilioSMSSearchCriteria implements Serializable {
    
    private static final long serialVersionUID = 5120987298576091488L;
    
    private String areaCodeCountry;
    private String phoneNumberTo;
    
    /**
     * Message
     */
    private String body;
    
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
	public String getAreaCodeCountry() {
		return areaCodeCountry;
	}
	public void setAreaCodeCountry(String areaCodeCountry) {
		this.areaCodeCountry = areaCodeCountry;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TwilioSMSSearchCriteria [areaCodeCountry=");
		builder.append(areaCodeCountry);
		builder.append(", phoneNumberTo=");
		builder.append(phoneNumberTo);
		builder.append(", body=");
		builder.append(body);
		builder.append("]");
		return builder.toString();
	}
	
}
