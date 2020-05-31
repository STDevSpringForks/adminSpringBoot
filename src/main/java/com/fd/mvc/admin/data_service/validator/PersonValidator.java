package com.fd.mvc.admin.data_service.validator;

import com.fd.mvc.admin.model.entity.Person;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 
 * @author Muguruza
 *
 */
@Component
public class PersonValidator implements Validator {

	@Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	Person personListDetailsEntity = (Person) target;
        
        //Start firstName
        String firstName = StringUtils.stripToEmpty(personListDetailsEntity.getFirstName());
        if(StringUtils.isBlank(firstName)){
            errors.rejectValue("firstName", "firstNameRequired", "firstName es requerido");
        }
        //End firstName
        
        //TODO: Continue...	
        
        
    }
	
}