package com.fd.admin.model.criteria;

import java.io.Serializable;

/**
 * 
 * @author Muguruza
 *
 */
public class PalindromeSearchCriteria implements Serializable {

    private static final long serialVersionUID = -691564588058872189L;
    private String phrase;

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PalindromeSearchCriteria [phrase=");
        builder.append(phrase);
        builder.append("]");
        return builder.toString();
    }

}
