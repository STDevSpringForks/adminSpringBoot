package com.fd.admin.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fd.admin.data_service.validator.PaymentValidator;
import com.fd.admin.model.criteria.PaymentSearchCriteria;
import com.fd.admin.model.entity.PaymentEntity;
import com.fd.admin.model.entity.PromoCodesEntity;

/**
 * This is a Controller for handler payments.
 * @author Muguruza
 *
 */
@Controller
@RequestMapping("/modules/finance/payments")
public class PaymentWebController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentWebController.class);
	private static final String VIEW_PAYMENT = "modules/finance/payments/viewPaymentes";
    private static final String FORM_PAYMENT = "modules/finance/payments/formPayment";

    @Autowired
    private PaymentValidator paymentValidator;

    /**
     * This is a list payments view.
     * @param model
     * @return
     */
    @GetMapping("/viewPaymentes")
    public String viewPaymentes(Model model) {
        List<PaymentEntity> paymentEntityList = new ArrayList<PaymentEntity>();
        model.addAttribute("paymentEntityList", paymentEntityList);
        return VIEW_PAYMENT;
    }
    
    /**
     * This is a view formPayment. 
     * @param model
     * @return
     */
    @GetMapping("/formPayment")
    public String formPayment(Model model) {
    	PaymentSearchCriteria paymentSearchCriteria = new PaymentSearchCriteria();
        model.addAttribute("paymentSearchCriteria", paymentSearchCriteria);
        return FORM_PAYMENT;
    }

    /**
     * This is a process form payment for save in DB.
     * @param paymentEntity
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/formPayment")
    public String processPayment(@ModelAttribute("paymentSearchCriteria") PaymentSearchCriteria paymentSearchCriteria, BindingResult result, Model model) {
        try {
        	paymentValidator.validate(paymentSearchCriteria, result);
            if (result.hasErrors()) {
                return FORM_PAYMENT;
            }
            
            this.save(paymentSearchCriteria);
            model.addAttribute("msgResult", "Amount successfully save (Hibernate) ");

        } catch (Exception e) {
            LOGGER.debug("processPayment Exception ", e);
            result.addError(new ObjectError("exception", e.getMessage()));
        }

        return FORM_PAYMENT;
    }
    
    private void save(PaymentSearchCriteria paymentSearchCriteria) throws Exception {

        // Create a session factory
        SessionFactory factoryPaymentEntity = new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(PaymentEntity.class).buildSessionFactory();
        
        SessionFactory factoryPromoCodesEntity = new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(PromoCodesEntity.class).buildSessionFactory();
        
        // Create session
        Session sessionPaymentEntity = factoryPaymentEntity.getCurrentSession();
        Session sessionPromoCodesEntity = factoryPromoCodesEntity.getCurrentSession();

        try {
            // use the session object to save JavaObject
            PaymentEntity paymentEntity = new PaymentEntity();
            paymentEntity.setAmount(new BigDecimal(paymentSearchCriteria.getAmount()));
            
            PromoCodesEntity promoCodesEntity = new PromoCodesEntity();
            promoCodesEntity.setPromoCode(paymentSearchCriteria.getPromoCode());

            LOGGER.info("Begin Transaction...");
            // create a student object
            sessionPaymentEntity.beginTransaction();
            sessionPromoCodesEntity.beginTransaction();

            // start a transaction
            LOGGER.info("Save paymentEntity...");
            sessionPaymentEntity.save(paymentEntity);
            LOGGER.info("Save promoCodesEntity...");
            sessionPromoCodesEntity.save(promoCodesEntity);

            // save the student object
            sessionPaymentEntity.getTransaction().commit();
            sessionPromoCodesEntity.getTransaction().commit();

            // commit transaction
            LOGGER.info("Done...");

        } finally {
        	factoryPaymentEntity.close();
        	factoryPromoCodesEntity.close();
        }

    }
	
}
