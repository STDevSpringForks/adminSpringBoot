package com.fd.criptocurrency.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author Muguruza
 *
 */
public class PersonBalance implements Serializable {
	
	private static final long serialVersionUID = 1753955487783595242L;

	private String alias;
	private BigDecimal balanceMXN;
	private BigDecimal balanceETH;
	private BigDecimal balanceXRP;
	private BigDecimal balanceBTC;
	
	public PersonBalance() {
	}

	public PersonBalance(String alias,BigDecimal balanceMXN,BigDecimal balanceETH,BigDecimal balanceXRP,BigDecimal balanceBTC){
		this.alias = alias;
		this.balanceMXN = balanceMXN;
		this.balanceETH = balanceETH;
		this.balanceXRP = balanceXRP;
		this.balanceBTC = balanceBTC;
	}
	
	public String getAlias() {
		return alias;
	}

	public BigDecimal getBalanceMXN() {
		return balanceMXN;
	}

	public BigDecimal getBalanceETH() {
		return balanceETH;
	}

	public BigDecimal getBalanceXRP() {
		return balanceXRP;
	}

	public BigDecimal getBalanceBTC() {
		return balanceBTC;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonBalance [alias=");
		builder.append(alias);
		builder.append(", balanceMXN=");
		builder.append(balanceMXN);
		builder.append(", balanceETH=");
		builder.append(balanceETH);
		builder.append(", balanceXRP=");
		builder.append(balanceXRP);
		builder.append(", balanceBTC=");
		builder.append(balanceBTC);
		builder.append("]");
		return builder.toString();
	}

}
