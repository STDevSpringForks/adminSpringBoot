package com.fd.mvc.model;

import com.twilio.rest.api.v2010.account.Message;
import lombok.Data;

import java.io.Serializable;

@Data
public class TwilioSMSResult implements Serializable {
    
    private static final long serialVersionUID = -3290365786900456391L;
    
    private Message message;


}
