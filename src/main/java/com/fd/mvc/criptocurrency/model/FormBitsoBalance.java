package com.fd.mvc.criptocurrency.model;

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
	
	private String precioEspeculativoETH;
	private String precioEspeculativoXRP;
	private String precioEspeculativoBTC;
	
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
	public String getPrecioEspeculativoETH() {
		return precioEspeculativoETH;
	}
	public void setPrecioEspeculativoETH(String precioEspeculativoETH) {
		this.precioEspeculativoETH = precioEspeculativoETH;
	}
	public String getPrecioEspeculativoXRP() {
		return precioEspeculativoXRP;
	}
	public void setPrecioEspeculativoXRP(String precioEspeculativoXRP) {
		this.precioEspeculativoXRP = precioEspeculativoXRP;
	}
	public String getPrecioEspeculativoBTC() {
		return precioEspeculativoBTC;
	}
	public void setPrecioEspeculativoBTC(String precioEspeculativoBTC) {
		this.precioEspeculativoBTC = precioEspeculativoBTC;
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
		builder.append(", precioEspeculativoETH=");
		builder.append(precioEspeculativoETH);
		builder.append(", precioEspeculativoXRP=");
		builder.append(precioEspeculativoXRP);
		builder.append(", precioEspeculativoBTC=");
		builder.append(precioEspeculativoBTC);
		builder.append("]");
		return builder.toString();
	}
	
}
