package com.fd.admin.data_service.criptomonedas.bisto;

import java.io.Serializable;

public class Bids implements Serializable {
	
	private static final long serialVersionUID = -8390148359553970741L;
	
	private String book;
	private String price;
	private String amount;
	
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BitsoPayloadOrderBook [book=");
		builder.append(book);
		builder.append(", price=");
		builder.append(price);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
}
