package com.fd.mvc.model;

import com.fd.mvc.model.Bids;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class BitsoPayloadOrderBook implements Serializable {

    private static final long serialVersionUID = 3463390799122555749L;

    private String updated_at;
    private List<Bids> bids;
    private List<Bids> asks;

    public BitsoPayloadOrderBook() {
        this.bids = new ArrayList<>();
    }


}
