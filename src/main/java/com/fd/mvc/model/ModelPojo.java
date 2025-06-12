package com.fd.mvc.model;


import java.io.Serializable;

public class ModelPojo implements Serializable {
	
	private static final long serialVersionUID = -1797022868403024425L;
	
	private String test1;
	private String test2;
	

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

}
