package com.fd.admin.data_service.criptomonedas.bisto;

import java.io.Serializable;

/**
 * 
 * @author Muguruza
 *
 */
public class BitsoPayloadTicker implements Serializable {
	
	private static final long serialVersionUID = 3463390799122555749L;
	
	private String high;
	private String last;
	private String created_at;
	private String book;
	private String volume;
	private String vwap;
	private String low;
	private String ask;
	private String bid;

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}
	
	public Float getBidFloat() {
		return Float.parseFloat(bid);
	}

	public String getAsk() {
		return ask;
	}
	
	public Float getAskFloat() {
		return Float.parseFloat(ask);
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getVwap() {
		return vwap;
	}

	public void setVwap(String vwap) {
		this.vwap = vwap;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BitsoPayload [high=");
		builder.append(high);
		builder.append(", last=");
		builder.append(last);
		builder.append(", created_at=");
		builder.append(created_at);
		builder.append(", book=");
		builder.append(book);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", vwap=");
		builder.append(vwap);
		builder.append(", low=");
		builder.append(low);
		builder.append(", ask=");
		builder.append(ask);
		builder.append(", bid=");
		builder.append(bid);
		builder.append("]");
		return builder.toString();
	}

}