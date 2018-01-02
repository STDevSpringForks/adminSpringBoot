package com.fd.criptocurrency.data_service.service;

import com.fd.criptocurrency.model.BalanceCriptoDivisas;
import com.fd.criptocurrency.model.FormBitsoBalance;
import com.fd.criptocurrency.model.OrderBookResult;
import com.fd.criptocurrency.model.result.BitsoPayloadResult;

/**
 * 
 * @author Muguruza
 *
 */
public interface BitsoService {
	
	/**
	 * Obtener los payload de Bitso.
	 * @return
	 */
	public BitsoPayloadResult getPayload();

	/**
	 * Obtener el balance de las CriptoDivisas.
	 * @return
	 */
	public BalanceCriptoDivisas obtenerBalanceDivisas(BitsoPayloadResult bitsoPayloadResult);
	
	/**
	 * Obtener el balance de las CriptoDivisas, especulando un precio enviado por parametro.
	 * @param bitsoPayloadResult
	 * @return
	 */
	public BalanceCriptoDivisas obtenerBalanceDivisas(BitsoPayloadResult bitsoPayloadResult,FormBitsoBalance formBitsoBalance);
	
	/**
	 * Obtener el balance Inicial.
	 * @return
	 */
	public BalanceCriptoDivisas obtenerBalanceDivisasInicial();
	
	/**
	 * Obtener la ganancia del balanace - iversiòn inicial.
	 * @return
	 */
	public BalanceCriptoDivisas obtenerBalanceDivisasGanancia(BalanceCriptoDivisas balance,BalanceCriptoDivisas balanceInicial);
	
	/**
	 * Obtener el listado de las ordenes de compra.
	 * @return
	 */
	public OrderBookResult obtenerOrdenDeCompras();
	
}
