package com.fd.mvc.model;

import com.twilio.rest.api.v2010.account.Message;

import java.io.Serializable;

public class TwilioSMSResult implements Serializable {
    
    private static final long serialVersionUID = -3290365786900456391L;
    
    private Message message;


    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

}
