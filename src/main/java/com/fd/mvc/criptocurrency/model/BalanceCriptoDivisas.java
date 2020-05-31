package com.fd.mvc.criptocurrency.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BalanceCriptoDivisas implements Serializable {
	
	private static final long serialVersionUID = -1667831439437733051L;
	
	private List<BalancePerson> balancePerson;
	private BigDecimal balanceETH = BigDecimal.ZERO;
	private BigDecimal balanceXRP = BigDecimal.ZERO;
	private BigDecimal balanceBTC = BigDecimal.ZERO;
	private BigDecimal balanceMXN = BigDecimal.ZERO;
	
	private BigDecimal balanceETH_MXN = BigDecimal.ZERO;
	private BigDecimal balanceXRP_MXN = BigDecimal.ZERO;
	private BigDecimal balanceBTC_MXN = BigDecimal.ZERO;
	private BigDecimal balanceMXN_MXN = BigDecimal.ZERO;
	
	private BigDecimal balanceTOTAL_MXN = BigDecimal.ZERO;
	
	private BigDecimal comisionTOTAL_MXN = BigDecimal.ZERO;
	
	public BalanceCriptoDivisas() {
		this.balancePerson = new ArrayList<>();
	}

	public List<BalancePerson> getPersonBalance() {
		return balancePerson;
	}

	public void setPersonBalance(List<BalancePerson> personBalance) {
		this.balancePerson = personBalance;
	}

	public List<BalancePerson> getBalancePerson() {
		return balancePerson;
	}

	public void setBalancePerson(List<BalancePerson> balancePerson) {
		this.balancePerson = balancePerson;
	}

	public BigDecimal getBalanceETH() {
		return balanceETH;
	}

	public void setBalanceETH(BigDecimal balanceETH) {
		this.balanceETH = balanceETH;
	}

	public BigDecimal getBalanceXRP() {
		return balanceXRP;
	}

	public void setBalanceXRP(BigDecimal balanceXRP) {
		this.balanceXRP = balanceXRP;
	}

	public BigDecimal getBalanceBTC() {
		return balanceBTC;
	}

	public void setBalanceBTC(BigDecimal balanceBTC) {
		this.balanceBTC = balanceBTC;
	}

	public BigDecimal getBalanceMXN() {
		return balanceMXN;
	}

	public void setBalanceMXN(BigDecimal balanceMXN) {
		this.balanceMXN = balanceMXN;
	}

	public BigDecimal getBalanceETH_MXN() {
		return balanceETH_MXN;
	}

	public void setBalanceETH_MXN(BigDecimal balanceETH_MXN) {
		this.balanceETH_MXN = balanceETH_MXN;
	}

	public BigDecimal getBalanceXRP_MXN() {
		return balanceXRP_MXN;
	}

	public void setBalanceXRP_MXN(BigDecimal balanceXRP_MXN) {
		this.balanceXRP_MXN = balanceXRP_MXN;
	}

	public BigDecimal getBalanceBTC_MXN() {
		return balanceBTC_MXN;
	}

	public void setBalanceBTC_MXN(BigDecimal balanceBTC_MXN) {
		this.balanceBTC_MXN = balanceBTC_MXN;
	}

	public BigDecimal getBalanceMXN_MXN() {
		return balanceMXN_MXN;
	}

	public void setBalanceMXN_MXN(BigDecimal balanceMXN_MXN) {
		this.balanceMXN_MXN = balanceMXN_MXN;
	}
	public BigDecimal getBalanceTOTAL_MXN() {
		return balanceTOTAL_MXN;
	}

	public void setBalanceTOTAL_MXN(BigDecimal balanceTOTAL_MXN) {
		this.balanceTOTAL_MXN = balanceTOTAL_MXN;
	}

	public BigDecimal getComisionTOTAL_MXN() {
		return comisionTOTAL_MXN;
	}

	public void setComisionTOTAL_MXN(BigDecimal comisionTOTAL_MXN) {
		this.comisionTOTAL_MXN = comisionTOTAL_MXN;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BalanceCriptoDivisas [balancePerson=");
		builder.append(balancePerson);
		builder.append(", balanceETH=");
		builder.append(balanceETH);
		builder.append(", balanceXRP=");
		builder.append(balanceXRP);
		builder.append(", balanceBTC=");
		builder.append(balanceBTC);
		builder.append(", balanceMXN=");
		builder.append(balanceMXN);
		builder.append(", balanceETH_MXN=");
		builder.append(balanceETH_MXN);
		builder.append(", balanceXRP_MXN=");
		builder.append(balanceXRP_MXN);
		builder.append(", balanceBTC_MXN=");
		builder.append(balanceBTC_MXN);
		builder.append(", balanceMXN_MXN=");
		builder.append(balanceMXN_MXN);
		builder.append(", balanceTOTAL_MXN=");
		builder.append(balanceTOTAL_MXN);
		builder.append(", comisionTOTAL_MXN=");
		builder.append(comisionTOTAL_MXN);
		builder.append("]");
		return builder.toString();
	}

	
}
