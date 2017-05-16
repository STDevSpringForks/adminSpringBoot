package com.fd.criptocurrency.model.result;

import java.util.ArrayList;
import java.util.List;

import com.fd.criptocurrency.model.entity.AddressCurrencyEntity;

/**
 * 
 * @author Muguruza
 *
 */
public class AddressCurrencySearchResult {
	
	private List<AddressCurrencyEntity> addressCurrencyEntitylist;
	
	public AddressCurrencySearchResult() {
		this.addressCurrencyEntitylist = new ArrayList<>();
	}

	public List<AddressCurrencyEntity> getAddressCurrencyEntitylist() {
		return addressCurrencyEntitylist;
	}

	public void setAddressCurrencyEntitylist(List<AddressCurrencyEntity> addressCurrencyEntitylist) {
		this.addressCurrencyEntitylist = addressCurrencyEntitylist;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddressCurrencySearchResult [addressCurrencyEntitylist=");
		builder.append(addressCurrencyEntitylist);
		builder.append("]");
		return builder.toString();
	}
	
	
}
