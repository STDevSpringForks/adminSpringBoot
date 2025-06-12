package com.fd.mvc.common;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import static com.fd.mvc.common.Constants.APPLICATION_JSON;
import static com.fd.mvc.common.Constants.CONTENT_TYPE;

public class Utils {

    public static JsonObject readUrlJSON(String urlJSON) {
        JsonObject jsonTricker = null;

        try {
            HttpGet postRequest = new HttpGet(urlJSON);
            postRequest.addHeader(CONTENT_TYPE, APPLICATION_JSON);

            try (CloseableHttpResponse response = HttpClients.createDefault().execute(postRequest)) {
                Reader reader = new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8);
                jsonTricker = JsonParser.parseReader(reader).getAsJsonObject();
            }
        } catch (Exception e) {
            System.out.println("ERROR AL TRATAR DE OBTENER EL JSON DE " + urlJSON);
            e.printStackTrace();
        }

        return jsonTricker;
    }
}
