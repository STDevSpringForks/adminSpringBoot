package com.fd.criptocurrency.model.result;

import java.util.ArrayList;
import java.util.List;

import com.fd.criptocurrency.model.entity.ExchangeEntity;

/**
 * 
 * @author Muguruza
 *
 */
public class ExchangesSearchResult {
	
	private List<ExchangeEntity> exchangeEntityList;

	public ExchangesSearchResult() {
		this.exchangeEntityList = new ArrayList<>();
	}
	
	public List<ExchangeEntity> getExchangeEntityList() {
		return exchangeEntityList;
	}

	public void setExchangeEntityList(List<ExchangeEntity> exchangeEntityList) {
		this.exchangeEntityList = exchangeEntityList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExchangesSearchResult [exchangeEntityList=");
		builder.append(exchangeEntityList);
		builder.append("]");
		return builder.toString();
	}
	
}