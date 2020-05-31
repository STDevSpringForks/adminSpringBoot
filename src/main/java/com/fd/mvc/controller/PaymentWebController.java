package com.fd.mvc.controller;

import com.fd.mvc.exception.DefaultCheckedException;
import com.fd.mvc.service.impl.PaymentValidator;
import com.fd.mvc.model.PaymentSearchCriteria;
import com.fd.mvc.model.entity.PaymentEntity;
import com.fd.mvc.model.entity.PromoCodesEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.fd.mvc.common.Constants.FORM_PAYMENT;
import static com.fd.mvc.common.Constants.VIEW_PAYMENT;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/modules/finance/payments")
public class PaymentWebController {

    private final PaymentValidator paymentValidator;

    @GetMapping("/viewPaymentes")
    public String viewPaymentes(Model model) {
        List<PaymentEntity> paymentEntityList = new ArrayList<PaymentEntity>();
        model.addAttribute("paymentEntityList", paymentEntityList);
        return VIEW_PAYMENT;
    }

    @GetMapping("/formPayment")
    public String formPayment(Model model) {
        PaymentSearchCriteria paymentSearchCriteria = new PaymentSearchCriteria();
        model.addAttribute("paymentSearchCriteria", paymentSearchCriteria);
        return FORM_PAYMENT;
    }

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
            log.debug("@@@ processPayment() ", e);
            result.addError(new ObjectError("exception", e.getMessage()));
        }

        return FORM_PAYMENT;
    }

    private void save(PaymentSearchCriteria paymentSearchCriteria) throws DefaultCheckedException {

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

            log.info("Begin Transaction...");
            // create a student object
            sessionPaymentEntity.beginTransaction();
            sessionPromoCodesEntity.beginTransaction();

            // start a transaction
            log.info("Save paymentEntity...");
            sessionPaymentEntity.save(paymentEntity);
            log.info("Save promoCodesEntity...");
            sessionPromoCodesEntity.save(promoCodesEntity);

            // save the student object
            sessionPaymentEntity.getTransaction().commit();
            sessionPromoCodesEntity.getTransaction().commit();

            // commit transaction
            log.info("Done...");

        } catch (Exception e) {
            log.debug("@@@ save() ", e);
            throw new DefaultCheckedException(e.getMessage());
        } finally {
            factoryPaymentEntity.close();
            factoryPromoCodesEntity.close();
        }

    }

}
