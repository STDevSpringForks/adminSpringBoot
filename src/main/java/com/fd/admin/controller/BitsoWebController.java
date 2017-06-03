package com.fd.admin.controller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fd.admin.data_service.criptomonedas.bisto.BitsoCurrencies;
import com.fd.admin.data_service.criptomonedas.bisto.BitsoPayload;
import com.fd.criptocurrency.data_service.service.BitsoService;
import com.fd.criptocurrency.model.BalanceCriptoDivisas;
import com.fd.criptocurrency.model.FormBitsoBalance;
import com.fd.criptocurrency.model.result.BitsoPayloadResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping(value = "/bitso")
public class BitsoWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BitsoWebController.class);
    private static final String VIEW_BITSO = "bitso/viewBitso";
    
    @Autowired
    @Qualifier("bitsoServiceImpl")
    private BitsoService bitsoService;
    
    /**
     * 
     * @param model
     * @return
     */
    @GetMapping("/viewBitso")
    public String viewBitso(Model model) {
        FormBitsoBalance formBitsoBalance = new FormBitsoBalance();
        NumberFormat numberFormatter = NumberFormat.getNumberInstance(new Locale("ES","MX"));
        
        
        BitsoPayloadResult bitsoPayloadResult = bitsoService.getPayload();
        BalanceCriptoDivisas balanceCriptoDivisas = bitsoService.obtenerBalanceDivisas(bitsoPayloadResult);
        BalanceCriptoDivisas balanceCriptoDivisasInicial = bitsoService.obtenerBalanceDivisasInicial();
        BalanceCriptoDivisas balanceCriptoDivisasGanacia = bitsoService.obtenerBalanceDivisasGanancia(balanceCriptoDivisas,balanceCriptoDivisasInicial);
        
        model.addAttribute("balanceTotalETH",balanceCriptoDivisas.getBalanceETH());
    	model.addAttribute("balanceTotalXRP",balanceCriptoDivisas.getBalanceXRP());
    	model.addAttribute("balanceTotalBTC",balanceCriptoDivisas.getBalanceBTC());
    	model.addAttribute("balanceTotalMXN",balanceCriptoDivisas.getBalanceMXN());
    	
    	model.addAttribute("balanceTotalETH_MXN",numberFormatter.format(balanceCriptoDivisas.getBalanceETH_MXN()));
    	model.addAttribute("balanceTotalXRP_MXN",numberFormatter.format(balanceCriptoDivisas.getBalanceXRP_MXN()));
    	model.addAttribute("balanceTotalBTC_MXN",numberFormatter.format(balanceCriptoDivisas.getBalanceBTC_MXN()));
    	model.addAttribute("balanceTotalMXN_MXN",numberFormatter.format(balanceCriptoDivisas.getBalanceMXN_MXN()));
    	model.addAttribute("balanceTotal_MXN",numberFormatter.format(balanceCriptoDivisas.getBalanceTOTAL_MXN()));
        
    	model.addAttribute("inversionInicialETH",numberFormatter.format(balanceCriptoDivisasInicial.getBalanceETH_MXN()));
    	model.addAttribute("inversionInicialXRP",numberFormatter.format(balanceCriptoDivisasInicial.getBalanceXRP_MXN()));
    	model.addAttribute("inversionInicialBTC",numberFormatter.format(balanceCriptoDivisasInicial.getBalanceBTC_MXN()));
    	model.addAttribute("inversionInicialMXN",numberFormatter.format(balanceCriptoDivisasInicial.getBalanceMXN_MXN()));
    	model.addAttribute("inversionInicialTotalMXN",numberFormatter.format(balanceCriptoDivisasInicial.getBalanceTOTAL_MXN()));
    	
    	model.addAttribute("gananciaTotal_ETH",numberFormatter.format(balanceCriptoDivisasGanacia.getBalanceETH_MXN()));
    	model.addAttribute("gananciaTotal_XRP",numberFormatter.format(balanceCriptoDivisasGanacia.getBalanceXRP_MXN()));
    	model.addAttribute("gananciaTotal_BTC",numberFormatter.format(balanceCriptoDivisasGanacia.getBalanceBTC_MXN()));
    	model.addAttribute("gananciaTotal_MXN",numberFormatter.format(balanceCriptoDivisasGanacia.getBalanceMXN_MXN()));
    	model.addAttribute("gananciaTotalMXN_MXN",numberFormatter.format(balanceCriptoDivisasGanacia.getBalanceTOTAL_MXN()));
    	
        Gson objGson = new GsonBuilder().setPrettyPrinting().create();
        String json = objGson.toJson(bitsoPayloadResult.getBitsoPayloadList());
        model.addAttribute("bitsoPayloadList",json);
        
        model.addAttribute("formBitsoBalance", formBitsoBalance);
        return VIEW_BITSO;
    }
    
    /**
     * Process Tiwilio SMS.
     * @param twilioSMSSearchCriteria
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/viewBitso")
    public String viewBitso(@ModelAttribute("formBitsoBalance") FormBitsoBalance formBitsoBalance, BindingResult result, Model model) {
        
    	String balanceETH = StringUtils.stripToEmpty(formBitsoBalance.getBalanceETH());
    	String balanceXRP = StringUtils.stripToEmpty(formBitsoBalance.getBalanceXRP());
    	String balanceBTC = StringUtils.stripToEmpty(formBitsoBalance.getBalanceBTC());
    	
    	
    	BigDecimal balanceETHDecimal =  new BigDecimal(balanceETH);
    	//BigDecimal balanceXRPDecimal =  new BigDecimal(balanceXRP);
    	//BigDecimal balanceBTCDecimal =  new BigDecimal(balanceBTC);
    	
    	BitsoPayloadResult bitsoPayloadResult = bitsoService.getPayload();
    	
    	//Agrupando por books
    	Map<String,BitsoPayload> books = bitsoPayloadResult.getBitsoPayloadList().stream().collect(Collectors.toMap(BitsoPayload::getBook,Function.identity()));
    	
    	BitsoPayload payloadETH = books.get(BitsoCurrencies.eth_mxn.getCurrency());
    	
    	
        return VIEW_BITSO;
    }
    
    
//    Map<String,BitsoTricker> mapBitsoTricker = new HashMap<>(); 
//	/*
//	 * Obtener el JSONArray de las divisas que se encuentran en el atributo payload.
//	 */
//	JsonArray jsonArray = jsonTricker.getJsonArray("payload");
//	jsonArray.getValuesAs(JsonObject.class).forEach(item->{
//		JsonObject jObj = (JsonObject) item;
//		
//		BitsoTricker bitsoTricker = new BitsoTricker();
//		bitsoTricker.setHigh(new BigDecimal(jObj.getString("high")));
//		bitsoTricker.setLast(new BigDecimal(jObj.getString("last")));
//		bitsoTricker.setCreated_at(LocalDateTime.parse(jObj.getString("created_at"),DateTimeFormatter.ISO_OFFSET_DATE_TIME));
//		bitsoTricker.setBook(jObj.getString("book"));
//		bitsoTricker.setVolume(new BigDecimal(jObj.getString("volume")));
//		bitsoTricker.setVwap(new BigDecimal(jObj.getString("vwap")));
//		bitsoTricker.setLow(new BigDecimal(jObj.getString("low")));
//		bitsoTricker.setAsk(new BigDecimal(jObj.getString("ask")));
//		bitsoTricker.setBid(new BigDecimal(jObj.getString("bid")));
//		
//		mapBitsoTricker.put(bitsoTricker.getBook(),bitsoTricker);
//		
//	});
//	
//	
//	BitsoTricker ethBT = mapBitsoTricker.get(BitsoCurrencies.eth_mxn.getCurrency());
//	BigDecimal _subTotal = ethBT.getBid().multiply(eth);
//	BigDecimal _comision = _subTotal.multiply(comision);
//	BigDecimal _total = _subTotal.subtract(_comision); 
    
}
