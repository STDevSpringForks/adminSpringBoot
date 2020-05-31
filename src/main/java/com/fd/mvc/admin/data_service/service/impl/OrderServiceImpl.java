//package com.fd.admin.data_service.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.fd.admin.data_service_api.MailService;
//import com.fd.admin.data_service_api.OrderService;
//import com.fd.admin.model.ProductOrder;
//
//@Service("orderServiceImpl")
//public class OrderServiceImpl implements OrderService{
//
//	@Autowired
//	private MailService mailService;
//
//	@Override
//	public void sendOrderConfirmation(ProductOrder productOrder) {
//		mailService.sendEmail(productOrder);
//	}
//	
//}
