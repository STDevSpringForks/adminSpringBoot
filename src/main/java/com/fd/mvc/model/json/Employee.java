package com.fd.mvc.model.json;

import lombok.Data;

@Data
public class Employee {

    private int id;
    private String name;
    private boolean permanent;
    private Address address;
    private long[] phoneNumbers;
    private String role;

}
