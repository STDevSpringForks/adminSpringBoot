package com.fd.mvc.model;

import com.fd.mvc.model.BalancePerson;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
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


}
