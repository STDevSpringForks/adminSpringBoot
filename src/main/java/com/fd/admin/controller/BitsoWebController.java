package com.fd.admin.controller;

import java.math.BigDecimal;
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
import com.fd.admin.data_service.criptomonedas.bisto.BitsoPayloadTicker;
import com.fd.criptocurrency.data_service.service.BitsoService;
import com.fd.criptocurrency.data_service.utils.UtilsBigDecimal;
import com.fd.criptocurrency.model.BalanceCriptoDivisas;
import com.fd.criptocurrency.model.FormBitsoBalance;
import com.fd.criptocurrency.model.OrderBookResult;
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
    private static final String VIEW_BITSO_ORDER_BOOK = "bitso/viewBitsoOrderBook";
    
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
        model.addAttribute("formBitsoBalance", formBitsoBalance);
        
        BalanceCriptoDivisas balanceCriptoDivisasInicial = bitsoService.obtenerBalanceDivisasInicial();
        model.addAttribute("inversionInicialETH",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasInicial.getBalanceETH_MXN()));
    	model.addAttribute("inversionInicialXRP",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasInicial.getBalanceXRP_MXN()));
    	model.addAttribute("inversionInicialBTC",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasInicial.getBalanceBTC_MXN()));
    	model.addAttribute("inversionInicialMXN",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasInicial.getBalanceMXN_MXN()));
    	model.addAttribute("inversionInicialTotalMXN",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasInicial.getBalanceTOTAL_MXN()));
        
        BitsoPayloadResult bitsoPayloadResult = bitsoService.getPayload();
        Gson objGson = new GsonBuilder().setPrettyPrinting().create();
        String json = objGson.toJson(bitsoPayloadResult.getBitsoPayloadList());
        model.addAttribute("bitsoPayloadList",json);
        
        BalanceCriptoDivisas balanceCriptoDivisas = bitsoService.obtenerBalanceDivisas(bitsoPayloadResult);
        model.addAttribute("balanceTotalETH",balanceCriptoDivisas.getBalanceETH());
    	model.addAttribute("balanceTotalXRP",balanceCriptoDivisas.getBalanceXRP());
    	model.addAttribute("balanceTotalBTC",balanceCriptoDivisas.getBalanceBTC());
    	model.addAttribute("balanceTotalMXN",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceMXN()));
        
    	model.addAttribute("balanceTotalETH_MXN",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceETH_MXN()));
    	model.addAttribute("balanceTotalXRP_MXN",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceXRP_MXN()));
    	model.addAttribute("balanceTotalBTC_MXN",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceBTC_MXN()));
    	model.addAttribute("balanceTotalMXN_MXN",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceMXN_MXN()));
    	model.addAttribute("balanceTotal_MXN",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceTOTAL_MXN()));
    	
    	model.addAttribute("comisionTOTAL_MXN",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getComisionTOTAL_MXN()));
    	
        BalanceCriptoDivisas balanceCriptoDivisasGanacia = bitsoService.obtenerBalanceDivisasGanancia(balanceCriptoDivisas,balanceCriptoDivisasInicial);
        
    	model.addAttribute("gananciaTotal_ETH",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasGanacia.getBalanceETH_MXN()));
    	model.addAttribute("gananciaTotal_XRP",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasGanacia.getBalanceXRP_MXN()));
    	model.addAttribute("gananciaTotal_BTC",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasGanacia.getBalanceBTC_MXN()));
    	model.addAttribute("gananciaTotal_MXN",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasGanacia.getBalanceMXN_MXN()));
    	model.addAttribute("gananciaTotalMXN_MXN",UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasGanacia.getBalanceTOTAL_MXN()));
    	
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
    	Map<String,BitsoPayloadTicker> books = bitsoPayloadResult.getBitsoPayloadList().stream().collect(Collectors.toMap(BitsoPayloadTicker::getBook,Function.identity()));
    	
    	BitsoPayloadTicker payloadETH = books.get(BitsoCurrencies.eth_mxn.getCurrency());
    	
    	
        return VIEW_BITSO;
    }
    
    
    @GetMapping("/viewBitsoOrderBook")
    public String viewBitsoOrderBook(Model model) {
        
    	OrderBookResult orderBookResult = bitsoService.obtenerOrdenDeCompras();
        Gson objGson = new GsonBuilder().setPrettyPrinting().create();
        String json = objGson.toJson(orderBookResult.getBitsoPayloadOrderBook().getBids());
        model.addAttribute("orderBookResult",json);
        
    	
        return VIEW_BITSO_ORDER_BOOK;
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
