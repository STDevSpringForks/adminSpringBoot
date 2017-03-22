//package com.fd.admin.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.fd.admin.data_service_api.OrderService;
//import com.fd.admin.model.CustomerInfo;
//import com.fd.admin.model.ProductOrder;
//
///**
// * 
// * @author Muguruza
// *
// */
//@Controller
//@RequestMapping("/email")
//public class EmailWebController {
//	
//	public static final String VIEW_EMAIL_TEST = "email/viewSendEmailTest";
//	
//	@Autowired
//	private OrderService orderService;
//	
//	@GetMapping("/viewSendEmailTest")
//	public String sendEmailTest(){
//		orderService.sendOrderConfirmation(this.getDummyOrder());
//		return VIEW_EMAIL_TEST;
//	}
//	
//	private ProductOrder getDummyOrder(){
//		ProductOrder order = new ProductOrder();
//		order.setOrderId("1111");
//		order.setProductName("Thinkpad T510");
//		order.setStatus("confirmed");
//		
//		CustomerInfo customerInfo = new CustomerInfo();
//		customerInfo.setName("Websystique Admin");
//		customerInfo.setAddress("WallStreet");
//		customerInfo.setEmail("youemail@gmail.com");
//		order.setCustomerInfo(customerInfo);
//		return order;
//	}
//	
//}
