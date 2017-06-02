package com.fd.admin.controller;

import static com.fd.admin.data_service.criptomonedas.bisto.BitsoConstants.BITSO_URL_TICKER;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.json.JsonObject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fd.admin.data_service.criptomonedas.bisto.BitsoCurrencies;
import com.fd.admin.data_service.criptomonedas.bisto.BitsoPayload;
import com.fd.admin.data_service.criptomonedas.bisto.BitsoTicker;
import com.fd.criptocurrency.data_service.utils.Utils;
import com.fd.criptocurrency.model.FormBitsoBalance;
import com.fd.criptocurrency.model.result.BitsoPayloadResult;
import com.google.gson.Gson;


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
    
    @GetMapping("/viewBitso")
    public String viewBitso(Model model) {
        FormBitsoBalance formBitsoBalance = new FormBitsoBalance();
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
    	
    	BitsoPayloadResult bitsoPayloadResult = getPayload();
    	
    	//Agrupando por books
    	Map<String,BitsoPayload> books = bitsoPayloadResult.getBitsoPayloadList().stream().collect(
                Collectors.toMap(BitsoPayload::getBook,Function.identity()));
    	
    	BitsoPayload payloadETH = books.get(BitsoCurrencies.eth_mxn.getCurrency());
    	System.out.println(new BigDecimal(payloadETH.getBid()).multiply(balanceETHDecimal));
    	
    	
//        try {
//            twilioValidator.validate(twilioSMSSearchCriteria, result);
//            if (result.hasErrors()) {
//                return VIEW_BITSO;
//            }
//            
//            TwilioSMSResult twilioSMSResult = twilioService.sendSMS(twilioSMSSearchCriteria);
//            model.addAttribute("msgResult", twilioSMSResult.getMessage());
//
//        } catch (Exception e) {
//            LOGGER.debug("Exception processTiwilioSMS", e);
//            result.addError(new ObjectError("exception", e.getMessage()));
//        }
        
        return VIEW_BITSO;
    }
    
    @PostMapping("/getPayload")
    @ResponseBody
    public BitsoPayloadResult getPayload() {
    	BitsoPayloadResult bitsoPayloadResult = new BitsoPayloadResult();
    	BitsoTicker bitsoTicker = new BitsoTicker();
    	
    	JsonObject jsonTricker = Utils.readUrlJSON(BITSO_URL_TICKER);
            
    	//Obtener el valor booleano del atributo success, si este no se encuentra en el JSON obtener false por default.
    	if(jsonTricker.getBoolean("success",false)){
    		bitsoTicker = new Gson().fromJson(jsonTricker.toString(), BitsoTicker.class);
        }
	        	
        
    	bitsoPayloadResult.setBitsoPayloadList(bitsoTicker.getPayload());
    	return bitsoPayloadResult;
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
