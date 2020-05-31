package com.fd.mvc.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PalindromeSearchCriteria implements Serializable {

    private static final long serialVersionUID = -691564588058872189L;

    private String phrase;

}
