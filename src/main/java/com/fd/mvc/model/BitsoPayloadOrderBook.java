package com.fd.mvc.model;

import com.fd.mvc.model.Bids;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BitsoPayloadOrderBook implements Serializable {

    private static final long serialVersionUID = 3463390799122555749L;

    private String updated_at;
    private List<Bids> bids;
    private List<Bids> asks;

    public BitsoPayloadOrderBook() {
        this.bids = new ArrayList<>();
    }


    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public List<Bids> getBids() {
        return bids;
    }

    public void setBids(List<Bids> bids) {
        this.bids = bids;
    }

    public List<Bids> getAsks() {
        return asks;
    }

    public void setAsks(List<Bids> asks) {
        this.asks = asks;
    }

}
