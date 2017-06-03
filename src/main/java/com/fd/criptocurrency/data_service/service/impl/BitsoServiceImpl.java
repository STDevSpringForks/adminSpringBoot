package com.fd.criptocurrency.data_service.service.impl;

import static com.fd.admin.data_service.criptomonedas.bisto.BitsoConstants.BITSO_URL_TICKER;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.json.JsonObject;

import org.springframework.stereotype.Service;

import com.fd.admin.data_service.criptomonedas.bisto.BitsoCurrencies;
import com.fd.admin.data_service.criptomonedas.bisto.BitsoPayload;
import com.fd.admin.data_service.criptomonedas.bisto.BitsoTicker;
import com.fd.criptocurrency.data_service.service.BitsoService;
import com.fd.criptocurrency.data_service.utils.Utils;
import com.fd.criptocurrency.data_service.utils.UtilsBigDecimal;
import com.fd.criptocurrency.model.BalanceCriptoDivisas;
import com.fd.criptocurrency.model.BalancePerson;
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
		bitsoPayloadResult.setBitsoPayloadList(bitsoTicker.getPayload());/* Agrupando por books */
    	
		/* Agrupando por books */
		Map<String,BitsoPayload> books = bitsoPayloadResult.getBitsoPayloadList().stream().collect(Collectors.toMap(BitsoPayload::getBook,Function.identity()));
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
        personBalanceFroy.setBalanceETH("0.05120912");
        personBalanceFroy.setBalanceMXN("9.29");
        personBalanceFroy.setBalanceXRP("0.0");
        
        BalancePerson personBalanceOfe = new BalancePerson();
        personBalanceOfe.setBalanceBTC("0.0");
        personBalanceOfe.setBalanceETH("6.73243454");
        personBalanceOfe.setBalanceMXN("0.0");
        personBalanceOfe.setBalanceXRP("1218.673218");
        
        BalancePerson personBalanceLily = new BalancePerson();
        personBalanceLily.setBalanceBTC("0.00000585");
        personBalanceLily.setBalanceETH("21.00785276");
        personBalanceLily.setBalanceMXN("23140.03");
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
        
        
    	BitsoPayload payloadETH_MXN = bitsoPayloadResult.getPayloadETH_MXN();
    	BitsoPayload payloadXRP_MXN = bitsoPayloadResult.getPayloadXRP_MXN();
    	BitsoPayload payloadBTC_MXN = bitsoPayloadResult.getPayloadBTC_MXN();
    	
    	/* Start Balance Total */
    	balanceCriptoDivisas.setBalanceETH_MXN(balanceCriptoDivisas.getBalanceETH().multiply(new BigDecimal(payloadETH_MXN.getAsk())));
    	balanceCriptoDivisas.setBalanceXRP_MXN(balanceCriptoDivisas.getBalanceXRP().multiply(new BigDecimal(payloadXRP_MXN.getAsk())));
    	balanceCriptoDivisas.setBalanceBTC_MXN(balanceCriptoDivisas.getBalanceBTC().multiply(new BigDecimal(payloadBTC_MXN.getAsk())));
    	balanceCriptoDivisas.setBalanceMXN_MXN(balanceCriptoDivisas.getBalanceMXN().multiply(new BigDecimal("1")));
    	
    	BigDecimal balanceTOTAL_MXN = UtilsBigDecimal.add(balanceCriptoDivisas.getBalanceETH_MXN(),balanceCriptoDivisas.getBalanceXRP_MXN(),balanceCriptoDivisas.getBalanceBTC_MXN(),balanceCriptoDivisas.getBalanceMXN_MXN());
    	balanceCriptoDivisas.setBalanceTOTAL_MXN(balanceTOTAL_MXN);
    	
        return balanceCriptoDivisas;
	}

	@Override
	public BalanceCriptoDivisas obtenerBalanceDivisasInicial() {
		
		BalanceCriptoDivisas balanceCriptoDivisas = new BalanceCriptoDivisas();
		
		 /* Start Mi Inversion Inicial */
		balanceCriptoDivisas.setBalanceETH_MXN(new BigDecimal("55137.96"));
		balanceCriptoDivisas.setBalanceXRP_MXN(new BigDecimal("10000"));
		balanceCriptoDivisas.setBalanceBTC_MXN(new BigDecimal("0.0"));
		balanceCriptoDivisas.setBalanceMXN_MXN(new BigDecimal("23140.03"));
		
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

}
