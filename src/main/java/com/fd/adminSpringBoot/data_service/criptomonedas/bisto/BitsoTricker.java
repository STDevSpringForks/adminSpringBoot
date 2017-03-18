package com.fd.adminSpringBoot.data_service.criptomonedas.bisto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 
 * @author Muguruza
 * @see BitsoConstants.BITSO_URL_TICKER
 */
public class BitsoTricker implements Serializable {
	
	private static final long serialVersionUID = -3737754982685400755L;
	
	private BigDecimal high;
	private BigDecimal last;
	private LocalDateTime created_at;
	private String book;
	private BigDecimal volume;
	private BigDecimal vwap;
	private BigDecimal low;
	private BigDecimal ask;
	private BigDecimal bid;
	
	public BitsoTricker() {
		super();
	}
	/**
	 * Precio más alto en las últimas 24 horas.
	 * @return
	 */
	public BigDecimal getHigh() {
		return high;
	}
	public void setHigh(BigDecimal high) {
		this.high = high;
	}
	/**
	 * Último precio negociado.
	 * @return
	 */
	public BigDecimal getLast() {
		return last;
	}
	public void setLast(BigDecimal last) {
		this.last = last;
	}
	
	/**
	 * Timestamp en el que se generó el ticker.
	 * @return
	 */
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	/**
	 * Símbolo del libro de pedidos.
	 * @return
	 */
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	/**
	 * Volumen de las últimas 24 horas.
	 * @return
	 */
	public BigDecimal getVolume() {
		return volume;
	}
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
	/**
	 * Precio promedio ponderado de volumen de las últimas 24 horas.
	 * @return
	 */
	public BigDecimal getVwap() {
		return vwap;
	}
	public void setVwap(BigDecimal vwap) {
		this.vwap = vwap;
	}
	/**
	 * Precio más bajo en las últimas 24 horas.
	 * @return
	 */
	public BigDecimal getLow() {
		return low;
	}
	public void setLow(BigDecimal low) {
		this.low = low;
	}
	/**
	 * Orden de venta más baja.
	 * @return
	 */
	public BigDecimal getAsk() {
		return ask;
	}
	public void setAsk(BigDecimal ask) {
		this.ask = ask;
	}
	/**
	 * Orden de compra más alta.
	 * @return
	 */
	public BigDecimal getBid() {
		return bid;
	}
	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BitsoTricker [high=");
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
