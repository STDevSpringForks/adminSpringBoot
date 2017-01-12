package com.fd.adminSpringBoot.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import com.fd.adminSpringBoot.HomeController;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping(value = "/bitso")
public class BitsoWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    private static final String VIEW_BITSO = "bitso/viewBitso";
    
    @RequestMapping(value = "/viewBitso", method = RequestMethod.GET)
    public String home(Model model) {
        
//        JSONObject jsonObjectBTC_MXN = new JSONObject("https://api.bitso.com/v2/ticker?book=btc_mxn");
//        LOGGER.info(jsonObjectBTC_MXN.toString());
//        
//        
//        JSONObject jsonObjectETH_MXN = new JSONObject("https://api.bitso.com/v2/ticker?book=eth_mxn");
//        LOGGER.info(jsonObjectETH_MXN.toString());
        
        try{
            
        
        
//        JSONObject o = new JSONObject();
//        o.put("key", bitsoKey);
//        o.put("nonce", nonce);
//        o.put("signature", signature);
//        String body = o.toString();
        String body = "";
//        String url = "https://api.bitso.com/v2/balance";
        String url = "https://api.bitso.com/v2/ticker?book=btc_mxn";

        // Send request
        HttpPost postRequest = new HttpPost(url);
        postRequest.addHeader("Content-Type", "application/json");
        //postRequest.setEntity(new StringEntity(body));

        CloseableHttpResponse response = HttpClients.createDefault().execute(postRequest);
        BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String inputLine;
        StringBuffer responseBody = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            responseBody.append(inputLine);
        }
        in.close();

        System.out.println(responseBody.toString());
        
        JSONObject jsonObjectBTC_MXN = new JSONObject(responseBody.toString());
        LOGGER.info(jsonObjectBTC_MXN.getString("vwap"));
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return VIEW_BITSO;
    }
    
}
