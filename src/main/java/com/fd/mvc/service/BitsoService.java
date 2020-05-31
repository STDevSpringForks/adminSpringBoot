package com.fd.mvc.service;

import com.fd.mvc.model.BalanceCriptoDivisas;
import com.fd.mvc.model.BitsoPayloadResult;
import com.fd.mvc.model.FormBitsoBalance;
import com.fd.mvc.model.OrderBookResult;

public interface BitsoService {

    /**
     * Obtener los payload de Bitso.
     *
     * @return
     */
    BitsoPayloadResult getPayload();

    /**
     * Obtener el balance de las CriptoDivisas.
     *
     * @return
     */
    BalanceCriptoDivisas obtenerBalanceDivisas(BitsoPayloadResult bitsoPayloadResult);

    /**
     * Obtener el balance de las CriptoDivisas, especulando un precio enviado por parametro.
     *
     * @param bitsoPayloadResult
     * @return
     */
    BalanceCriptoDivisas obtenerBalanceDivisas(BitsoPayloadResult bitsoPayloadResult, FormBitsoBalance formBitsoBalance);

    /**
     * Obtener el balance Inicial.
     *
     * @return
     */
    BalanceCriptoDivisas obtenerBalanceDivisasInicial();

    /**
     * Obtener la ganancia del balanace - iversiòn inicial.
     *
     * @return
     */
    BalanceCriptoDivisas obtenerBalanceDivisasGanancia(BalanceCriptoDivisas balance, BalanceCriptoDivisas balanceInicial);

    /**
     * Obtener el listado de las ordenes de compra.
     *
     * @return
     */
    OrderBookResult obtenerOrdenDeCompras();

}
