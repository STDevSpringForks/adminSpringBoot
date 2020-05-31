package com.fd.mvc.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class FormBitsoBalance implements Serializable{
	
	private static final long serialVersionUID = 89314645695626082L;
	
	private String balanceETH;
	private String balanceXRP;
	private String balanceBTC;
	
	private String precioEspeculativoETH;
	private String precioEspeculativoXRP;
	private String precioEspeculativoBTC;
	
}
