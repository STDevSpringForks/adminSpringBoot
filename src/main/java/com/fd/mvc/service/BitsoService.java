package com.fd.mvc.service;

import com.fd.mvc.model.BalanceCriptoDivisas;
import com.fd.mvc.model.BitsoPayloadResult;
import com.fd.mvc.model.FormBitsoBalance;
import com.fd.mvc.model.OrderBookResult;

public interface BitsoService {

    BitsoPayloadResult getPayload();
    BalanceCriptoDivisas obtenerBalanceDivisas(BitsoPayloadResult bitsoPayloadResult);
    BalanceCriptoDivisas obtenerBalanceDivisas(BitsoPayloadResult bitsoPayloadResult, FormBitsoBalance formBitsoBalance);
    BalanceCriptoDivisas obtenerBalanceDivisasInicial();
    BalanceCriptoDivisas obtenerBalanceDivisasGanancia(BalanceCriptoDivisas balance, BalanceCriptoDivisas balanceInicial);
    OrderBookResult obtenerOrdenDeCompras();

}
