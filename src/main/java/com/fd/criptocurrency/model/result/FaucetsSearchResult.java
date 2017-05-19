package com.fd.criptocurrency.model.result;

import java.util.ArrayList;
import java.util.List;

import com.fd.criptocurrency.model.entity.FaucetEntity;

/**
 * 
 * @author Muguruza
 *
 */
public class FaucetsSearchResult {
	
	List<FaucetEntity> faucetSearchResult;

	public FaucetsSearchResult() {
		this.faucetSearchResult = new ArrayList<>();
	}
	
	public List<FaucetEntity> getFaucetSearchResult() {
		return faucetSearchResult;
	}
	public void setFaucetSearchResult(List<FaucetEntity> faucetSearchResult) {
		this.faucetSearchResult = faucetSearchResult;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FaucetsSearchResult [faucetSearchResult=");
		builder.append(faucetSearchResult);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
