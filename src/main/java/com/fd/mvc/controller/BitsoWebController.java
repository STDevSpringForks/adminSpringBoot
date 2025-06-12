package com.fd.mvc.controller;

import com.fd.mvc.common.UtilsBigDecimal;
import com.fd.mvc.model.BalanceCriptoDivisas;
import com.fd.mvc.model.BitsoPayloadResult;
import com.fd.mvc.model.FormBitsoBalance;
import com.fd.mvc.model.OrderBookResult;
import com.fd.mvc.service.BitsoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.fd.mvc.common.Constants.VIEW_BITSO;
import static com.fd.mvc.common.Constants.VIEW_BITSO_ORDER_BOOK;

@Controller
@RequestMapping(value = "/bitso")
public class BitsoWebController {

    private final BitsoService bitsoService;

    private static final Logger log = LoggerFactory.getLogger(BitsoWebController.class);

    public BitsoWebController(BitsoService bitsoService) {
        this.bitsoService = bitsoService;
    }

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

}
