package com.fd.criptocurrency.model;

import java.io.Serializable;

/**
 * 
 * @author Muguruza
 *
 */
public class FormBitsoBalance implements Serializable{
	
	private static final long serialVersionUID = 89314645695626082L;
	
	private String balanceETH;
	private String balanceXRP;
	private String balanceBTC;
	
	public String getBalanceETH() {
		return balanceETH;
	}
	public void setBalanceETH(String balanceETH) {
		this.balanceETH = balanceETH;
	}
	public String getBalanceXRP() {
		return balanceXRP;
	}
	public void setBalanceXRP(String balanceXRP) {
		this.balanceXRP = balanceXRP;
	}
	public String getBalanceBTC() {
		return balanceBTC;
	}
	public void setBalanceBTC(String balanceBTC) {
		this.balanceBTC = balanceBTC;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FormBitsoBalance [balanceETH=");
		builder.append(balanceETH);
		builder.append(", balanceXRP=");
		builder.append(balanceXRP);
		builder.append(", balanceBTC=");
		builder.append(balanceBTC);
		builder.append("]");
		return builder.toString();
	}
}