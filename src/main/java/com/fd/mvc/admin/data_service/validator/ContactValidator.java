package com.fd.mvc.admin.data_service.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Un validador para el form de contact.
 * 
 * @author Muguruza
 *
 */
@Component
public class ContactValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ContactValidator.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "fullName", "FullNameRequired", "FullName should not be blank");
        ValidationUtils.rejectIfEmpty(errors, "email", "EmailRequired", "email should not be blank");
        ValidationUtils.rejectIfEmpty(errors, "comment", "CommentRequired", "comment should not be blank");

    }

}
