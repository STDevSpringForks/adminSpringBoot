package com.fd.mvc.controller;

import com.fd.mvc.exception.DefaultCheckedException;
import com.fd.mvc.common.AdminUtils;
import com.fd.mvc.service.impl.PalindromeValidator;
import com.fd.mvc.service.ObjectsService;
import com.fd.mvc.model.PalindromeSearchCriteria;
import com.fd.mvc.model.SerializableGeneralSearchCriteria;
import com.fd.mvc.model.entity.ObjectsEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import static com.fd.mvc.common.Constants.*;

/**
 * check:
 * http://howtodoinjava.com/spring/spring-mvc/spring-mvc-display-validate-and-submit-form-example/
 * 
 *
 */
@Slf4j
@AllArgsConstructor
@Controller
@RequestMapping("/exercises")
public class ExcerciseWebController {

    private final PalindromeValidator palindromeValidator;
    private final ObjectsService objectsService;

    @RequestMapping(value = "/viewPalindrome", method = RequestMethod.GET)
    public String viewPalindrome(Model model) {
        PalindromeSearchCriteria palindromeSearchCriteria = new PalindromeSearchCriteria();
        model.addAttribute("palindromeSearchCriteria", palindromeSearchCriteria);
        return VIEW_PALINDROMO;
    }

    @RequestMapping(value = "/viewPalindrome", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String resultPalindrome(@ModelAttribute("palindromeSearchCriteria") PalindromeSearchCriteria searchCriteria,
            BindingResult result, Model model) {
        // event.prevent server side.
        try {
            palindromeValidator.validate(searchCriteria, result);

            if (result.hasErrors()) {
                return VIEW_PALINDROMO;
            }

            boolean b = isPalindrome(searchCriteria.getPhrase());
            StringBuilder sb = new StringBuilder(b ? "" : "No ");
            sb.append(" es palindromo");

            model.addAttribute("msgResult", sb.toString());

        } catch (DefaultCheckedException e) {
            log.debug("RequestMapping: viewPalindrome", e);
            result.addError(new ObjectError("errorMsg", e.getMessage()));
        }

        return VIEW_PALINDROMO;
    }

    /**
     * Este método deberia de estar en Service y no en Controller.
     * 
     * @param phrase
     * @return
     * @throws Exception
     */
    public static boolean isPalindrome(String phrase) throws DefaultCheckedException {
        if (StringUtils.hasText(phrase)) {
            String phraseAux = StringUtils.trimAllWhitespace(phrase).toUpperCase();

            phraseAux = AdminUtils.eliminarAcentos(phraseAux);
            
            if (phraseAux.length() >= 2) {
                String wordReverse = new StringBuilder(phraseAux).reverse().toString();
                return phraseAux.equals(wordReverse);
            } else {
                throw new DefaultCheckedException("The phrase is less than 2 characteres.");
            }
        } else {
            throw new DefaultCheckedException("The phrase is empty.");
        }
    }

    
    @GetMapping(value = "/viewSerializable")
    public String viewSerializable(Model model) {
    	SerializableGeneralSearchCriteria serializableGeneralSearchCriteria = new SerializableGeneralSearchCriteria();
        model.addAttribute("serializableGeneralSearchCriteria", serializableGeneralSearchCriteria); // commandName="generalProfile"
        
        objectsService.retrieveObjects();
        
        return VIEW_SERIALIZABLE;
    }
    
    @PostMapping(value = "/viewSerializable")
    public String processSerializable(@ModelAttribute("serializableGeneralSearchCriteria") SerializableGeneralSearchCriteria searchCriteria,BindingResult result,Model model) {
    	
    	searchCriteria.setBrowser("NADA");
    	searchCriteria.setUser("Muguruza");
    	
    	try {
			ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(byteArray);
			oos.writeObject(searchCriteria);
			
			this.save(byteArray);
			
		} catch (Exception e) {
			result.addError(new ObjectError("exception", e.getMessage()));
		}
		model.addAttribute("serializableGeneralSearchCriteria", searchCriteria);
        return VIEW_SERIALIZABLE;
    }
    
    @GetMapping(value = "viewJQuery3")
    public String viewJQuery3(Model model){
    	return VIEW_JQUERY3;
    }
    
    private void save(ByteArrayOutputStream byteArray) throws DefaultCheckedException {

        // Create a session factory
        SessionFactory factoryObjectsEntity = new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(ObjectsEntity.class).buildSessionFactory();
        
        // Create session
        Session sessionObjectsEntity = factoryObjectsEntity.getCurrentSession();

        try {
            // use the session object to save JavaObject
        	ObjectsEntity objectsEntity = new ObjectsEntity();
        	objectsEntity.setObjeto(byteArray.toByteArray());
            
            log.info("Begin Transaction...");
            // create a student object
            sessionObjectsEntity.beginTransaction();

            // start a transaction
            log.info("Save ObjectsEntity...");
            sessionObjectsEntity.save(objectsEntity);

            // save the student object
            sessionObjectsEntity.getTransaction().commit();

            // commit transaction
            log.info("Done...");

        }catch(Exception e){
        	 throw new DefaultCheckedException(e.getMessage());
        }finally {
        	factoryObjectsEntity.close();
        }

    }

}
