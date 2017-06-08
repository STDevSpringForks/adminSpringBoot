package com.fd.criptocurrency.data_service.service.impl;

import static com.fd.admin.data_service.criptomonedas.bisto.BitsoConstants.BITSO_URL_ORDER_BOOK_ETH_MXN;
import static com.fd.admin.data_service.criptomonedas.bisto.BitsoConstants.BITSO_URL_TICKER;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.json.JsonObject;

import org.springframework.stereotype.Service;

import com.fd.admin.data_service.criptomonedas.bisto.BitsoConstants;
import com.fd.admin.data_service.criptomonedas.bisto.BitsoCurrencies;
import com.fd.admin.data_service.criptomonedas.bisto.BitsoPayloadTicker;
import com.fd.admin.data_service.criptomonedas.bisto.BitsoTicker;
import com.fd.criptocurrency.data_service.service.BitsoService;
import com.fd.criptocurrency.data_service.utils.Utils;
import com.fd.criptocurrency.data_service.utils.UtilsBigDecimal;
import com.fd.criptocurrency.model.BalanceCriptoDivisas;
import com.fd.criptocurrency.model.BalancePerson;
import com.fd.criptocurrency.model.OrderBook;
import com.fd.criptocurrency.model.OrderBookResult;
import com.fd.criptocurrency.model.result.BitsoPayloadResult;
import com.google.gson.Gson;

/**
 * 
 * @author Muguruza
 *
 */
@Service("bitsoServiceImpl")
public class BitsoServiceImpl implements BitsoService {

	public BitsoPayloadResult getPayload() {
		
		BitsoPayloadResult bitsoPayloadResult = new BitsoPayloadResult();
		BitsoTicker bitsoTicker = new BitsoTicker();

		JsonObject jsonTricker = Utils.readUrlJSON(BITSO_URL_TICKER);

		/* Obtener el valor booleano del atributo success, si este no se encuentra en el JSON obtener false por default. */
		if (jsonTricker.getBoolean("success", false)) {
			bitsoTicker = new Gson().fromJson(jsonTricker.toString(), BitsoTicker.class);
		}
		
		bitsoPayloadResult.setBitsoPayloadList(bitsoTicker.getPayload());
    	
		/* Agrupando por books */
		Map<String,BitsoPayloadTicker> books = bitsoPayloadResult.getBitsoPayloadList().stream().collect(Collectors.toMap(BitsoPayloadTicker::getBook,Function.identity()));
		bitsoPayloadResult.setBooks(books);
		
		bitsoPayloadResult.setPayloadETH_MXN(books.get(BitsoCurrencies.eth_mxn.getCurrency()));
		bitsoPayloadResult.setPayloadXRP_MXN(books.get(BitsoCurrencies.xrp_mxn.getCurrency()));
		bitsoPayloadResult.setPayloadBTC_MXN(books.get(BitsoCurrencies.btc_mxn.getCurrency()));

		return bitsoPayloadResult;
	}

