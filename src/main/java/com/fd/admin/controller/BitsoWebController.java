package com.fd.admin.controller;

import static com.fd.admin.data_service.criptomonedas.bisto.BitsoConstants.BITSO_URL_TICKER;

import java.math.BigDecimal;
import java.text.NumberFormat;
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
import com.fd.criptocurrency.model.PersonBalance;
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
    
    /**
     * 
     * @param model
     * @return
     */
    @GetMapping("/viewBitso")
    public String viewBitso(Model model) {
        FormBitsoBalance formBitsoBalance = new FormBitsoBalance();
        
        PersonBalance pbF = new PersonBalance("Froy",new BigDecimal("9.29"),new BigDecimal("0.05120912"),new BigDecimal("0.0"),new BigDecimal("0.00001286"));
        PersonBalance pbO = new PersonBalance("Ofe",new BigDecimal("0.0"),new BigDecimal("6.73243454"),new BigDecimal("1218.673218"),new BigDecimal("0.0"));
        PersonBalance pbL = new PersonBalance("Lily",new BigDecimal("23140.03"),new BigDecimal("21.00785276"),new BigDecimal("0.9828"),new BigDecimal("0.00000585"));
        
        /* Start Mi Balance */
        //BigDecimal balanceETH = new BigDecimal("27.79149642");
        BigDecimal balanceETH = pbF.getBalanceETH().add(pbO.getBalanceETH()).add(pbL.getBalanceETH());
        
        //BigDecimal balanceXRP = new BigDecimal("1219.656018");
        BigDecimal balanceXRP = pbF.getBalanceXRP().add(pbO.getBalanceXRP()).add(pbL.getBalanceXRP());
        
        //BigDecimal balanceBTC = new BigDecimal("0.00001871");
        BigDecimal balanceBTC = pbF.getBalanceBTC().add(pbO.getBalanceBTC()).add(pbL.getBalanceBTC());
        
        //BigDecimal balanceMXN = new BigDecimal("23149.32");
        BigDecimal balanceMXN = pbF.getBalanceMXN().add(pbO.getBalanceMXN()).add(pbL.getBalanceMXN());
        
        model.addAttribute("balanceETH",balanceETH);
    	model.addAttribute("balanceXRP",balanceXRP);
    	model.addAttribute("balanceBTC",balanceBTC);
    	model.addAttribute("balanceMXN",balanceMXN);
        /* End Mi Balance */
    	
    	BitsoPayloadResult bitsoPayloadResult = this.getPayload();
        /* Agrupando por books */
    	Map<String,BitsoPayload> books = bitsoPayloadResult.getBitsoPayloadList().stream().collect(Collectors.toMap(BitsoPayload::getBook,Function.identity()));
    	
    	BitsoPayload payloadETH = books.get(BitsoCurrencies.eth_mxn.getCurrency());
    	BitsoPayload payloadXRP = books.get(BitsoCurrencies.xrp_mxn.getCurrency());
    	BitsoPayload payloadBTC = books.get(BitsoCurrencies.btc_mxn.getCurrency());
    	
    	/* Start Balance Total */
    	BigDecimal balanceTotalETH_MXN = balanceETH.multiply(new BigDecimal(payloadETH.getAsk()));
    	BigDecimal balanceTotalXRP_MXN = balanceXRP.multiply(new BigDecimal(payloadXRP.getAsk()));
    	BigDecimal balanceTotalBTC_MXN = balanceBTC.multiply(new BigDecimal(payloadBTC.getAsk()));
    	BigDecimal balanceTotalMXN_MXN = balanceMXN.multiply(new BigDecimal("1"));
    	BigDecimal balanceTotal_MXN = balanceTotalETH_MXN.add(balanceTotalXRP_MXN).add(balanceTotalBTC_MXN).add(balanceTotalMXN_MXN);
    	
    	model.addAttribute("balanceTotalETH_MXN",NumberFormat.getCurrencyInstance().format(balanceTotalETH_MXN));
    	model.addAttribute("balanceTotalXRP_MXN",NumberFormat.getCurrencyInstance().format(balanceTotalXRP_MXN));
    	model.addAttribute("balanceTotalBTC_MXN",NumberFormat.getCurrencyInstance().format(balanceTotalBTC_MXN));
    	model.addAttribute("balanceTotalMXN_MXN",NumberFormat.getCurrencyInstance().format(balanceTotalMXN_MXN));
    	model.addAttribute("balanceTotal_MXN",NumberFormat.getCurrencyInstance().format(balanceTotal_MXN));
    	/* End Balance Total */
        
        /* Start Mi Inversion Inicial */
        BigDecimal inversionInicialETH = new BigDecimal("55137.96");
        BigDecimal inversionInicialXRP = new BigDecimal("10000");
        BigDecimal inversionInicialBTC = new BigDecimal("0.0");
        BigDecimal inversionInicialMXN = new BigDecimal("23140.03");
        
        model.addAttribute("inversionInicialETH",NumberFormat.getCurrencyInstance().format(inversionInicialETH));
    	model.addAttribute("inversionInicialXRP",NumberFormat.getCurrencyInstance().format(inversionInicialXRP));
    	model.addAttribute("inversionInicialBTC",NumberFormat.getCurrencyInstance().format(inversionInicialBTC));
    	model.addAttribute("inversionInicialMXN",NumberFormat.getCurrencyInstance().format(inversionInicialMXN));
    	
    	BigDecimal inversionInicialTotalMXN = inversionInicialETH.add(inversionInicialXRP).add(inversionInicialBTC).add(inversionInicialMXN);
    	model.addAttribute("inversionInicialTotalMXN",NumberFormat.getCurrencyInstance().format(inversionInicialTotalMXN));
        /* End Mi Inversion Inicial */
    	
    	model.addAttribute("gananciaTotal_ETH",NumberFormat.getCurrencyInstance().format(balanceTotalETH_MXN.subtract(inversionInicialETH)));
    	model.addAttribute("gananciaTotal_XRP",NumberFormat.getCurrencyInstance().format(balanceTotalXRP_MXN.subtract(inversionInicialXRP)));
    	model.addAttribute("gananciaTotal_BTC",NumberFormat.getCurrencyInstance().format(balanceTotalBTC_MXN.subtract(inversionInicialBTC)));
    	model.addAttribute("gananciaTotal_MXN",NumberFormat.getCurrencyInstance().format(balanceTotalMXN_MXN.subtract(inversionInicialMXN)));
    	model.addAttribute("gananciaTotalMXN_MXN",NumberFormat.getCurrencyInstance().format(balanceTotal_MXN.subtract(inversionInicialTotalMXN)));
    	
        model.addAttribute("payloadETH",payloadETH);
        model.addAttribute("payloadXRP",payloadXRP);
        model.addAttribute("payloadBTC",payloadBTC);
        
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
    	
    	BitsoPayloadResult bitsoPayloadResult = this.getPayload();
    	
    	//Agrupando por books
    	Map<String,BitsoPayload> books = bitsoPayloadResult.getBitsoPayloadList().stream().collect(Collectors.toMap(BitsoPayload::getBook,Function.identity()));
    	
    	BitsoPayload payloadETH = books.get(BitsoCurrencies.eth_mxn.getCurrency());
    	
    	
        return VIEW_BITSO;
    }
    
    /**
     * Obtener los payload de Bitso.
     * @return
     */
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
