package com.fd.mvc.admin.controller;

import com.fd.mvc.admin.data_service_api.GoogleMapService;
import com.fd.mvc.criptocurrency.data_service.service.BitsoService;
import com.fd.mvc.criptocurrency.data_service.utils.UtilsBigDecimal;
import com.fd.mvc.criptocurrency.model.BalanceCriptoDivisas;
import com.fd.mvc.criptocurrency.model.FormBitsoBalance;
import com.fd.mvc.criptocurrency.model.OrderBookResult;
import com.fd.mvc.criptocurrency.model.result.BitsoPayloadResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping(value = "/bitso")
public class BitsoWebController {

    private static final String VIEW_BITSO = "bitso/viewBitso";
    private static final String VIEW_BITSO_ORDER_BOOK = "bitso/viewBitsoOrderBook";

    private BitsoService bitsoService;

    private GoogleMapService googleMapService;

    @GetMapping("/viewBitso")
    public String viewBitso(@ModelAttribute("formBitsoBalance") FormBitsoBalance formBitsoBalance, Model model) {

        model.addAttribute("formBitsoBalance", formBitsoBalance);

        BalanceCriptoDivisas balanceCriptoDivisasInicial = bitsoService.obtenerBalanceDivisasInicial();
        model.addAttribute("inversionInicialETH", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasInicial.getBalanceETH_MXN()));
        model.addAttribute("inversionInicialXRP", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasInicial.getBalanceXRP_MXN()));
        model.addAttribute("inversionInicialBTC", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasInicial.getBalanceBTC_MXN()));
        model.addAttribute("inversionInicialMXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasInicial.getBalanceMXN_MXN()));
        model.addAttribute("inversionInicialTotalMXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasInicial.getBalanceTOTAL_MXN()));

        BitsoPayloadResult bitsoPayloadResult = bitsoService.getPayload();
        Gson objGson = new GsonBuilder().setPrettyPrinting().create();
        String json = objGson.toJson(bitsoPayloadResult.getBitsoPayloadList());
        model.addAttribute("bitsoPayloadList", json);

        BalanceCriptoDivisas balanceCriptoDivisas = bitsoService.obtenerBalanceDivisas(bitsoPayloadResult);
        model.addAttribute("balanceTotalETH", balanceCriptoDivisas.getBalanceETH());
        model.addAttribute("balanceTotalXRP", balanceCriptoDivisas.getBalanceXRP());
        model.addAttribute("balanceTotalBTC", balanceCriptoDivisas.getBalanceBTC());
        model.addAttribute("balanceTotalMXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceMXN()));

        model.addAttribute("balanceTotalETH_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceETH_MXN()));
        model.addAttribute("balanceTotalXRP_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceXRP_MXN()));
        model.addAttribute("balanceTotalBTC_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceBTC_MXN()));
        model.addAttribute("balanceTotalMXN_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceMXN_MXN()));
        model.addAttribute("balanceTotal_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceTOTAL_MXN()));

        model.addAttribute("comisionTOTAL_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getComisionTOTAL_MXN()));

        BalanceCriptoDivisas balanceCriptoDivisasGanacia = bitsoService.obtenerBalanceDivisasGanancia(balanceCriptoDivisas, balanceCriptoDivisasInicial);

        model.addAttribute("gananciaTotal_ETH", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasGanacia.getBalanceETH_MXN()));
        model.addAttribute("gananciaTotal_XRP", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasGanacia.getBalanceXRP_MXN()));
        model.addAttribute("gananciaTotal_BTC", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasGanacia.getBalanceBTC_MXN()));
        model.addAttribute("gananciaTotal_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasGanacia.getBalanceMXN_MXN()));
        model.addAttribute("gananciaTotalMXN_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasGanacia.getBalanceTOTAL_MXN()));

        //-----------------------------------------------------


        /* Exampe: https://www.petrikainulainen.net/programming/spring-framework/spring-batch-tutorial-reading-information-from-a-database/ */
    	
    	
    	/*  Insertar forEach 
    	Session session = HibernateUtil.getSessionfactory().openSession();
    	Transaction tx = null;
    	try{
    		tx = session.beginTransaction();
    		
    		IntStream.range(0,1000).forEach(
    				nbr -> {
    					System.out.println("Contador ->-- : " + nbr);
    					GeocoderRequest geocoderRequest = new GeocoderRequest("4763 HIGHWAY 107 S","","PLAUCHEVILLE","LA","71362","AVOYELLES");
    					session.save(geocoderRequest);
    				}
    		);
        	
    		tx.commit();
    	}catch(Exception ex){
    		
    		if(tx != null){
    			tx.rollback();
    		}
    		ex.printStackTrace();
    	}
    	finally{
    		session.close();
    	}
    	*/


//    	GeocoderRequestParams geocoderRequestParams = new GeocoderRequestParams();
//    	Session session = HibernateUtil.getSessionfactory().openSession();
//    	Transaction tx = null;
//    	try{
//    		tx = session.beginTransaction();
//    		
//    		
//    		CriteriaBuilder builder = session.getCriteriaBuilder();
//
//        	CriteriaQuery<GeocoderRequest> criteria = builder.createQuery( GeocoderRequest.class );
//        	Root<GeocoderRequest> root = criteria.from(GeocoderRequest.class);
//        	criteria.select(root);
//        	List<GeocoderRequest> geocoderRequestList = session.createQuery( criteria ).getResultList();
//        	geocoderRequestParams.setGeocoderRequestList(geocoderRequestList);
//    		
//        	
//    		tx.commit();
//    	}catch(Exception ex){
//    		
//    		if(tx != null){
//    			tx.rollback();
//    		}
//    		ex.printStackTrace();
//    	}
//    	finally{
//    		session.close();
//    	}
//    	
//    	
//    	googleMapService.retrieveGeocoding(geocoderRequestParams);


        return VIEW_BITSO;
    }

    @PostMapping("/viewBitso")
    public String viewBitso(@ModelAttribute("formBitsoBalance") FormBitsoBalance formBitsoBalance, BindingResult result, Model model) {

        model.addAttribute("formBitsoBalance", formBitsoBalance);

        BalanceCriptoDivisas balanceCriptoDivisasInicial = bitsoService.obtenerBalanceDivisasInicial();
        model.addAttribute("inversionInicialETH", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasInicial.getBalanceETH_MXN()));
        model.addAttribute("inversionInicialXRP", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasInicial.getBalanceXRP_MXN()));
        model.addAttribute("inversionInicialBTC", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasInicial.getBalanceBTC_MXN()));
        model.addAttribute("inversionInicialMXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasInicial.getBalanceMXN_MXN()));
        model.addAttribute("inversionInicialTotalMXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasInicial.getBalanceTOTAL_MXN()));

        BitsoPayloadResult bitsoPayloadResult = bitsoService.getPayload();
        Gson objGson = new GsonBuilder().setPrettyPrinting().create();
        String json = objGson.toJson(bitsoPayloadResult.getBitsoPayloadList());
        model.addAttribute("bitsoPayloadList", json);

        BalanceCriptoDivisas balanceCriptoDivisas = bitsoService.obtenerBalanceDivisas(bitsoPayloadResult, formBitsoBalance);
        model.addAttribute("balanceTotalETH", balanceCriptoDivisas.getBalanceETH());
        model.addAttribute("balanceTotalXRP", balanceCriptoDivisas.getBalanceXRP());
        model.addAttribute("balanceTotalBTC", balanceCriptoDivisas.getBalanceBTC());
        model.addAttribute("balanceTotalMXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceMXN()));

        model.addAttribute("balanceTotalETH_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceETH_MXN()));
        model.addAttribute("balanceTotalXRP_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceXRP_MXN()));
        model.addAttribute("balanceTotalBTC_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceBTC_MXN()));
        model.addAttribute("balanceTotalMXN_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceMXN_MXN()));
        model.addAttribute("balanceTotal_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getBalanceTOTAL_MXN()));

        model.addAttribute("comisionTOTAL_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisas.getComisionTOTAL_MXN()));

        BalanceCriptoDivisas balanceCriptoDivisasGanacia = bitsoService.obtenerBalanceDivisasGanancia(balanceCriptoDivisas, balanceCriptoDivisasInicial);

        model.addAttribute("gananciaTotal_ETH", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasGanacia.getBalanceETH_MXN()));
        model.addAttribute("gananciaTotal_XRP", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasGanacia.getBalanceXRP_MXN()));
        model.addAttribute("gananciaTotal_BTC", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasGanacia.getBalanceBTC_MXN()));
        model.addAttribute("gananciaTotal_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasGanacia.getBalanceMXN_MXN()));
        model.addAttribute("gananciaTotalMXN_MXN", UtilsBigDecimal.printDecimalFormatLocale(balanceCriptoDivisasGanacia.getBalanceTOTAL_MXN()));


        return VIEW_BITSO;
    }


    @GetMapping("/viewBitsoOrderBook")
    public String viewBitsoOrderBook(Model model) {

        OrderBookResult orderBookResult = bitsoService.obtenerOrdenDeCompras();
        Gson objGson = new GsonBuilder().setPrettyPrinting().create();
        String jsonBids = objGson.toJson(orderBookResult.getBitsoPayloadOrderBook().getBids());
        String jsonAsks = objGson.toJson(orderBookResult.getBitsoPayloadOrderBook().getAsks());
        model.addAttribute("orderBookResultCompra", jsonBids);
        model.addAttribute("orderBookResultVenta", jsonAsks);


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
