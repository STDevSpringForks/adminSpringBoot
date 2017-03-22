package com.fd.admin.model.result;

import java.io.Serializable;
import com.twilio.rest.api.v2010.account.Message;

/**
 * 
 * @author Muguruza
 *
 */
public class TwilioSMSResult implements Serializable {
    
    private static final long serialVersionUID = -3290365786900456391L;
    
    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TwilioSMSResult [message=");
        builder.append(message);
        builder.append("]");
        return builder.toString();
    }
    
    
}
