package com.fd.mvc.model;


import java.io.Serializable;

public class PalindromeSearchCriteria implements Serializable {

    private static final long serialVersionUID = -691564588058872189L;

    private String phrase;

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

}