	@Override
	public BalanceCriptoDivisas obtenerBalanceDivisas(BitsoPayloadResult bitsoPayloadResult) {
		
		BalanceCriptoDivisas balanceCriptoDivisas = new BalanceCriptoDivisas();
		
		/* Start Balance manual, obtener la suma del balance por cada divisa desde Hibernate */
        BalancePerson personBalanceFroy = new BalancePerson();
        personBalanceFroy.setBalanceBTC("0.00001286");
        personBalanceFroy.setBalanceETH("0.05433122");
        personBalanceFroy.setBalanceMXN("10.65");
        personBalanceFroy.setBalanceXRP("0.0");
        
        BalancePerson personBalanceOfe = new BalancePerson();
        personBalanceOfe.setBalanceBTC("0.0");
        personBalanceOfe.setBalanceETH("6.73243454");
        personBalanceOfe.setBalanceMXN("0.0");
        personBalanceOfe.setBalanceXRP("1218.673218");
        
        BalancePerson personBalanceLily = new BalancePerson();
        personBalanceLily.setBalanceBTC("0.00000585");
//        personBalanceLily.setBalanceETH("21.00785276");
//        personBalanceLily.setBalanceMXN("23140.03");
//        personBalanceLily.setBalanceETH("20.70785276");
//        personBalanceLily.setBalanceMXN("24491.36");
//        personBalanceLily.setBalanceETH("23.79873696");
//        personBalanceLily.setBalanceMXN("9189.57");
//        personBalanceLily.setBalanceETH("25.38887376");
//        personBalanceLily.setBalanceMXN("1351.32");
        personBalanceLily.setBalanceETH("25.48464388");
        personBalanceLily.setBalanceMXN("885.57");
        personBalanceLily.setBalanceXRP("0.9828");
        
        List<BalancePerson> balancePersonList = new ArrayList<>();
        balancePersonList.add(personBalanceFroy);
        balancePersonList.add(personBalanceOfe);
        balancePersonList.add(personBalanceLily);
        balanceCriptoDivisas.setPersonBalance(balancePersonList);
        
        /* End balance manual, obtener la suma del balance por cada divisa desde Hibernate */
        
        balanceCriptoDivisas.setBalanceETH(UtilsBigDecimal.add(personBalanceFroy.getBalanceETH(),personBalanceOfe.getBalanceETH(),personBalanceLily.getBalanceETH()));
        balanceCriptoDivisas.setBalanceXRP(UtilsBigDecimal.add(personBalanceFroy.getBalanceXRP(),personBalanceOfe.getBalanceXRP(),personBalanceLily.getBalanceXRP()));
        balanceCriptoDivisas.setBalanceBTC(UtilsBigDecimal.add(personBalanceFroy.getBalanceBTC(),personBalanceOfe.getBalanceBTC(),personBalanceLily.getBalanceBTC()));
        balanceCriptoDivisas.setBalanceMXN(UtilsBigDecimal.add(personBalanceFroy.getBalanceMXN(),personBalanceOfe.getBalanceMXN(),personBalanceLily.getBalanceMXN()));
        
    	BitsoPayloadTicker payloadETH_MXN = bitsoPayloadResult.getPayloadETH_MXN();
    	BitsoPayloadTicker payloadXRP_MXN = bitsoPayloadResult.getPayloadXRP_MXN();
    	BitsoPayloadTicker payloadBTC_MXN = bitsoPayloadResult.getPayloadBTC_MXN();
    	
    	/* Start Balance Total */
    	BigDecimal bETH = balanceCriptoDivisas.getBalanceETH().multiply(new BigDecimal(payloadETH_MXN.getAsk()));
    	BigDecimal comisionTradeETH = bETH.multiply(BitsoConstants.COMISION_TRADE);
    	balanceCriptoDivisas.setBalanceETH_MXN(bETH.subtract(comisionTradeETH));
    	
    	BigDecimal bXRP = balanceCriptoDivisas.getBalanceXRP().multiply(new BigDecimal(payloadXRP_MXN.getAsk()));
    	BigDecimal comisionTradeXRP = bXRP.multiply(BitsoConstants.COMISION_TRADE);
    	balanceCriptoDivisas.setBalanceXRP_MXN(bXRP.subtract(comisionTradeXRP));
    	
    	BigDecimal bBTC = balanceCriptoDivisas.getBalanceBTC().multiply(new BigDecimal(payloadBTC_MXN.getAsk()));
    	BigDecimal comisionTradeBTC = bBTC.multiply(BitsoConstants.COMISION_TRADE);
    	balanceCriptoDivisas.setBalanceBTC_MXN(bBTC.subtract(comisionTradeBTC));
    	
    	balanceCriptoDivisas.setBalanceMXN_MXN(balanceCriptoDivisas.getBalanceMXN().multiply(new BigDecimal("1")));
    	
    	BigDecimal balanceTOTAL_MXN = UtilsBigDecimal.add(balanceCriptoDivisas.getBalanceETH_MXN(),balanceCriptoDivisas.getBalanceXRP_MXN(),balanceCriptoDivisas.getBalanceBTC_MXN(),balanceCriptoDivisas.getBalanceMXN_MXN());
    	balanceCriptoDivisas.setBalanceTOTAL_MXN(balanceTOTAL_MXN);
    	
    	BigDecimal sumaDeComisiones = UtilsBigDecimal.add(comisionTradeETH,comisionTradeXRP,comisionTradeBTC);
    	balanceCriptoDivisas.setComisionTOTAL_MXN(sumaDeComisiones);
    	
        return balanceCriptoDivisas;
	}

