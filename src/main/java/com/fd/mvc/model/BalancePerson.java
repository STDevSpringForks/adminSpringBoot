package com.fd.mvc.model;

import com.fd.mvc.common.UtilsBigDecimal;

import java.io.Serializable;
import java.math.BigDecimal;

public class BalancePerson implements Serializable {
	
	private static final long serialVersionUID = 1753955487783595242L;

	private BigDecimal balanceMXN = BigDecimal.ZERO;
	private BigDecimal balanceETH = BigDecimal.ZERO;
	private BigDecimal balanceXRP = BigDecimal.ZERO;
	private BigDecimal balanceBTC = BigDecimal.ZERO;
	
	public BalancePerson() {}
	
	public BigDecimal getBalanceMXN() {
		return balanceMXN;
	}
	public void setBalanceMXN(String balanceMXN) {
		this.balanceMXN = UtilsBigDecimal.nullToZero(balanceMXN);
	}
	public BigDecimal getBalanceETH() {
		return balanceETH;
	}
	public void setBalanceETH(String balanceETH) {
		this.balanceETH = UtilsBigDecimal.nullToZero(balanceETH);
	}
	public BigDecimal getBalanceXRP() {
		return balanceXRP;
	}
	public void setBalanceXRP(String balanceXRP) {
		this.balanceXRP = UtilsBigDecimal.nullToZero(balanceXRP);
	}
	public BigDecimal getBalanceBTC() {
		return balanceBTC;
	}
	public void setBalanceBTC(String balanceBTC) {
		this.balanceBTC = UtilsBigDecimal.nullToZero(balanceBTC);
	}

}
