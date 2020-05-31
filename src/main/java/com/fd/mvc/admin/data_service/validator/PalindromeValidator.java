package com.fd.mvc.admin.data_service.validator;

import com.fd.mvc.admin.model.criteria.PalindromeSearchCriteria;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Example:
 * http://keylesson.com/index.php/2016/03/30/spring-mvc-validator-example-2696/
 * Un validador para el form de palindromo.
 * 
 * @author Muguruza
 *
 */
@Component
public class PalindromeValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PalindromeSearchCriteria.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PalindromeSearchCriteria palindromeSearchCriteria = (PalindromeSearchCriteria) target;
        ValidationUtils.rejectIfEmpty(errors, "phrase", "PhraseRequired", "Phrase should not be blank");

        String frase = StringUtils.stripToEmpty(palindromeSearchCriteria.getPhrase());
        if (frase.length() < 2) {
            errors.rejectValue("phrase", "PhraseSize", "Phrase should not < 2");
        }
    }

}