	@Override
	public BalanceCriptoDivisas obtenerBalanceDivisasInicial() {
		
		
		BalanceCriptoDivisas balanceCriptoDivisas = new BalanceCriptoDivisas();
		
		 /* Start Mi Inversion Inicial */
		balanceCriptoDivisas.setBalanceETH_MXN(new BigDecimal("77392.42"));
		balanceCriptoDivisas.setBalanceXRP_MXN(new BigDecimal("10000"));
		balanceCriptoDivisas.setBalanceBTC_MXN(new BigDecimal("0.0"));
		balanceCriptoDivisas.setBalanceMXN_MXN(new BigDecimal("885.57"));
		
		balanceCriptoDivisas.setBalanceTOTAL_MXN(UtilsBigDecimal.add(balanceCriptoDivisas.getBalanceETH_MXN(),balanceCriptoDivisas.getBalanceXRP_MXN(),balanceCriptoDivisas.getBalanceBTC_MXN(),balanceCriptoDivisas.getBalanceMXN_MXN()));
    	
        /* End Mi Inversion Inicial */
    	
    	return balanceCriptoDivisas;
    	
	}

	@Override
	public BalanceCriptoDivisas obtenerBalanceDivisasGanancia(BalanceCriptoDivisas balance,BalanceCriptoDivisas balanceInicial) {
		BalanceCriptoDivisas balanceCriptoDivisas = new BalanceCriptoDivisas();
		
		balanceCriptoDivisas.setBalanceETH_MXN(balance.getBalanceETH_MXN().subtract(balanceInicial.getBalanceETH_MXN()));
		balanceCriptoDivisas.setBalanceXRP_MXN(balance.getBalanceXRP_MXN().subtract(balanceInicial.getBalanceXRP_MXN()));
		balanceCriptoDivisas.setBalanceBTC_MXN(balance.getBalanceBTC_MXN().subtract(balanceInicial.getBalanceBTC_MXN()));
		balanceCriptoDivisas.setBalanceMXN_MXN(balance.getBalanceMXN_MXN().subtract(balanceInicial.getBalanceMXN_MXN()));
		balanceCriptoDivisas.setBalanceTOTAL_MXN(balance.getBalanceTOTAL_MXN().subtract(balanceInicial.getBalanceTOTAL_MXN()));
		
		return balanceCriptoDivisas;
	}

	@Override
	public OrderBookResult obtenerOrdenDeCompras() {
		OrderBookResult orderBookResult = new OrderBookResult();
		OrderBook orderBook = new OrderBook();

		JsonObject jsonTricker = Utils.readUrlJSON(BITSO_URL_ORDER_BOOK_ETH_MXN);

		/* Obtener el valor booleano del atributo success, si este no se encuentra en el JSON obtener false por default. */
		if (jsonTricker.getBoolean("success", false)) {
			orderBook = new Gson().fromJson(jsonTricker.toString(), OrderBook.class);
		}
		
		orderBookResult.setBitsoPayloadOrderBook(orderBook.getPayload());
		
		return orderBookResult;
	}

}
